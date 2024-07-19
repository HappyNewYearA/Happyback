package com.happynewyeara.controller;

import com.happynewyeara.common.ResultJson;
import com.happynewyeara.mapper.UserMapper;
import com.happynewyeara.service.start_service;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class user_controller {

    @Autowired
    private start_service StartService;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/api/getUserName")
    public ResultJson getUserName(HttpServletRequest request){
        String phoneNum = request.getParameter("phone_num");
        String start = StartService.start(phoneNum);
        if ("NotExist".equals(start)||"false".equals(start)){
         return ResultJson.error("非法访问！");
        }
        String name = userMapper.get_name(phoneNum);
        return ResultJson.success(name);


    }

}
