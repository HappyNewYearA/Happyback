package com.happynewyeara.service.impl;

import com.happynewyeara.dao.show_user_comment_dao;
import com.happynewyeara.mapper.CommentMapper;
import com.happynewyeara.mapper.SceneMapper;
import com.happynewyeara.mapper.UserMapper;
import com.happynewyeara.pojo.comment;
import com.happynewyeara.pojo.comment_result;
import com.happynewyeara.service.show_user_comment_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class show_user_comment_service1 implements show_user_comment_service {
    @Autowired
    private show_user_comment_dao show_user_commentDao;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private SceneMapper sceneMapper;

    public List<comment_result> show_user_comment(String phone_num) {
        if(!userMapper.If_phone_num_exist(phone_num)){
            return null;
        }
        int user_id = userMapper.get_id(phone_num);
        if(!commentMapper.If_user_comment_exist(user_id)){
            return null;
        }
        String user_name = userMapper.get_name(phone_num);
        List<comment> comment_list = commentMapper.get_user_comment(user_id);
        List<comment_result> comment_results = new ArrayList<>();
        for(comment Comment:comment_list){
            String scene_name = sceneMapper.get_scene_name(Comment.getScene_id());
            comment_results.add(new comment_result(Comment.getId(),Comment.getMember_id(),Comment.getContent(),scene_name,user_name,Comment.getCreate_time()));
        }
        return comment_results;
    };
}
