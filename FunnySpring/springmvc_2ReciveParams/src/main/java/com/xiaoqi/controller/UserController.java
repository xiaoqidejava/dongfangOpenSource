package com.xiaoqi.controller;

import com.xiaoqi.domain.User;
import com.xiaoqi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author Rookie Coder
 * @Description
 * @Date
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    // @Autowired
    //@Qualifier("userService")
    private UserService userService = new UserService() ;


    @RequestMapping(value = {"/selectUser","/insertUser"})
    public ModelAndView selectUser(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        ModelAndView md = new ModelAndView();
        List<User> users = userService.selectUser();
        // 添加数据 类似于request.setAttribute()
        md.addObject("user",users);
        // 设置视图名称
        md.setViewName("user");
        return md;
    }


    /*
     * @Author liu-miss
     * @Description reciveParams :逐个接收请求参数
     *    接收自定义的请求参数
     **/
    @RequestMapping(value = {"/selectUser","/insertUser"})
    public ModelAndView reciveParams(String username,int age){
        ModelAndView md = new ModelAndView();
        List<User> users = userService.selectUser();
        // 添加数据 类似于request.setAttribute()
        md.addObject("user",users);
        // 设置视图名称
        md.setViewName("user");
        return md;
    }

    /*
     * @Author liu-miss
     * @Description 使用对象形式接收请求参数
     *
     **/

    @RequestMapping("/usereciveParamBean")
    public ModelAndView reciveParamBean(User user){
        ModelAndView md = new ModelAndView();
        // 类似于req.setAttribute
        md.addObject("user",user.getUsername());
        md.addObject("pass",user.getPassword());
        md.setViewName("requestParamAnno");
        return md;
    }


    /*
     * @Author liu-miss
     * @Description @requestParams 注解解决请求参数名和形参不一致
     *
     **/

    @RequestMapping("/requestParamsAnno")
    public ModelAndView requestParamsAnno(@RequestParam("cusername") String username,@RequestParam("cpassword") String password){
        ModelAndView md = new ModelAndView();
        // 类似于req.setAttribute
        md.addObject("user",username);
        md.addObject("pass",password);
        md.setViewName("requestParamAnno");
        return md;
    }




}
