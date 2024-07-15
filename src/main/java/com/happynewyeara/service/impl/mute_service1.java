package com.happynewyeara.service.impl;

import com.happynewyeara.dao.mute_dao;
import com.happynewyeara.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.happynewyeara.service.mute_service;

@Component
public class mute_service1 implements mute_service{
    @Autowired
    private mute_dao mute_dao;
    @Autowired
    private UserMapper userMapper;

    public boolean mute(String phone_num){
        //判断用户手机号是否存在
        if(!userMapper.If_phone_num_exist(phone_num)){
            return false;
        }
       //禁言用户
        userMapper.mute_user(phone_num);
        return true;
    }
}
