package com.happynewyeara.controller;

import com.happynewyeara.mapper.UserMapper;
import com.happynewyeara.pojo.Result;
import com.happynewyeara.pojo.img_result;
import com.happynewyeara.service.show_user_img_service;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class show_user_img_controller {
    @Autowired
    private show_user_img_service show_user_img_service;
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/api/user/getImg")
    public Result getImg_user(HttpServletRequest request) {
        String phone_num = request.getParameter("phone_num");
        List<img_result> result_temp = show_user_img_service.show_user_img(phone_num);
        Result result = new Result(1, "success", result_temp);
        if(!userMapper.If_logging(phone_num)) {
            result.setResult(0);
            result.setMessage("not_login");
        }
        return result;
    }
}