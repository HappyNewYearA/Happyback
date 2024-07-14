package com.happynewyeara.service;

import com.happynewyeara.pojo.comment_result;

import java.util.List;

public interface show_user_comment_service {
    public List<comment_result> show_user_comment(String phone_num);
}
