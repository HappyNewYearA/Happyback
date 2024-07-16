package com.happynewyeara.controller;

import com.happynewyeara.mapper.UserMapper;
import com.happynewyeara.pojo.Result;
import com.happynewyeara.pojo.img_result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class show_all_img_controller {
    @Autowired
    private com.happynewyeara.service.show_all_img_service show_all_img_service;
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/api/admin/img")
    public Result getImg_all() {
        List<img_result> result_temp = show_all_img_service.show_all_img();
        Result result = new Result(1, "success", result_temp);
        return result;
    }
}