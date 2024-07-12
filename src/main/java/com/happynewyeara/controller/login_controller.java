package com.happynewyeara.controller;

import com.happynewyeara.pojo.User;
import com.happynewyeara.service.register_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class login_controller {
    @Autowired
    private register_service registerservice;

    @RequestMapping("/api/user/login")
    public String register(User user) {
        boolean result = registerservice.register(user);
        if(result){
            return "success";
        }
        return "false";
    }
}
