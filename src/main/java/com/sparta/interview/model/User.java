package com.sparta.interview.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;



@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Getter
@Entity // DB 테이블 역할을 합니다.
public class User {

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "user_id")
    private Long id;



    // unique: 중복 허용 여부 (false 일때 중복 허용)
    @Column(nullable = false)//중복 허용 X
    private String loginId;


    @Column(nullable = false)
    private String pw;

    @Column(nullable = false)
    private String username;





    public User(String loginId, String pw, String username) {
        this.loginId = loginId;
        this.pw= pw;
        this.username= username;
    }


}