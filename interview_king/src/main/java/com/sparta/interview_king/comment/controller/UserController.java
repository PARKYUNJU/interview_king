package com.sparta.interview_king.comment.controller;

import com.sparta.interview_king.comment.dto.LoginRequestDto;
import com.sparta.interview_king.comment.dto.SignupDto;
import com.sparta.interview_king.comment.model.User;
import com.sparta.interview_king.comment.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    //로그인
    @PostMapping("/user/login")
    public ResponseEntity login(@RequestBody LoginRequestDto loginRequestDto) {
        User user = userService.login(loginRequestDto);
        return new ResponseEntity(user, HttpStatus.OK);
    }

    // 회원 가입 요청 처리
    @PostMapping("/user/signup")
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