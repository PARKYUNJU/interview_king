package com.sparta.interview.controller;


import com.sparta.interview.dto.LoginRequestDto;
import com.sparta.interview.dto.SignupDto;
import com.sparta.interview.model.User;
import com.sparta.interview.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.*;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    //로그인
    @PostMapping("/api/login")
    public ResponseEntity login(@RequestBody LoginRequestDto loginRequestDto) {
        System.out.println(loginRequestDto.getLoginId());
        System.out.println(loginRequestDto.getPw());
        User user = userService.login(loginRequestDto);
        return new ResponseEntity(user, HttpStatus.OK);
    }

    // 회원 가입 요청 처리
    @PostMapping("/api/signup")
    public User registerUser(@Valid @RequestBody SignupDto requestDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> errorList = bindingResult.getAllErrors();
            for (ObjectError error : errorList)
                System.out.println(error.getDefaultMessage());
        }

        User user = userService.registerUser(requestDto);
        return user;
    }
}