package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Carousel;
import com.baizhi.cmfz.service.CarouselService;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import io.swagger.annotations.*;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "swagger controller",tags = "swagger 操作接口")
@RestController
@RequestMapping("/carousel")
public class CarouselController {

    @Autowired
    private CarouselService carouselService;
   /* @Autowired
    private FastFileStorageClient client;
*/
    // 查所有
    @ApiOperation(value = "查询所有轮播图信息")
    @RequestMapping(value = "/showAllCaroussel",method = RequestMethod.GET) // @GetMapping
    @ApiResponses({
            @ApiResponse(code = 404,message = "资源没有找到"),
            @ApiResponse(code = 400,message = "类型转换异常"),
            @ApiResponse(code = 500,message = "服务器内容错误"),
            @ApiResponse(code = 200,message = "处理正常")
    })
    public List<Carousel> showAllCaroussel(){
        List<Carousel> carousels = carouselService.queryAll();
        return carousels;
    }
    // 查单个
    @ApiOperation("根据id查轮播图详情信息")
    //@RequestMapping("/showOne")
    // public User showOne(@PathVariable(name="id") String id){  // 将uri中id占位的结果赋值给id形参
    @GetMapping("/showOne")
    @ApiResponses({
            @ApiResponse(code = 404,message = "资源没有找到"),
            @ApiResponse(code = 400,message = "类型转换异常"),
            @ApiResponse(code = 500,message = "服务器内容错误"),
            @ApiResponse(code = 200,message = "处理正常")
    })
    public Carousel showOne(@RequestParam(name="user_id") String id){ // 通过requestParam注解指定前台请求参数和后台形参的映射关系
        Carousel carousel = carouselService.queryById(id);
        return carousel;
    }

    // 分页查询
    @ApiOperation("分页查询轮播图信息")
    //@RequestMapping("/showCaroussel")
    @GetMapping("/showCaroussel")
    @ApiImplicitParams(value={
            @ApiImplicitParam(name="page",value = "当前页",required = true,paramType = "query",dataType = "int"),
            @ApiImplicitParam(name="rows",value="每页展示的行数",required = true,paramType = "query",dataType = "int")
    })
    public Map<String,Object > showCaroussel(Integer page,Integer rows){
        List<Carousel> carousels = carouselService.queryBySplit(page, rows);
        Long total = carouselService.queryTotle();
        Map<String,Object > map =new HashMap<String,Object >();
        map.put("total",total);
        map.put("rows",carousels);
        return map;
    }

    //增
    /*//@RequestMapping("/addCarousel")
    @ApiOperation("新增轮播图信息")
    @PostMapping("/addCarousel")
    public Map<String,Object> addCarousel(@RequestBody
                                          @ApiParam(value = "轮播图对象",required = true)Carousel carousel, MultipartFile aa){
                                         // 直接将请求体（json）解析为Carousel对象 json--->Carousel
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
    }*/

    // 修改
    //@RequestMapping("/updateCarousel")
    @ApiOperation("根据轮播图信息修改为新的信息")
    @PutMapping("/updateCarousel")
    public Map<String,Object> updateCarousel(@RequestBody Carousel carousel){
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
