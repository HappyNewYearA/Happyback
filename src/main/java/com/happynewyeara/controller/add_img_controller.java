package com.happynewyeara.controller;

import com.happynewyeara.service.add_img_service;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class add_img_controller {
    @Autowired
    private add_img_service add_img_service;

    @RequestMapping("/api/img/add")
    public String register(HttpServletRequest request) {
        String phone_num = request.getParameter("phone_num");
        String scene_name = request.getParameter("scene_name");
        String url = request.getParameter("url");;
        return add_img_service.Addimg(phone_num, scene_name, url);
    }
}