package com.happynewyeara.service;

import com.happynewyeara.pojo.comment_result;

import java.util.List;

public interface show_scene_comment_service {
    public List<comment_result> show_scene_comment(String scene_name, String phone_num);
}
