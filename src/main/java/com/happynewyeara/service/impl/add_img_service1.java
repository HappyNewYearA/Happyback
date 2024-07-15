package com.happynewyeara.service.impl;

import com.happynewyeara.dao.add_img_dao;
import com.happynewyeara.mapper.ImgMapper;
import com.happynewyeara.mapper.SceneMapper;
import com.happynewyeara.mapper.UserMapper;
import com.happynewyeara.pojo.img;
import com.happynewyeara.service.add_img_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class add_img_service1 implements add_img_service {
    @Autowired
    private add_img_dao AddImgDao;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SceneMapper sceneMapper;
    @Autowired
    private ImgMapper imgMapper;

    public String Addimg(String phone_num, String scene_name, String url) {
        if(!userMapper.If_logging(phone_num)) {
            return "error";
        }
        if(!userMapper.If_phone_num_exist(phone_num)){
            return "UserNotExist";
        }
        if(!sceneMapper.If_scene_exist(scene_name)){
            return "SceneNotExist";
        }
        if(userMapper.If_banned(phone_num)){
            return "Banned";
        }
        Date d = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf3.format(d);
        int user_id = userMapper.get_id(phone_num);
        int scene_id = sceneMapper.get_id(scene_name);
        img img = new img(user_id,scene_id,date,url);
        imgMapper.AddImg(img);
        return "success";
    };
}