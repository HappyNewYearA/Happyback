package com.happynewyeara.controller;

import com.happynewyeara.pojo.User;
import com.happynewyeara.service.register_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class register_controller {
    @Autowired
    private register_service registerservice;

    @RequestMapping("/api/user/register")
    public boolean register(@RequestBody User user) {
        boolean result = registerservice.register(user);
        if(result){
            return true;
        }
        return false;
    }
}
