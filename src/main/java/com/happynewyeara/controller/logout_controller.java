package com.happynewyeara.controller;

import com.happynewyeara.service.logout_service;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class logout_controller {
    @Autowired
    private logout_service logoutservice;

    @RequestMapping("/api/user/logout")
    public String register(HttpServletRequest request) {
        String phone_num = request.getParameter("phone_num");
        String result = logoutservice.logout(phone_num);
        return result;
    }
}