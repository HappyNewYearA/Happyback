package com.happynewyeara.controller;

import com.happynewyeara.common.ResultJson;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class delete_img_controller {
    @Autowired
    private com.happynewyeara.service.delete_img_service delete_img_service;

    @RequestMapping("/api/img/delete")
    public ResultJson register(HttpServletRequest request) {
        String phone_num = request.getParameter("phone_num");
        String scene_name = request.getParameter("scene_name");
        String url = request.getParameter("url");
        String create_time = request.getParameter("create_time");
        return delete_img_service.deleteimg(phone_num, scene_name, url, create_time);
    }
}
