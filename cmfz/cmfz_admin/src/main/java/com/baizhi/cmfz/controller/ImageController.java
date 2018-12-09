package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.util.ImageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
@RequestMapping("/image")
public class ImageController {

    // 生成验证码的方法
    @RequestMapping("/getImage.jpg")
    public String getImage(HttpSession session, HttpServletResponse response) throws IOException {
        ImageUtil imageUtil = new ImageUtil();
        // 1、获取随机字符
        String code = imageUtil.getCode();
        // 2、存储session作用域
        session.setAttribute("image",code);
        // 3、生成图片
        BufferedImage Image = imageUtil.getBuffImg();
        // 4、设置响应类型
        response.setContentType("image/png");
        ImageIO.write(Image,"png",response.getOutputStream());
        return null;
    }
}
