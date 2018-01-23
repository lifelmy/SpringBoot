package com.example.girl.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Aspect
@Component
public class HttpAspect {

    private final static Logger logger= LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.example.girl.controller.GirlController.*(..))")
    public void log(){
    }

        //方法执行之前
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        //logger.info("11111111");

        ServletRequestAttributes requestAttributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=requestAttributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURL());


        //method
        logger.info("method={}",request.getMethod());

        //ip
        logger.info("ip={}",request.getRemoteAddr());

        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());

        //args
        logger.info("args={}",joinPoint.getArgs());
    }

    //方法执行完之后
    @After("log()")
    public void doAfter(){
        logger.info("22222222");
    }


    //方法执行完之后的返回信息
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
       logger.info(object.toString());
    }
}
