package com.happynewyeara.controller;

import com.happynewyeara.pojo.comment_result;
import com.happynewyeara.service.show_user_comment_service;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class show_user_comment_controller {
    @Autowired
    private show_user_comment_service show_user_comment_service;

    @RequestMapping("/api/user/getComment")
    public List<comment_result> getComment_user(HttpServletRequest request) {
        String phone_num = request.getParameter("phone_num");
        List<comment_result> result = show_user_comment_service.show_user_comment(phone_num);
        return result;
    }
}