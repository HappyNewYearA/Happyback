package com.happynewyeara.service.impl;

import com.happynewyeara.dao.show_all_comment_dao;
import com.happynewyeara.mapper.CommentMapper;
import com.happynewyeara.mapper.SceneMapper;
import com.happynewyeara.mapper.UserMapper;
import com.happynewyeara.pojo.comment;
import com.happynewyeara.pojo.img_result;
import com.happynewyeara.service.show_all_img_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class show_all_img_service1 implements show_all_img_service {
    @Autowired
    private show_all_comment_dao show_all_comment_dao;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SceneMapper sceneMapper;
    @Autowired
    private CommentMapper commentMapper;
    public List show_all_img(String type)
    {

        List<comment> img_list = commentMapper.get_all_img();
        List<img_result> img_results = new ArrayList<>();

        for(comment Comment:img_list){
            String scene_name = sceneMapper.get_scene_name(Comment.getScene_id());
            String user_name = userMapper.get_name_id(Comment.getMember_id());
            img_results.add(new img_result(Comment.getContent(),scene_name,user_name,Comment.getCreate_time()));
        }

        return img_results;

    }
}