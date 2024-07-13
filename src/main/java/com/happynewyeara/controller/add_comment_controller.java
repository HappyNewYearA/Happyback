package com.happynewyeara.controller;

import com.happynewyeara.service.add_comment_service;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class add_comment_controller {
    @Autowired
    private add_comment_service add_comment_service;

    @RequestMapping("/api/comment/add")
    public String register(HttpServletRequest request) {
        String phone_num = request.getParameter("phone_num");
        String scene_name = request.getParameter("scene_name");
        String content = request.getParameter("content");;
        return add_comment_service.AddComment(phone_num, scene_name, content);
    }
}