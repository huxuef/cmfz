package com.baizhi.cmfz.serviceImpl;

import com.baizhi.cmfz.dao.CarouselDAO;
import com.baizhi.cmfz.entity.Carousel;
import com.baizhi.cmfz.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CarouselServiceImpl implements CarouselService {

    @Autowired
    private CarouselDAO carouselDAO;

    @Override
    public Carousel queryById(String id) {
        return carouselDAO.findById(id);
    }

    // 查所有
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Carousel> queryAll() {
        return carouselDAO.findAll();
    }

    // 分页查
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Carousel> queryBySplit(Integer curPage, Integer rows) {
        Integer start = (curPage-1)*rows;
        return carouselDAO.findBySplit(start,rows);
    }

    // 查总条数
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Long queryTotle() {
        return carouselDAO.findTotle();
    }

    // 增
    @Override
    public void addCarousel(Carousel carousel) {

        carousel.setId(UUID.randomUUID().toString());
        carouselDAO.insert(carousel);
    }

    // 改
    @Override
    public void modifyCarousel(Carousel carousel) {
        carouselDAO.update(carousel);
    }
}
