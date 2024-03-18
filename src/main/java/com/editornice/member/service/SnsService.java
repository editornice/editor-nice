package com.editornice.member.service;
import com.editornice.member.domain.Level;
import com.editornice.member.domain.Member;
import com.editornice.member.domain.SnsType;
import com.editornice.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional
public class SnsService extends DefaultOAuth2UserService {
    private final MemberRepository memberRepository;
    @Override
    public OAuth2User loadUser(OAuth2UserRequest memberRequest) throws OAuth2AuthenticationException{
        SnsType sns=null;
        Map<String,Object> attributes = super.loadUser(memberRequest).getAttributes();
        String nickname = null;
        String snsType= memberRequest.getClientRegistration().getRegistrationId();
        OAuth2User user2 =super.loadUser(memberRequest);

        if ("kakao".equals(snsType.toLowerCase())){
            sns= SnsType.KAKAO;
            nickname = "안녕";//((Map<String,Object>) attributes.get("properties")).get("nickname").toString();
        } else if ("google".equals(snsType.toLowerCase())) {
            sns= SnsType.GOOGLE;
            String email=attributes.get("email").toString();
            nickname = email.substring(0, email.indexOf("@"));//이메일을 잘라서 앞에부분만 저장해서 닉네임으로 활용
        }
        else if ("naver".equals(snsType.toLowerCase())) {
            sns= SnsType.NAVER;
            nickname = ((Map<String,Object>) attributes.get("response")).get("nickname").toString();
        }
        if(getMemberByNicknameAndSnsType(nickname,sns) == null){
            Member member =Member.builder()
                    .nickname(nickname)
                    .level(Level.EMPLOYER)
                    .snsType(sns).build();
            save(member);

        }
        return super.loadUser(memberRequest);
    }
    public void save(Member member){
        memberRepository.save(member);
    }
    public Member getMemberByNicknameAndSnsType(String nickname,SnsType snsType){
        return memberRepository.findByNicknameAndSnsType(nickname,snsType).orElse(null);
    }



}
