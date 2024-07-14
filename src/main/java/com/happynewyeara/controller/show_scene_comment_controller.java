package com.happynewyeara.controller;

import com.happynewyeara.pojo.comment_result;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class show_scene_comment_controller {
    @Autowired
    private com.happynewyeara.service.show_scene_comment_service show_scene_comment_service;

    @RequestMapping("/api/scene/getComment")
    public List<comment_result> getComment_user(HttpServletRequest request) {
        String phone_num = request.getParameter("phone_num");
        String scene_name = request.getParameter("scene_name");
        List<comment_result> result = show_scene_comment_service.show_scene_comment(scene_name, phone_num);
        return result;
    }
}