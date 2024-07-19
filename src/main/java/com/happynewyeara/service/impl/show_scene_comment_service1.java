package com.happynewyeara.service.impl;

import com.happynewyeara.dao.show_scene_comment_dao;
import com.happynewyeara.mapper.CommentMapper;
import com.happynewyeara.mapper.SceneMapper;
import com.happynewyeara.mapper.UserMapper;
import com.happynewyeara.pojo.comment;
import com.happynewyeara.pojo.comment_result;
import com.happynewyeara.service.show_scene_comment_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class show_scene_comment_service1 implements show_scene_comment_service {
    @Autowired
    private show_scene_comment_dao show_scene_comment_dao;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private SceneMapper sceneMapper;

    public List<comment_result> show_scene_comment(String scene_name,String phone_num) {
        List<comment_result> comment_results = new ArrayList<>();
        if(!userMapper.If_phone_num_exist(phone_num)){
            return comment_results;
        }
        if(!sceneMapper.If_scene_exist(scene_name)){
            return comment_results;
        }
        int scene_id = sceneMapper.get_id(scene_name);
        int user_id = userMapper.get_id(phone_num);

       /* List<comment> comment_list1 = commentMapper.get_comment1(user_id, scene_id);
        List<comment> comment_list2 = commentMapper.get_comment2(user_id, scene_id);*/

        List<comment> comment_list2 = commentMapper.get_comment3(user_id, scene_id);

        for(comment Comment:comment_list2){
            String user_name = userMapper.get_name_id(Comment.getMember_id());
            comment_results.add(new comment_result(Comment.getId(),Comment.getMember_id(),Comment.getContent(),scene_name,user_name,Comment.getCreate_time()));

        }
       // int i=0;
     /*   for(comment Comment:comment_list1){
            String user_name = userMapper.get_name_id(Comment.getMember_id());
            comment_results.add(new comment_result(Comment.getId(),Comment.getMember_id(),Comment.getContent(),scene_name,user_name,Comment.getCreate_time()));
            if(++i==9){
                break;
            }
        }*/
        return comment_results;
    };
}