package com.happynewyeara.service;

import com.happynewyeara.common.ResultJson;

public interface delete_comment_service {
    public String deleteComment(String phone_num, String scene_name, String content,String Create_time);

    ResultJson deleteComment(String phone_num, String commentid);
}
