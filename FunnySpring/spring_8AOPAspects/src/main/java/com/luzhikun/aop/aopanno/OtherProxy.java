package com.luzhikun.aop.aopanno;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author Rookie Coder
 * @Description
 * @Date
 **/
@Component
@Aspect
@Order(1)
public class OtherProxy {

    @Pointcut("execution(* com.luzhikun.aop.aopanno.UserDao.tell(..))")
    public void OtherPointCut(){
    }

    @After("OtherPointCut()")
    public void After(){
        System.out.println("这是Other类中的增强方法—最终通知");
    }

}
