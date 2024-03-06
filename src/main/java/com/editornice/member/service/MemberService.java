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

import java.util.Map;

@Service
@RequiredArgsConstructor
public class MemberService extends DefaultOAuth2UserService {
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
            nickname = ((Map<String,Object>) attributes.get("properties")).get("nickname").toString();
        } else if ("google".equals(snsType.toLowerCase())) {
            sns= SnsType.GOOGLE;
            nickname="기무찌현";//attributes.get("nickname").toString();
        }
        else if ("naver".equals(snsType.toLowerCase())) {
            sns= SnsType.NAVER;
            nickname = ((Map<String,Object>) attributes.get("response")).get("email").toString();
        }
        if(getMemberByNicknameAndLevel(nickname,sns) == null){
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
    public Member getMemberByNicknameAndLevel(String nickname,SnsType snsType){
        return memberRepository.findByNicknameAndSnsType(nickname,snsType).orElse(null);
    }


}
