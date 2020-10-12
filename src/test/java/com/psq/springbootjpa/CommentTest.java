package com.psq.springbootjpa;

import com.psq.springbootjpa.domain.Article;
import com.psq.springbootjpa.domain.Comment;
import com.psq.springbootjpa.service.ArticleService;
import com.psq.springbootjpa.service.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentTest {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ArticleService articleService;

    @Test
    public void saveCommentTest() {
        Article article = articleService.findArticle(18L);
        Comment comment = new Comment();
        comment.setContent("所谓互联网思维。。。。");
        comment.setArticle(article);
        commentService.saveComment(comment);
    }

    @Test
    public void deleteCommentTest() {
        commentService.deleteComment(25L);
    }
}
