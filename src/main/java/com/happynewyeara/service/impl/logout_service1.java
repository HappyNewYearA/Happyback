package com.happynewyeara.service.impl;

import com.happynewyeara.dao.logout_dao;
import com.happynewyeara.mapper.UserMapper;
import com.happynewyeara.service.logout_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class logout_service1 implements logout_service {
    @Autowired
    private logout_dao logout_dao;
    @Autowired
    private UserMapper userMapper;

    public String logout(String phone_num) {
        if(!userMapper.If_phone_num_exist(phone_num)){
            return "NotExist";
        }
        userMapper.update_logging_status_false(phone_num);
        return "Success";
    };
}