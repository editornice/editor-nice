package com.editornice.member.config;

import com.editornice.member.domain.Member;
import com.editornice.member.domain.SnsType;
import com.editornice.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class OAuthLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final MemberService memberService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken)authentication;

        String nickname=null;
        String snsType = token.getAuthorizedClientRegistrationId();
        SnsType sns=null;
        if ("Kakao".equals(snsType.toLowerCase())){
            nickname=((Map<String,Object>)token.getPrincipal().getAttribute("kakao_account")).get("nickname").toString();
            sns= SnsType.KAKAO;
        } else if ("google".equals(snsType.toLowerCase())) {
            nickname=token.getPrincipal().getAttribute("nickname").toString();
            sns= SnsType.GOOGLE;
        }else if ("naver".equals(snsType.toLowerCase())) {
            nickname=((Map<String,Object>)token.getPrincipal().getAttribute("response")).get("nickname").toString();
            sns= SnsType.NAVER;
        }
        Member member = memberService.getMemberByNicknameAndLevel(nickname,sns);

        HttpSession session=request.getSession();
        session.setAttribute("member",member);


        super.onAuthenticationSuccess(request, response, chain, authentication);
    }
}
