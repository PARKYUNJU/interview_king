package com.sparta.interview_king.comment.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter
@Table(name = "comments")
public class Comment {


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


}
