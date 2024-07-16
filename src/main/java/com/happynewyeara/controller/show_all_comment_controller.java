package com.happynewyeara.controller;

import com.happynewyeara.mapper.UserMapper;
import com.happynewyeara.pojo.Result;
import com.happynewyeara.pojo.comment_result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class show_all_comment_controller {
    @Autowired
    private com.happynewyeara.service.show_all_comment_service show_all_comment_service;
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/api/admin/comments")
    public Result getComment_all() {
        List<comment_result> result_temp = show_all_comment_service.show_all_comment();
        Result result = new Result(1, "success", result_temp);
        return result;
    }
}