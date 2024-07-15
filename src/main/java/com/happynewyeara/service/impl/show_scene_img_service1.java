package com.happynewyeara.service.impl;

import com.happynewyeara.dao.show_scene_img_dao;
import com.happynewyeara.mapper.ImgMapper;
import com.happynewyeara.mapper.SceneMapper;
import com.happynewyeara.mapper.UserMapper;
import com.happynewyeara.pojo.img;
import com.happynewyeara.pojo.img_result;
import com.happynewyeara.service.show_scene_img_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class show_scene_img_service1 implements show_scene_img_service {
    @Autowired
    private show_scene_img_dao show_scene_img_dao;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ImgMapper imgMapper;
    @Autowired
    private SceneMapper sceneMapper;

    public List<img_result> show_scene_img(String scene_name,String phone_num) {
        if(!userMapper.If_phone_num_exist(phone_num)){
            return null;
        }
        if(!sceneMapper.If_scene_exist(scene_name)){
            return null;
        }
        int scene_id = sceneMapper.get_id(scene_name);
        int user_id = userMapper.get_id(phone_num);
        if(!imgMapper.If_user_img_exist(user_id)){
            return null;
        }
        List<img> img_list1 = imgMapper.get_img1(user_id, scene_id);
        List<img> img_list2 = imgMapper.get_img2(user_id, scene_id);
        List<img_result> img_results = new ArrayList<>();
        for(img Img:img_list2){
            String user_name = userMapper.get_name_id(Img.getMember_id());
            img_results.add(new img_result(Img.getUrl(),scene_name,user_name,Img.getCreate_time()));
            break;
        }
        int i=0;
        for(img Img:img_list1){
            String user_name = userMapper.get_name_id(Img.getMember_id());
            img_results.add(new img_result(Img.getUrl(),scene_name,user_name,Img.getCreate_time()));
            if(++i==9){
                break;
            }
        }
        return img_results;
    };
}