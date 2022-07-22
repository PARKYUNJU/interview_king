package com.sparta.interview_king.model;

import com.sparta.interview_king.timestamped.CommentTimestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class User extends CommentTimestamped {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    public User(String username, String password) { //유저 확인
        this.username = username;
        this.password = password;
    }


}