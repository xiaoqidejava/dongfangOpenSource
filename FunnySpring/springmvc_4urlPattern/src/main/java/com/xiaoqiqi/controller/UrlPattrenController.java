package com.xiaoqiqi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author Rookie Coder
 * @Description
 * @Date
 **/
@Controller
public class UrlPattrenController {

    @RequestMapping("/dourlpattern")
   public ModelAndView doUrlPattern(@RequestParam("cusername") String username,@RequestParam("cpassword") String password){
        ModelAndView md = new ModelAndView();
        md.addObject("username",username);
        md.addObject("password",password);
        // 设置视图名称
        md.setViewName("urlpattern");
        return md;
   }


}
