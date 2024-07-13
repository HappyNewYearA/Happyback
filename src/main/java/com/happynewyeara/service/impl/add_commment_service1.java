package com.happynewyeara.service.impl;

import com.happynewyeara.dao.add_comment_dao;
import com.happynewyeara.mapper.CommentMapper;
import com.happynewyeara.mapper.SceneMapper;
import com.happynewyeara.mapper.UserMapper;
import com.happynewyeara.pojo.comment;
import com.happynewyeara.service.add_comment_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class add_commment_service1 implements add_comment_service {
    @Autowired
    private add_comment_dao AddCommentDao;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SceneMapper sceneMapper;
    @Autowired
    private CommentMapper commentMapper;

    public String AddComment(String phone_num, String scene_name, String content) {
        if(!userMapper.If_phone_num_exist(phone_num)){
            return "UserNotExist";
        }
        if(!sceneMapper.If_scene_exist(scene_name)){
            return "SceneNotExist";
        }
        Date d = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf3.format(d);
        int user_id = userMapper.get_id(phone_num);
        int scene_id = sceneMapper.get_id(scene_name);
        comment comment = new comment(user_id,scene_id,date,content);
        commentMapper.AddComment(comment);
        return "success";
    };
}