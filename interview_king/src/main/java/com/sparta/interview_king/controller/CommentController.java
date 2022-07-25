package com.sparta.interview_king.controller;

import com.sparta.interview_king.UserDetailsImpl;
import com.sparta.interview_king.dto.CommentRequestDto;
import com.sparta.interview_king.model.Comment;
import com.sparta.interview_king.repository.CommentRepository;
import com.sparta.interview_king.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class CommentController<userId> {

    private final CommentRepository CommentRepository;

    private final CommentService CommentService;

    @GetMapping("/api/comments/{postId}")
    public List<Comment> getReply(@PathVariable Long postId) {
        return CommentService.getComment(postId);
    }

    // 댓글 작성
    @PostMapping("/api/comments")
    public boolean createComment(@RequestBody CommentRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        // 로그인 확인하기
        if (userDetails != null) {
            Long userId = userDetails.getUser().getId();
            CommentService.createComment(requestDto, userId);
            return true;
        }
        return false;
    }

    // 댓글 수정
    @PutMapping("/api/comments/{id}")
    public Long updateReply(@PathVariable Long id, @RequestBody CommentRequestDto requestDto) {
        CommentService.update(id, requestDto);
        return id;
    }

    // 댓글 삭제
    @DeleteMapping("/api/comments/{id}")
    public Long deleteReply(@PathVariable Long id) {
        CommentRepository.deleteById(id);
        return id;
    }
}