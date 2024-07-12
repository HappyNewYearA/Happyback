package com.happynewyeara.service.impl;

import com.happynewyeara.dao.login_dao;
import com.happynewyeara.mapper.UserMapper;
import com.happynewyeara.service.login_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class login_service1 implements login_service {
    @Autowired
    private login_dao logindao;
    @Autowired
    private UserMapper userMapper;

    public String login(String phone_num, String code) {
        if(!userMapper.If_phone_num_exist(phone_num)){
            return "NotExist";
        }
        boolean flag_1 = userMapper.If_code_correct(phone_num, code);
        boolean flag_2 = userMapper.If_is_manager(phone_num);
        if(!flag_1){
            return "NotMatch";
        }
        if(flag_1 && flag_2){
            return "adminsuccess";
        }
        return "usersuccess";
    };
}
