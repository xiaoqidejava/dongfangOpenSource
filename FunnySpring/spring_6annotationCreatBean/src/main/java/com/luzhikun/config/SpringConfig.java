package com.luzhikun.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Rookie Coder
 * @Description
 * @Date
 **/
@Configuration // 注解作用就是告诉spring这个类是配置类，用来替代xml配置文件的
@ComponentScan(basePackages = {"com.luzhikun"})// 这个注解的作用是告诉Spring开启组件扫描
public class SpringConfig {
}
