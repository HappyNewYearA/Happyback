package com.happynewyeara.service.impl;

import com.happynewyeara.dao.register_dao;
import com.happynewyeara.mapper.UserMapper;
import com.happynewyeara.pojo.User;
import com.happynewyeara.service.register_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class register_service1 implements register_service {
    @Autowired
    private register_dao registerdao;
    @Autowired
    private UserMapper userMapper;

    public boolean register(User user) {
        Date d = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf3.format(d);
        user.setLogging_time(date);
        userMapper.insertUser(user);
        return true;
    };
}
