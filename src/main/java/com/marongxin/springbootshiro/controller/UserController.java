package com.marongxin.springbootshiro.controller;

import com.marongxin.springbootshiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {


    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        System.out.println("hello shiro");
        return "ok";
    }

    @RequestMapping("/testThymeleaf")
    public String testThymeleaf(Model model) {
        model.addAttribute("name", "marongxin");
//        返回test.html
        return "test";
    }

    @GetMapping("/add")
    public String add() {
        return "/user/add";
    }

    @GetMapping("/update")
    public String update() {
        return "/user/update";
    }

    @GetMapping("/toLogin")
    public String toLogin() {
        return "/user/login";
    }

    @PostMapping("/login")
    public String login(String name, String password, Model model) {
        /*
         * 使用shiro认证
         * */
        //1.获取subject
        Subject subject = SecurityUtils.getSubject();

        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);

        //3.执行登录方法
        try {
            subject.login(token);
            //登录成功，跳转到test.html
            //return "redirect:/testThymeleaf";这种方式无法传递model
            return "redirect:/testThymeleaf";
        } catch (UnknownAccountException e) {
            //登录失败
            model.addAttribute("msg", "用户名不存在");
            return "user/login";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误");
            return "user/login";
        }
    }

    @GetMapping("/noAuth")
    public String noAuth() {
        return "user/noAuth";
    }


}
