package com.happynewyeara.service.impl;

import com.happynewyeara.dao.add_comment_dao;
import com.happynewyeara.dao.delete_comment_dao;
import com.happynewyeara.mapper.CommentMapper;
import com.happynewyeara.mapper.SceneMapper;
import com.happynewyeara.mapper.UserMapper;
import com.happynewyeara.pojo.comment;
import com.happynewyeara.service.delete_comment_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class delete_comment_service1 implements delete_comment_service {
    @Autowired
    private delete_comment_dao deleteCommentDao;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SceneMapper sceneMapper;
    @Autowired
    private CommentMapper commentMapper;

    public String deleteComment(String phone_num, String scene_name, String content,String Create_time) {
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
        if(commentMapper.If_comment_exist(user_id,scene_id,Create_time,content)==0){
            return "CommentNotExist";
        }
        if(commentMapper.If_comment_exist(user_id,scene_id,Create_time,content)>1){
            commentMapper.delete_comment(user_id,scene_id,Create_time,content);
            return "AllDeleted";
        }
        if(commentMapper.delete_comment(user_id,scene_id,Create_time,content)){
            return "success";
        }
        return "Error";
    };
}