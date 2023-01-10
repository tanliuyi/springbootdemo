package com.example.demo.service;

import com.example.demo.model.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleService {
    int AddNewArticle(Article article);
    List<Article> getArticles();
    int delArticleByIds( String ids);
}
