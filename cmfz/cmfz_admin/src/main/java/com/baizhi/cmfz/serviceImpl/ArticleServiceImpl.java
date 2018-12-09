package com.baizhi.cmfz.serviceImpl;

import com.baizhi.cmfz.dao.ArticleDAO;
import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDAO articleDAO;

    // 查所有文章
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Article> queryAllArticle() {
        return articleDAO.findAll();
    }

    // 创建文章
    @Override
    public void addArticle(Article article) {
        article.setId(UUID.randomUUID().toString());
        articleDAO.insert(article);
    }

    // 查单个文章
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Article queryOneArticle(String id) {
        return articleDAO.findById(id);
    }

    // 修改文章内容
    @Override
    public void modifyArticle(Article article) {
        articleDAO.update(article);
    }
}
