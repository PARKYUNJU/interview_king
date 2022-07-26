package com.sparta.interview_king.comment.model;


import com.sparta.interview_king.comment.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter @Setter
public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    // 로그인 ID
    @Column(nullable = false)
    private String loginId;

    // 로그인 PW
    @NonNull
    @Column(nullable = false)
    private String password;

    // 닉네임
    @Column(nullable = false)
    private String username;

    @OneToMany(mappedBy = "user")
    private List<Like> likes = new ArrayList<Like>();

    @OneToMany(mappedBy = "user")
    private List<Comment> comments = new ArrayList<Comment>();

    public User(String loginId, String password, String username) {
        this.loginId = loginId;
        this.password= password;
        this.username= username;
    }



}
