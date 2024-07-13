package com.happynewyeara.service.impl;

import com.happynewyeara.dao.start_dao;
import com.happynewyeara.mapper.UserMapper;
import com.happynewyeara.service.start_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class start_service1 implements start_service {
    @Autowired
    private start_dao startdao;
    @Autowired
    private UserMapper userMapper;

    public String start(String phone_num) {
        //判断用户登陆状态
        if (!userMapper.If_phone_num_exist(phone_num)){
            return "NotExist";
        }
        if(userMapper.If_logging(phone_num)){
            return "true";
        }
        return "false";
    };
}