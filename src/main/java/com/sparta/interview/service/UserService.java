package com.sparta.interview.service;


import com.sparta.interview.dto.LoginRequestDto;
import com.sparta.interview.dto.SignupDto;
import com.sparta.interview.model.User;
import com.sparta.interview.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Pattern;


@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User login(LoginRequestDto loginRequestDto){
        System.out.println(loginRequestDto.getLoginId());
        User user = userRepository.findByLoginId(loginRequestDto.getLoginId())
                .get();
        if (user != null) {
            if (passwordEncoder.matches(loginRequestDto.getPw(),user.getPw())) { //requestdto가 원래 저장되어있는거, user이 받은거
                System.out.println("로그인 성공");
                return user;
            }
        } else {
            throw new NullPointerException("사용자가 존재하지 않습니다");
        }
        throw new NullPointerException("사용자가 존재하지 않습니다");    }


    //@Transactional
    public User registerUser(SignupDto requestDto) {
        String loginId = requestDto.getLoginId();
        String password = requestDto.getPw();
        String passwordcheck = requestDto.getPwcheck();
        String username = requestDto.getUsername();
        String pattern = "^[a-zA-Z0-9`~!@#$%^&*()-_=+]{3,}$";//대소문자,숫자,특수문자


        Optional<User> found = userRepository.findByLoginId(loginId);
        if (found.isPresent()) {
            throw new NullPointerException("이미 존재하는 아이디입니다.");
        }

        if (!Pattern.matches(pattern, password))
            throw new NullPointerException("비밀번호는 대소문자와 숫자를 포함해주세요.");

        if (password.length()<4)
            throw new NullPointerException("비밀번호는 4자이상 입력해주세요.");

        if (!Objects.equals(password,passwordcheck))
            throw new NullPointerException("비밀번호가 일치하지 않습니다.");

        password = passwordEncoder.encode(requestDto.getPw());//비밀번호 암호화
        requestDto.setPw(password);//암호화된 비밀번호 set
        User user = new User(loginId,password,username);
        userRepository.save(user);
        return user;

    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}

