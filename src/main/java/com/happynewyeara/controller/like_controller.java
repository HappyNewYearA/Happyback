package com.happynewyeara.controller;

import com.happynewyeara.service.like_service;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class like_controller {
    @Autowired
    private like_service likeservice;

    @RequestMapping("/api/scene/like")
    public boolean like(HttpServletRequest request) {
        String scene_name = request.getParameter("scene_name");
        boolean result = likeservice.like(scene_name);
        return result;
    }
}
