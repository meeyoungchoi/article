package com.example.article.controller;

import com.example.article.entity.Comment;
import com.example.article.form.CommentForm;
import com.example.article.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class CommentApiController {

    private final CommentRepository commentRepository;

    @PostMapping("/api/comments/{articleId}")
    public Long newComments(@PathVariable Long articleId, @RequestBody CommentForm commentForm) {
        log.info(articleId +"번 댓글");
        log.info(commentForm.toString());

        Comment comment = commentForm.toEntity();
        log.info(comment.toString());

        Comment saved = commentRepository.save(comment);
        log.info(saved.toString());

        return saved.getId();
    }
}
