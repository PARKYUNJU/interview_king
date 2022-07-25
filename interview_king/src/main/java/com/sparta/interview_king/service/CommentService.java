package com.sparta.interview_king.service;

import com.sparta.interview_king.dto.CommentRequestDto;
import com.sparta.interview_king.model.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CommentService {

    private final com.sparta.interview_king.repository.CommentRepository CommentRepository;

    // 댓글 조회
    public List<Comment> getComment(Long postId) {
        return CommentRepository.findAllByPostidOrderByCreatedAtDesc(postId);
    }

    // 댓글 작성
    @Transactional
    public Comment createComment(CommentRequestDto requestDto, Long userId) {
        String replyCheck = requestDto.getReply();
        if (replyCheck.contains("script") || replyCheck.contains("<") || replyCheck.contains(">")) {
            Comment comment = new Comment(requestDto, userId, "잘못된 입력입니다(XSS 공격금지)");
            CommentRepository.save(comment);
            return comment;
        }
        Comment comment = new Comment(requestDto, userId);
        CommentRepository.save(comment);
        return comment;
    }

    // 댓글 수정
    @Transactional
    public void update(Long id, CommentRequestDto requestDto) {
        Comment comment = CommentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("댓글이 존재하지 않습니다")
        );
        comment.update(requestDto);
    }
}

