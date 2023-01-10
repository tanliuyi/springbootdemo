package com.example.demo.mapper;

import com.example.demo.model.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper {
    int insertArticle(Article article);
    int updateArticle(Article article);
    int deleteArticleByIds(@Param("ids")String[] ids);
    List<Article> findAllArticles();
}
