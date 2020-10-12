package com.psq.springbootjpa.service;

import com.psq.springbootjpa.domain.Comment;
import org.springframework.stereotype.Service;

public interface CommentService {

    Comment saveComment(Comment comment);

    void deleteComment(Long id);
}
