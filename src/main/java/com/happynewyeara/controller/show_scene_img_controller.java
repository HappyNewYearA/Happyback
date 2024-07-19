package com.happynewyeara.controller;

import com.happynewyeara.mapper.UserMapper;
import com.happynewyeara.pojo.Result;
import com.happynewyeara.pojo.img_result;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class show_scene_img_controller {
    @Autowired
    private com.happynewyeara.service.show_scene_img_service show_scene_img_service;
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/api/scene/getImg")
    public Result getImg_user(HttpServletRequest request) {
        String phone_num = request.getParameter("phone_num");
        String scene_name = request.getParameter("scene_name");
        List<Object> objects = show_scene_img_service.show_scene_img(scene_name, phone_num);
        Result result = new Result(1, "success", objects);
        if(!userMapper.If_logging(phone_num)) {
            result.setResult(0);
            result.setMessage("not_login");
        }
        return result;
    }
}