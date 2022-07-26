package com.sparta.interview_king.comment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
public class SignupDto {
    private String loginId;
    private String username;
    private String password;
    private String passwordcheck;


}