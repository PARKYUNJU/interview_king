package com.sparta.interview.dto;

import lombok.*;



@Getter
@Setter
@NoArgsConstructor
public class SignupDto {
    private String loginId;
    private String username;
    private String pw;
    private String pwcheck;


}