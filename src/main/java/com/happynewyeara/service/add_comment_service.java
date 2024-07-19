package com.happynewyeara.service;

import com.happynewyeara.common.ResultJson;

public interface add_comment_service {
    public ResultJson AddComment(String phone_num, String scene_name, String content);
}
