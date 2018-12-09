package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.entity.Result;
import com.baizhi.cmfz.service.ArticleService;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private FastFileStorageClient client;

    // 展示所有
    @RequestMapping("/showAllArticle")
    @RequiresPermissions("article:showAllArticle")
    public List<Article> showAllArticle(){
        List<Article> articles = articleService.queryAllArticle();
        return articles;
    }


    // 上传图片(先上传照片，再上传文章)
    @RequestMapping("/uploadImg")
    public Result uploadImg(MultipartFile keyName){
        Result result = new Result();
        try {
            // 照片上传到本地服务器
//            String path = request.getSession().getServletContext().getRealPath("/") + "upload/" + keyName.getOriginalFilename();
//            keyName.transferTo(new File(path));


            // InputStream inputStream = file.getInputStream();
            // 调用fastdfs分布式文件系统 上传文件的api 将图片上传到文件系统
            // file_id  group+path
            // http://192.168.128.134:8888/group/path
            StorePath uploadFile = client.uploadFile(keyName.getInputStream(), keyName.getSize(),
                    FilenameUtils.getExtension(keyName.getOriginalFilename()), null);
            String fileGroup = uploadFile.getGroup();
            String filePath = uploadFile.getPath();

            // 将路径响应给前台，使其可以在页面显示上传的图片
            result.setErrno(0);
            String[] data = new String[1];
            data[0]= "http://192.168.131.129:8888/"+fileGroup+"/"+filePath;
            result.setData(data);
            System.out.println("上传结果" + result);
        } catch (Exception e) {
            e.printStackTrace();
            result.setErrno(1);
        }
        return result;
    }

    // 上传文章
    @RequestMapping("/uploadArticle")
    public Map<String,Object> uploadArticle(Article article) {
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            articleService.addArticle(article);
            map.put("success","创建文章成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success","创建文章失败");
        }
        return map;

    }

    // 文章详情
    @RequestMapping("/showOneArticle")
    public String showOneArticle(String id){
        Article article = articleService.queryOneArticle(id);
        return article.getContent();

    }

    // 修改文章内容
    @RequestMapping("/updateArticle")
    public Map<String,Object> updateArticle(Article article){
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            articleService.modifyArticle(article);
            map.put("success","修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success","修改失败");
        }
        return map;
    }

}


