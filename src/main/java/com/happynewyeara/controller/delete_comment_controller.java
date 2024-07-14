package com.happynewyeara.controller;

import com.happynewyeara.service.delete_comment_service;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class delete_comment_controller {
    @Autowired
    private com.happynewyeara.service.delete_comment_service delete_comment_service;

    @RequestMapping("/api/comment/delete")
    public String register(HttpServletRequest request) {
        String phone_num = request.getParameter("phone_num");
        String scene_name = request.getParameter("scene_name");
        String content = request.getParameter("content");
        String create_time = request.getParameter("create_time");
        return delete_comment_service.deleteComment(phone_num, scene_name, content, create_time);
    }
}
