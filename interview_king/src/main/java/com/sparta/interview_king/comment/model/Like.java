package com.sparta.interview_king.comment.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "likes")
public class Like {

    @Id
    @GeneratedValue
    @Column(name = "like_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
