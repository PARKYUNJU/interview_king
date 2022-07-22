package com.sparta.interview_king.model;


import com.sparta.interview_king.dto.CommentRequestDto;
import com.sparta.interview_king.timestamped.CommentTimestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter @Entity
@NoArgsConstructor
public class Comment extends CommentTimestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long postid;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String reply;

    @Column(nullable = false)
    private Long userId;

    public Comment(CommentRequestDto requestDto, Long userId) {
        this.postid = requestDto.getPostid();
        this.reply = requestDto.getReply();
        this.username = requestDto.getUsername();
        this.userId = userId;
    }

    public Comment(CommentRequestDto requestDto, Long userId, String reply) {
        this.postid = requestDto.getPostid();
        this.reply = reply;
        this.username = requestDto.getUsername();
        this.userId = userId;
    }


    public void update(CommentRequestDto requestDto) {
        this.reply = requestDto.getReply();
    }
}

