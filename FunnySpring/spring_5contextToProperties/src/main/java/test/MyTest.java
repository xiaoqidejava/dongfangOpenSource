package test;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author Rookie Coder
 * @Description spring如何引入外部属性文件来配置bean
 * @Date
 **/

public class MyTest {

    @Test
    public void  test1(){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        DruidDataSource dataSource = context.getBean("dataSource", DruidDataSource.class);
        System.out.println(dataSource);
    }

}
