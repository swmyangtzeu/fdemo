package com.swm.fdemo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/fdemo")
public class HelloController {
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHello(){
        return "Hello";
    }

/*    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(){
        return "login success";
    }

    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public String logout(){
        return "logout success";
    }*/

    @RequestMapping("/")
    public String index() {
        return "访问了首页哦";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "不验证哦";
    }

    @PreAuthorize("hasAuthority('TEST')")//有TEST权限的才能访问
    @RequestMapping("/security")
    public String security() {
        return "hello world security";
    }

    @PreAuthorize("hasAuthority('ADMIN')")//必须要有ADMIN权限的才能访问
    @RequestMapping("/authorize")
    public String authorize() {
        return "有权限访问";
    }
}
