package com.happynewyeara.controller;


import com.happynewyeara.service.mute_service;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class mute_controller {
    @Autowired
    private mute_service mute_service;

    @RequestMapping("/api/admin/mute")
    public boolean mute(HttpServletRequest request) {
        String phone_num = request.getParameter("phone_num");
        return mute_service.mute(phone_num);
    }
}
