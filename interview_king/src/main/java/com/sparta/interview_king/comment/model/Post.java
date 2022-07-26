package com.sparta.interview_king.comment.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private int id;


   private String title;

   private String companyname;

   private String stack;

   private String content;

   private Boolean interview;

   // java 8  부터 사용가능한 기능 시간
   private LocalDateTime postDate;

   private Date date;


    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<Comment>();


}
