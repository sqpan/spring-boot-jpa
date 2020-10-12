package com.psq.springbootjpa;

import com.alibaba.fastjson.JSON;
import com.psq.springbootjpa.domain.Article;
import com.psq.springbootjpa.domain.Comment;
import com.psq.springbootjpa.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleTest {

    @Autowired
    private ArticleService articleService;

    @Test
    public void saveArticle() {
        Article article = new Article();
        article.setTitle("吹哨人");
        article.setContent("武汉医生的一生");

        Comment comment1 = new Comment("好人");
        Comment comment2 = new Comment("一出悲剧");

        article.addComment(comment1);
        article.addComment(comment2);

        articleService.saveArticle(article);
    }

    @Test
    public void updateArticle() {
        Article article = articleService.findArticle(18L);
        article.setContent("讲述武汉吹哨人的故事");
        articleService.updateArticle(article);
    }

    @Test
    public void findArticle() {
        Article article = articleService.findArticle(18L);
        System.out.println(JSON.toJSONString(article, true));
    }

    @Test
    public void deleteArticle() {
        articleService.deleteArticle(21L);
    }
}
