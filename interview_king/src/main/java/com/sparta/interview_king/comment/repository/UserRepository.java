package com.sparta.interview_king.comment.repository;

import com.sparta.interview_king.comment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLoginId(String loginId); //아이디로 user 찾기
}
