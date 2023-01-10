package com.example.demo;

import com.example.demo.mapper.ArticleMapper;
import com.example.demo.model.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookService bookService;

    @Autowired
    private ArticleMapper articleMapper;

    @Test
    void contextLoads() {
        List<Book> books = bookService.getAllBooks();
        System.out.println(books);
    }

    @Test
    void insertBook(){
        Book book = new Book();
        book.setName("abc");
        book.setAuthor("abc");
        book.setPress("abc");
        int count = bookService.insertBook(book);
        System.out.println(count);
    }

    @Test
    void insertArticle(){
        Article article = new Article();
        article.setTitle("测试标题");
        article.setMdContent("测试MD内容");
        article.setHtmlContent("测试HTML内容");
        for (int i = 0; i < 5; i++){
            articleMapper.insertArticle(article);
        }
    }


}
