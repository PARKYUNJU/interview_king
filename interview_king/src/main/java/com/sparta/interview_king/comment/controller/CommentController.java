package com.sparta.interview_king.comment.controller;


import com.sparta.interview_king.comment.dto.CommentRequestDto;
import com.sparta.interview_king.comment.model.Comment;
import com.sparta.interview_king.comment.repository.CommentRepository;
import com.sparta.interview_king.comment.security.UserDetailsImpl;
import com.sparta.interview_king.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController<userId> {

    private final CommentRepository CommentRepository;
    private final CommentService CommentService;


    @GetMapping("/api/comment/{postId}")
    public List<Comment> getComment(@PathVariable Long postId) {
        return CommentService.getComment(postId);
    }

    // 댓글 작성
    @PostMapping("/api/comment")
    public boolean createComment(@RequestBody CommentRequestDto requestDto,
                                 @AuthenticationPrincipal UserDetailsImpl userDetails) {

        //로그인 확인하기
        if (userDetails != null) {
            Long userId = userDetails.getUser().getId();
            CommentService.createComment(requestDto, userId);
            return true;
        }
        return false;
    }

    // 댓글 수정
    @PutMapping("/api/comment/{id}")
    public Long updateComment(@PathVariable Long id,
                              @RequestBody CommentRequestDto requestDto) {

        CommentService.update(id, requestDto);
        return id;
    }

    // 댓글 삭제
    @DeleteMapping("/api/comment/{id}")
    public Long deleteComment(@PathVariable Long id) {
        CommentRepository.deleteById(id);
        return id;
    }


}
