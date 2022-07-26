package com.sparta.interview_king.comment.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsServiceImpl userDetailsService;

    public WebSecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public BCryptPasswordEncoder encodePassword() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.authorizeRequests()

                .antMatchers("/images/**").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/user/**").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/index/**").permitAll()
                .antMatchers("/detail.html/**").permitAll()
                .antMatchers("/api/**").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/**").permitAll()
                .antMatchers("*").permitAll()

                // 그 외 모든 요청은 인증과정 필요
                .anyRequest().authenticated();
//                .and()
//                .formLogin()
//                .usernameParameter("loginId")
//                .passwordParameter("password")
//                .loginPage("/user/login")
//                .loginProcessingUrl("/user/login")
//                .failureUrl("/user/login/error")
//                .defaultSuccessUrl("/")
//                .failureUrl("/user/login?error")
//                .permitAll()
//                .and()
//                .logout()
//                .logoutUrl("/user/logout")
//                .logoutSuccessUrl("/")
//                .permitAll();

        http.httpBasic();
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {

        return super.authenticationManagerBean();
    }
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        auth.eraseCredentials(false);
    }
}