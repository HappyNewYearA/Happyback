package com.happynewyeara.service.impl;

import com.happynewyeara.dao.delete_img_dao;
import com.happynewyeara.mapper.ImgMapper;
import com.happynewyeara.mapper.SceneMapper;
import com.happynewyeara.mapper.UserMapper;
import com.happynewyeara.service.delete_img_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class delete_img_service1 implements delete_img_service {
    @Autowired
    private delete_img_dao deleteImgDao;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SceneMapper sceneMapper;
    @Autowired
    private ImgMapper imgMapper;

    public String deleteimg(String phone_num, String scene_name, String url,String Create_time) {
        if(!userMapper.If_logging(phone_num)) {
            return "error";
        }
        if(!userMapper.If_phone_num_exist(phone_num)){
            return "UserNotExist";
        }
        if(!sceneMapper.If_scene_exist(scene_name)){
            return "SceneNotExist";
        }
        int user_id = userMapper.get_id(phone_num);
        int scene_id = sceneMapper.get_id(scene_name);
        if(imgMapper.If_img_exist(user_id,scene_id,Create_time,url)==0){
            return "ImgNotExist";
        }
        if(userMapper.If_banned(phone_num)){
            return "Banned";
        }
        if(imgMapper.If_img_exist(user_id,scene_id,Create_time,url)>1){
            imgMapper.delete_img(user_id,scene_id,Create_time,url);
            return "AllDeleted";
        }
        if(imgMapper.delete_img(user_id,scene_id,Create_time,url)){
            return "success";
        }
        return "Error";
    };
}