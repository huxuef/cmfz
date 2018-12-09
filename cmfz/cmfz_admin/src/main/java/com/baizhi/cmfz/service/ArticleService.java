package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Article;

import java.util.List;

public interface ArticleService {
    // 查所有
    public List<Article> queryAllArticle();

    // 创建文章
    void addArticle(Article article);

    // 查单个文章
    Article queryOneArticle(String id);

    // 修改文章内容
    void modifyArticle(Article article);
}
