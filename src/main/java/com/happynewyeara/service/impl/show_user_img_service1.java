package com.happynewyeara.service.impl;

import com.happynewyeara.dao.show_user_img_dao;
import com.happynewyeara.mapper.ImgMapper;
import com.happynewyeara.mapper.SceneMapper;
import com.happynewyeara.mapper.UserMapper;
import com.happynewyeara.pojo.img;
import com.happynewyeara.pojo.img_result;
import com.happynewyeara.service.show_user_img_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class show_user_img_service1 implements show_user_img_service {
    @Autowired
    private show_user_img_dao show_user_imgDao;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ImgMapper imgMapper;
    @Autowired
    private SceneMapper sceneMapper;

    public List<img_result> show_user_img(String phone_num) {
        if(!userMapper.If_phone_num_exist(phone_num)){
            return null;
        }
        int user_id = userMapper.get_id(phone_num);
        if(!imgMapper.If_user_img_exist(user_id)){
            return null;
        }
        String user_name = userMapper.get_name(phone_num);
        List<img> img_list = imgMapper.get_user_img(user_id);
        List<img_result> img_results = new ArrayList<>();
        for(img Img:img_list){
            String scene_name = sceneMapper.get_scene_name(Img.getScene_id());
            img_results.add(new img_result(Img.getUrl(),scene_name,user_name,Img.getCreate_time()));
        }
        return img_results;
    };
}
