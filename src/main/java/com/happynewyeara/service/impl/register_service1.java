package com.happynewyeara.service.impl;

import com.happynewyeara.dao.register_dao;
import com.happynewyeara.mapper.UserMapper;
import com.happynewyeara.pojo.User;
import com.happynewyeara.service.register_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class register_service1 implements register_service {
    @Autowired
    private register_dao registerdao;
    @Autowired
    private UserMapper userMapper;

    public boolean register(User user) {
        // 校验用户输入的手机号是否已经存在
        if(userMapper.If_phone_num_exist(user.getPhone_num())){
            return false;
        }
        // 注册时，需要对用户输入的密码进行加密处理
        // 这里省略加密处理的代码
        Date d = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf3.format(d);
        user.setLogging_time(date);
        userMapper.insertUser(user);
        return true;
    };
}
