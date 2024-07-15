package com.happynewyeara.service.impl;

import com.happynewyeara.dao.de_mute_dao;
import com.happynewyeara.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.happynewyeara.service.de_mute_service;

@Component
public class de_mute_service1 implements de_mute_service{
    @Autowired
    private de_mute_dao de_mute_dao;
    @Autowired
    private UserMapper userMapper;

    public boolean de_mute(String phone_num){
        //判断用户手机号是否存在
        if(!userMapper.If_phone_num_exist(phone_num)){
            return false;
        }
        //禁言用户
        userMapper.de_mute_user(phone_num);
        return true;
    }
}
