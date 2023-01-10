package com.example.demo.service.impl;

import com.example.demo.mapper.ArticleMapper;
import com.example.demo.model.Article;
import com.example.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;


    @Override
    public int AddNewArticle(Article article) {
        // 处理文章摘要
        if(article.getSummary() == null || "".equals(article.getSummary())){
            String stripHtml = stripHtml(article.getHtmlContent());
            article.setSummary(stripHtml.substring(0, stripHtml.length() > 50 ? 50 : stripHtml.length()));
        }
        // 设置发表时间与编辑时间
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        article.setPublishDate(timestamp);
        article.setEditTime(timestamp);
        return articleMapper.insertArticle(article);
    }

    @Override
    public List<Article> getArticles() {
        return articleMapper.findAllArticles();
    }

    @Override
    public int delArticleByIds(String ids) {
        String[] split = ids.split(",");
        int result = articleMapper.deleteArticleByIds(split);
        return result;
    }

    public String stripHtml(String content){
        return content.replaceAll("<p .*?>", "")
                .replaceAll("<br\\\\s*/?>", "")
                .replaceAll("\\\\<.*?>", "");
    }
}
