package com.happynewyeara.controller;


import com.happynewyeara.service.de_mute_service;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("*")
public class de_mute_controller {
    @Autowired
    private de_mute_service de_mute_service;

    @RequestMapping("/api/admin/de_mute")
    public boolean de_mute(HttpServletRequest request) {
        String userId = request.getParameter("userId");
        return de_mute_service.de_mute(userId);
    }
}