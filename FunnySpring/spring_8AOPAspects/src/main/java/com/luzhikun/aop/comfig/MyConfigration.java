package com.luzhikun.aop.comfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author Rookie Coder
 * @Description 配置类
 * @Date
 **/
@Configuration // 代表这是配置类
@ComponentScan(basePackages = {"com.luzhikun.aop"})// 开启组件扫描
@EnableAspectJAutoProxy(proxyTargetClass = true)// 开启自动生成代理对象
public class MyConfigration {
}
