package com.baizhi.test;

import com.baizhi.cmfz.Application;
import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class TestArticle {

    @Autowired
    private ArticleService articleService;

    @Test
    public void testQueryAll(){
        List<Article> articles = articleService.queryAllArticle();
        for (Article article : articles) {
            System.out.println(article);
        }
    }

    @Test
    public void testAdd(){
        Article article = new Article("5","as","nnn","1","1","1",new java.util.Date(),new Master());
        articleService.addArticle(article);
    }

    @Test
    public void testQueryOne(){
        Article article = articleService.queryOneArticle("1868c80f-d3a4-4685-acfc-5dda93abfa5b");
        System.out.println(article);
    }


}
