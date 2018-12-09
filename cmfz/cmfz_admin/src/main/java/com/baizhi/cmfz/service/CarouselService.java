package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Carousel;

import java.util.List;

public interface CarouselService {

    // 查单个
    public Carousel queryById(String id);
    // 查所有
    public List<Carousel> queryAll();
    // 分页查
    public List<Carousel> queryBySplit(Integer curPage, Integer rows);

    // 查总条数
    public Long queryTotle();

    // 增
    public void addCarousel(Carousel carousel);

    // 改
    public void modifyCarousel(Carousel carousel);
}
