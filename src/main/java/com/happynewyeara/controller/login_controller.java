package com.happynewyeara.controller;

import com.happynewyeara.service.login_service;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class login_controller {
    @Autowired
    private login_service loginservice;

    @RequestMapping("/api/user/login")
    public String login(HttpServletRequest request) {
        String phone_num = request.getParameter("phone_num");
        String code = request.getParameter("code");
        String result = loginservice.login(phone_num, code);
        return result;
    }
}
