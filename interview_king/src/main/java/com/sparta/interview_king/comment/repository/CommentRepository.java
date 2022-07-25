package com.sparta.interview_king.comment.repository;

import com.sparta.interview_king.comment.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByPostidOrderByCreatedAtDesc(Long postId);


}
