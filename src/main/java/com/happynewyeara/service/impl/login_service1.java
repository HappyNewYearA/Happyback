package com.happynewyeara.service.impl;

import com.happynewyeara.dao.login_dao;
import com.happynewyeara.service.login_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class login_service1 implements login_service {
    @Autowired
    private login_dao logindao;

    public boolean login() {
        return true;
    };
}
