package com.sparta.interview_king.comment.model;


import com.sparta.interview_king.comment.dto.CommentRequestDto;
import lombok.Getter;
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
    private String loginId;

    // 로그인 PW
    private String password;

    // 닉네임
    private String nickname;

    @OneToMany(mappedBy = "user")
    private List<Like> likes = new ArrayList<Like>();

    @OneToMany(mappedBy = "user")
    private List<Comment> comments = new ArrayList<Comment>();



}
