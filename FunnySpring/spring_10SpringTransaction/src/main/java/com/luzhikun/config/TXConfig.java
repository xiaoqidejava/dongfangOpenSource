package com.luzhikun.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.sun.org.apache.bcel.internal.generic.DADD;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author Rookie Coder
 * @Description
 * @Date
 **/
@Configuration // 代表这是一个配置类
@ComponentScan(basePackages = "com.luzhikun")// 组件扫描
@EnableTransactionManagement // 开启事务注解
public class TXConfig {

    // 创建连接池对象
    @Bean
    public DruidDataSource getDruidDataSource(){
        DruidDataSource  dataSource =new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/springdb");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("140489lu");
        return dataSource;
    }


    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource){
        JdbcTemplate jdbcTemplate =new JdbcTemplate();
        // 注入dataSource
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    // 创建事务管理器对象
    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource){
        DataSourceTransactionManager da= new DataSourceTransactionManager();
        da.setDataSource(dataSource);
        return da;
    }

}
