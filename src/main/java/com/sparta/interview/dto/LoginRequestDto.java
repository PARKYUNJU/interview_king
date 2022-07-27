package com.sparta.interview.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDto {
    private String loginId;
    private String pw;
}