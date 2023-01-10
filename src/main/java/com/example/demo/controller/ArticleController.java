package com.example.demo.controller;

import com.example.demo.model.Article;
import com.example.demo.service.ArticleService;
import com.example.demo.utils.Result;
import com.example.demo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/articles", method = RequestMethod.POST)
    public Result addArticle(@RequestBody Article article) {
        int result = articleService.AddNewArticle(article);
        if(result == 1){
            return ResultUtil.success(result);
        }else {
            return ResultUtil.error(400, "文章创建失败");
        }
    }

    @RequestMapping(value = "/articles", method = RequestMethod.GET)
    public Result findAllArticles() {
        List<Article> articles = articleService.getArticles();
        return ResultUtil.success(articles);
    }

    @RequestMapping(value = "/articles/{ids}", method = RequestMethod.DELETE)
    public Result deleteByIds(@PathVariable String ids){
        int result = articleService.delArticleByIds(ids);
        return ResultUtil.success(result);
    }


}
