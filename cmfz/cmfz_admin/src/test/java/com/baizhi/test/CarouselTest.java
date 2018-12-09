package com.baizhi.test;

import com.baizhi.cmfz.Application;
import com.baizhi.cmfz.entity.Carousel;
import com.baizhi.cmfz.service.CarouselService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class CarouselTest {

    @Autowired
    private CarouselService carouselService;

    @Test
    public void testQueryBySplit(){
        List<Carousel> carousels = carouselService.queryBySplit(1, 2);
        for (Carousel carousel : carousels) {
            System.out.println(carousel);
        }
    }

    @Test
    public void testQueryTotle(){
        Long aLong = carouselService.queryTotle();
        System.out.println(aLong);
    }

    @Test
    public void testAdd(){
        Carousel carousel = new Carousel();
        carousel.setId(UUID.randomUUID().toString());
        carousel.setName("清明上河图");
        carousel.setImgUrl("/不知道");
        carousel.setCreateDate(new java.util.Date());
        carousel.setStatus("未展示");
        carouselService.addCarousel(carousel);
    }

    @Test
    public void testUpdate(){
        Carousel carousel = new Carousel();
        carousel.setId("61d99d8d-f6a9-43cd-bd42-71a85fce1273");
        carousel.setName("清明上河图");
        carousel.setImgUrl("/不知道");
        carousel.setCreateDate(new java.util.Date());
        carousel.setStatus("展示中");
        carouselService.modifyCarousel(carousel);
    }
}
