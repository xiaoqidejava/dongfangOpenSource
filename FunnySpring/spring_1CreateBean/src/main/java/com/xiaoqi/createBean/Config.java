package com.xiaoqi.createBean;

import com.xiaoqi.createBean.domain.User;
import org.springframework.context.annotation.Bean;

/**
 * @Author Rookie Coder
 * @Description
 * @Date
 **/
public class Config {

    @Bean
    public User user(){
        return  new User();
    }

}
