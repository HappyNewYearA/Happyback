package com.happynewyeara.service.impl;

import com.happynewyeara.dao.like_dao;
import com.happynewyeara.mapper.SceneMapper;
import com.happynewyeara.service.like_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class like_service1 implements like_service {
    @Autowired
    private like_dao likedao;
    @Autowired
    private SceneMapper sceneMapper;
    public boolean like(String scene_name) {
        if(!sceneMapper.If_scene_exist(scene_name)) {
            return false;
        }
        sceneMapper.add_like_num(scene_name);
        return true;
    };
}
