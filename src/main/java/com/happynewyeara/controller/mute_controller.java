package com.happynewyeara.controller;


import com.happynewyeara.service.mute_service;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("*")
public class mute_controller {
    @Autowired
    private mute_service mute_service;

    @RequestMapping("/api/admin/mute")
    public boolean mute(HttpServletRequest request) {
        String userId = request.getParameter("userId");
        return mute_service.mute(userId);
    }
}
