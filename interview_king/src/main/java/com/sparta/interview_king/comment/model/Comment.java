package com.sparta.interview_king.comment.model;


import com.sparta.interview_king.comment.dto.CommentRequestDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter
@Table(name = "comments")
public class Comment extends Timestamped {


    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    private int id;

    private String content;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Comment(CommentRequestDto requestDto, Long userId) {
        this.content = requestDto.getContent();
    }
    public Comment(CommentRequestDto requestDto, Long userId, String content) {
        this.content = content;
    }



    public void update(CommentRequestDto requestDto) {
        this.content = requestDto.getContent();
    }
}
