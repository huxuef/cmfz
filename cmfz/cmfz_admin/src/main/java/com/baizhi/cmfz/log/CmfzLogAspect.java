package com.baizhi.cmfz.log;

import com.baizhi.cmfz.dao.LogDAO;
import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.LogService;
import com.baizhi.cmfz.serviceImpl.LogServiceImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Aspect
@Component
public class CmfzLogAspect {

    @Autowired
    private LogDAO logDAO;

    // 切入点
    @Pointcut("execution(* com.baizhi.cmfz.serviceImpl..*.modify*(..)) || " +
            "execution(* com.baizhi.cmfz.serviceImpl..*.add*(..)) || " +
            "execution(* com.baizhi.cmfz.serviceImpl..*.remove*(..))")
    public void pc(){}


    /*@Around("pc()")
    public void around1(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        *//*Object target = proceedingJoinPoint.getTarget();
        String name = target.getClass().getName();
        String substring = name.substring(28);
        String[] strings = substring.split("ServiceImpl");
        System.out.println(strings[0]);*//*

     *//* Object target = proceedingJoinPoint.getTarget();
        String name = target.getClass().getName();
        String[] split = name.split(".");
        for (String s : split) {
            System.out.println("ssssssssssssssssssssssssss    "+s);
        }
*//*

     *//*  Object[] args = proceedingJoinPoint.getArgs();
        for (Object arg : args) {
            System.out.println(arg.toString());
        }*//*
    }*/


    // 环绕通知
    @Around("pc()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("----------do before---------");
        Log log = new Log();
        //LogService logService = new LogServiceImpl();
        try {


            // 获取request
            ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpServletRequest request = servletRequestAttributes.getRequest();

            // 获取登录用户信息,,并设置给log中user字段
            Manager manager = (Manager) request.getSession().getAttribute("manager");
            log.setId(UUID.randomUUID().toString());
            log.setUser(manager.getName());
            //log.setUser("lalala");
            log.setOptionTime(new java.util.Date());

            // 获取目标类
            Object target = proceedingJoinPoint.getTarget();
            String name = target.getClass().getName();
            String substring = name.substring(28);
            String[] strings = substring.split("ServiceImpl");
            // 操作的哪一个类
            log.setResource(strings[0]);

            // 进行的什么操作   增、删、改
            String methodName = proceedingJoinPoint.getSignature().getName();
            if(methodName.contains("add")){
                log.setAction("新增");
            }
            if(methodName.contains("remove")){
                log.setAction("删除");
            }
            if(methodName.contains("modify")){
                log.setAction("修改");
            }

            // 设置message
            Object[] args = proceedingJoinPoint.getArgs();
            for (Object arg : args) {
                log.setMessage(arg.toString());
            }

            // 不出现异常，说明操作成功
            Object proceed = proceedingJoinPoint.proceed();

            // 结果
            log.setResult("success");

        } catch (Throwable throwable) {
            // 出现异常，说明操作失败
            log.setResult("failure ");
            System.out.println("----------do after 异常----------");
            throwable.printStackTrace();
        }
        System.out.println(log);
        //System.out.println(logService);
        logDAO.insert(log);
        //logService.addLog(log);

    }
}
