package com.editornice.member.config;

import com.editornice.member.service.SnsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final OAuthLoginSuccessHandler oAuthLoginSuccessHandler;
    private final OAuthLoginFailureHandler oAuthLoginFailureHandler;
    private final SnsService memberService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                //.loginPage("/login") <<나중에 로그인페이지 추가되면 설정
                .oauth2Login()
                .userInfoEndpoint()
                .userService(memberService)
                .and()
                .successHandler(oAuthLoginSuccessHandler)
                .failureHandler(oAuthLoginFailureHandler);
    }
}
