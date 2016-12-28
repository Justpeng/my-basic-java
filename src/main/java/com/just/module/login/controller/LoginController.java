package com.just.module.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录
 *
 * @author:Just
 * @create:2016-12-12 20:40
 */
@Controller(value = "/login")
public class LoginController {
    @RequestMapping(value = "/register")
    public String doRegister(HttpServletRequest request , HttpServletResponse response){


        return "";
    }
}
