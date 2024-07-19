package com.happynewyeara.service.impl;

import com.happynewyeara.common.ResultJson;
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

    public ResultJson login(String phone_num, String code) {
        if(!userMapper.If_phone_num_exist(phone_num)){
            return ResultJson.error("NotExist") ;
        }
        boolean flag_1 = userMapper.If_code_correct(phone_num, code);
        boolean flag_2 = userMapper.If_is_manager(phone_num);
        if(!flag_1){
            return ResultJson.error("NotMatch");
        }
        if(flag_1 && flag_2){
            userMapper.update_logging_status_true(phone_num);
            return ResultJson.success("adminsuccess");
        }
        userMapper.update_logging_status_true(phone_num);

        String name = userMapper.get_name(phone_num);
        return ResultJson.success("usersuccess",name);
    };
}
