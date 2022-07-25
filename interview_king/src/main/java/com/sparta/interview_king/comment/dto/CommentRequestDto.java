package com.sparta.interview_king.comment.dto;

import lombok.Getter;

import java.util.Date;

@Getter
public class CommentRequestDto {
    private String content;
    private Date date;
}
