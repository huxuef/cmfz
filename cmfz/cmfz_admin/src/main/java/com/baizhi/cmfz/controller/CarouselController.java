package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Carousel;
import com.baizhi.cmfz.service.CarouselService;
import com.github.tobato.fastdfs.domain.MataData;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;

@RestController
@RequestMapping("/carousel")
public class CarouselController {

    @Autowired
    private CarouselService carouselService;
    @Autowired
    private FastFileStorageClient client;

    // 查所有
    @RequestMapping("/showAllCaroussel")
    public List<Carousel> showAllCaroussel(){
        List<Carousel> carousels = carouselService.queryAll();
        return carousels;
    }
    // 查单个
    @RequestMapping("/showOne")
    public Carousel showOne(String id){
        Carousel carousel = carouselService.queryById(id);
        return carousel;
    }

    // 分页查询
    @RequestMapping("/showCaroussel")
    public Map<String,Object > showCaroussel(Integer page,Integer rows){
        List<Carousel> carousels = carouselService.queryBySplit(page, rows);
        Long total = carouselService.queryTotle();
        Map<String,Object > map =new HashMap<String,Object >();
        map.put("total",total);
        map.put("rows",carousels);
        return map;
    }

    //增
    @RequestMapping("/addCarousel")
    public Map<String,Object> addCarousel(Carousel carousel, MultipartFile aa){
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            // 文件上传==使用fastdfs,参数1：输入流，参数2：文件大小，参数3：文件扩展名，
            StorePath uploadFile = client.uploadFile(aa.getInputStream(), aa.getSize(),
                    FilenameUtils.getExtension(aa.getOriginalFilename()), null);

            // 调用业务方法
            carousel.setImgUrl(uploadFile.getGroup()+"/"+uploadFile.getPath());
            carouselService.addCarousel(carousel);
            map.put("success","添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success","添加失败");
        }
        return map;
    }

    // 修改
    @RequestMapping("/updateCarousel")
    public Map<String,Object> updateCarousel(Carousel carousel){
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            carouselService.modifyCarousel(carousel);
            map.put("success","修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success","修改失败");
        }
        return map;
    }


}
