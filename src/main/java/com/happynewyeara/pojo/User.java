package com.happynewyeara.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    //private int id;//用户id
    private String phone_num;//手机号
    private String code;//密码
    private boolean logging_status;//登录状态
    private boolean If_manager;//是否是管理员
    private String name;//昵称
    private String logging_time;//登录时间
}
