package com.sparta.interview_king.dto;

import lombok.Getter;
@Getter
public class CommentRequestDto {
    private Long postid;
    private String username;
    private String reply;
    private Long userId;
}