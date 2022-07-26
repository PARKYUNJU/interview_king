package com.sparta.interview_king.comment.service;

import com.sparta.interview_king.comment.dto.CommentRequestDto;
import com.sparta.interview_king.comment.model.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final com.sparta.interview_king.comment.repository.CommentRepository CommentRepository;

    //댓글 조회
    public List<Comment> getComment(Long postId) {
        return CommentRepository.findAllByIdOrderByCreatedAtDesc(postId);
    }

    //댓글 작성
    @Transactional
    public Comment createComment(CommentRequestDto requestDto, Long userId) {
        String commentCheck = requestDto.getContent();
        if (commentCheck.contains("script")|| commentCheck.contains("<")||commentCheck.contains(">")){
            Comment comment = new Comment(requestDto, userId,"잘못된 입력입니다.");
            CommentRepository.save(comment);
            return comment;
        }
        Comment comment = new Comment(requestDto, userId);
        CommentRepository.save(comment);
        return comment;
    }


    //댓글 수정
    @Transactional
    public void update(Long id, CommentRequestDto requestDto) {
        Comment Comment = CommentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("댓글이 존재하지 않습니다")
        );
        Comment.update(requestDto);
    }


}
