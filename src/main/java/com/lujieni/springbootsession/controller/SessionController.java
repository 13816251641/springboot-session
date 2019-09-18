package com.lujieni.springbootsession.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class SessionController {

    /** 放入session进redis */
    @GetMapping("/setSession")
    public String setSession(HttpServletRequest request){
        request.getSession().setAttribute("LoginUser", "亲爱的EASTW用户");
        return request.getSession().getId();
    }

    /** 获取session */
    @GetMapping("/getSession")
    public String getSession(HttpServletRequest request){
        String attribute = (String) request.getSession().getAttribute("LoginUser");
        return attribute;
    }

}
