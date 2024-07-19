package com.happynewyeara.service.impl;

import com.happynewyeara.dao.show_all_comment_dao;
import com.happynewyeara.mapper.CommentMapper;
import com.happynewyeara.mapper.SceneMapper;
import com.happynewyeara.mapper.UserMapper;
import com.happynewyeara.pojo.comment;
import com.happynewyeara.pojo.comment_result;
import com.happynewyeara.service.show_all_comment_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class show_all_comment_service1 implements show_all_comment_service {
    @Autowired
    private show_all_comment_dao show_all_comment_dao;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SceneMapper sceneMapper;
    @Autowired
    private CommentMapper commentMapper;
    public List<comment_result> show_all_comment()
    {
        List<comment> comment_list = commentMapper.get_all_comment();
        List<comment_result> comment_results = new ArrayList<>();
        for(comment Comment:comment_list){
            String scene_name = sceneMapper.get_scene_name(Comment.getScene_id());
            String user_name = userMapper.get_name_id(Comment.getMember_id());
            comment_results.add(new comment_result(Comment.getId(),Comment.getMember_id(),Comment.getContent(),scene_name,user_name,Comment.getCreate_time()));
        }

        return comment_results;

    }
}
