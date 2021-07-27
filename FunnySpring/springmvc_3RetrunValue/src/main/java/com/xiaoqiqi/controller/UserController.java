package com.xiaoqiqi.controller;

import com.google.gson.Gson;
import com.xiaoqiqi.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author Rookie Coder
 * @Description
 * @Date
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    /*
     * @Author liu-miss
     * @Description 返回值类型为String
     * String类型返回值代表的是视图名称，
     *
     **/

    @RequestMapping("/returnValueString")
    public String returnString(User user){
        System.out.println(user.getCusername()+user.getCpassword());
        return "show";
    }

    /*
     * @Author liu-miss
     * @Description void返回值
     * 返回值void只能做ajax操作，void返回值本身并不能返回数据，也不能返回视图
     **/

    @RequestMapping("/doAjax")
    public  void returnVoidDoAjax(String username, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        // 调用service层处理请求
        // 获取结果，封装处理结果，再由resp对象的打印流进行返回
        System.out.println(username);
        // 处理ajax 需要返回json格式数据
        String json = new Gson().toJson(username);
        PrintWriter writer = response.getWriter();
        // 将ajax返回到回调函数
        writer.write(json);
        writer.flush();
        writer.close();
    }

    /*
     * @Author liu-miss
     * @Description Object返回值
     * 返回值Object来做ajax操作极为简单，
     * 实现步骤：
     *  1.加入json依赖，springMVC默认使用jackSon
     *
     *  2.在springMVC配置文件中加入<mvc:annotation-driven>注解驱动
     *      这个注解驱动的功能就是类似于下面这个代码，实现的是将处理结果封装成一个json格式的对象
     *  String json = new Gson().toJson(username);
     *
     *  3.在处理器方法上边加入@ResponseBody注解
     *      这个注解实现的功能就是类似于下面的代码，将封装好的json格式数据写出去
     *   response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        将ajax返回到回调函数
        writer.write(json);
        writer.flush();
        writer.close();
     **/

    @RequestMapping("/doAjax")
    @ResponseBody
    public  User returnObjectDoAjax(User user, HttpServletResponse response) throws IOException {
        // 调用service层处理请求
        // 获取结果，封装处理结果，再由resp对象的打印流进行返回
        User user1 = new User(user.getCusername(),user.getCusername());
        return user1;
    }


    /*
     * @Author liu-miss
     * @Description 当控制器方法上边加入了@ResponseBody注解之后，
     * String返回值就可以表示数据,而浏览器默认使用的是text/plain;charset=utf-8数据格式
     *作为contentType，因此会导致中文有乱码。
     * 解决方案：给RequestMapping增加一个属性 produces，使用这个属性指定新的contentType
     **/

    @RequestMapping(value = "/returnStringValue",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String returnStringValue(){
        return "i am the best!";
    }

}
