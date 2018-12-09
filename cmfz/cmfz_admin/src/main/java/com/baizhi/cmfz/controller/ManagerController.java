package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;


    // 登录
    /*@RequestMapping("/login")
    public Map<String,Object> login(String enCode,Boolean isRememberUsername, String name, String password,HttpSession session){
        Map<String,Object> map = new HashMap<String, Object>();
        System.out.println("isRememberUsername:"+isRememberUsername);
        System.out.println("password:" +password);
        try {
            // 先判断验证码是否正确
            String image = (String) session.getAttribute("image");
            if(image.equalsIgnoreCase(enCode)){
                // 通过安全工具类获取主体对象
                Subject subject = SecurityUtils.getSubject();

                subject.login(new UsernamePasswordToken(name,password,isRememberUsername));
                // 登录成功，存入一个标志
                map.put("success",true);
                //return "redirect:/back/main/main/main.jsp";
            }else{
                throw new RuntimeException("验证码错误");
            }
        } catch (RuntimeException e) {
           //return "/back/login/login.jsp";
            // 登录失败，存入一个标志
            map.put("success",false);
            // 将错误信息响应以json格式给前台
            map.put("message",e.getMessage());
            System.out.println("jjihfhafuywdfuysf");
        }
        return map;
    }*/



    // 登陆
    @RequestMapping("/login")
    @ResponseBody
    public Map<String,Object> login(String enCode,Boolean isRememberUsername, String name, String password, HttpServletRequest request, HttpServletResponse response,HttpSession session){
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            // 先判断验证码是否正确
            String image = (String) session.getAttribute("image");
            if(image.equalsIgnoreCase(enCode)){
                Manager manager = managerService.login(name, password);
                // 登录成功，存入session
                session.setAttribute("manager",manager);
                // 登录成功，存入一个标志
                map.put("success",true);

                // 创建cookie
                Cookie nameCookie = new Cookie("name", URLEncoder.encode(name,"UTF-8"));
                // 设置cookie的路径
                nameCookie.setPath(request.getContextPath()+"/");
                // 获取是否保存cookie
                if(!isRememberUsername) {// 不保存用户名
                    nameCookie.setMaxAge(0);
                }else{//保存Cookie的时间长度，单位为秒
                    nameCookie.setMaxAge(7*24*60*60);
                }
                //加入Cookie到响应头
                response.addCookie(nameCookie);

            }else{
                throw new RuntimeException("验证码错误");
            }
        } catch (Exception e) {
            // 登录失败，存入一个标志
            map.put("success",false);
            // 将错误信息响应以json格式给前台
            map.put("message",e.getMessage());
        }
        return map;
    }
}

