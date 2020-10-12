package com.psq.springbootjpa.service;

import com.psq.springbootjpa.domain.Article;

public interface ArticleService {

    Article saveArticle(Article article);

    Article updateArticle(Article article);

    Article findArticle(Long id);

    void deleteArticle(Long id);

}
