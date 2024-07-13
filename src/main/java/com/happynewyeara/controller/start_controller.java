package com.happynewyeara.controller;

import com.happynewyeara.service.register_service;
import com.happynewyeara.service.start_service;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class start_controller {
    @Autowired
    private start_service StartService;
    @RequestMapping("/api/user/start")
    public String start(HttpServletRequest request) {
        String phone_num = request.getParameter("phone_num");
        return StartService.start(phone_num);
    }
}
