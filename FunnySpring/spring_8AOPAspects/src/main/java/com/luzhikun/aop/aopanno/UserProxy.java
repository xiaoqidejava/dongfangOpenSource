package com.luzhikun.aop.aopanno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author Rookie Coder
 * @Description 进行增强的类
 * @Date
 **/
@Component
@Aspect
@Order(3)
public class UserProxy {

    // 相同的切入点抽取
    @Pointcut(value = "execution(* com.luzhikun.aop.aopanno.UserDao.tell(..))")
    public void pointdemo(){

    }

    @Before("pointdemo()")
    public void before(){
        System.out.println("前置通知");
    }

    // 最终通知
    @After("execution(* com.luzhikun.aop.aopanno.UserDao.tell(..))")
    public void After(){
        System.out.println("After通知");
    }

    // 后置通知
    @AfterReturning("execution(* com.luzhikun.aop.aopanno.UserDao.tell(..))")
    public void AfterReturning(){
        System.out.println("AfterReturning通知");
    }

    // 异常通知
    @AfterThrowing("execution(* com.luzhikun.aop.aopanno.UserDao.tell(..))")
    public void AfterThrowing(){
        System.out.println("AfterThrowing通知");
    }


    @Around("execution(* com.luzhikun.aop.aopanno.UserDao.tell(..))")
    public void Around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("环绕之前");
        // 执行被增强的方法
        proceedingJoinPoint.proceed();
        System.out.println("环绕之后");

    }
}
