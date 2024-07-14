package com.happynewyeara.mapper;

import com.happynewyeara.pojo.User;
import org.apache.ibatis.annotations.*;


@Mapper
public interface UserMapper {

    @Insert("insert into user(phone_num, code,logging_status,If_manager,name,logging_time)" +
            "values (#{phone_num},#{code},#{logging_status},#{If_manager},#{name},#{logging_time})")
    public void insertUser(User user);
    //创建用户信息

    @Select("select count(*) from user where phone_num=#{phone_num}")
    public boolean If_phone_num_exist(String phone_num);
    //是否存在该手机号

    @Select("select count(*) from user where phone_num=#{phone_num} and code=#{code}")
    public boolean If_code_correct(String phone_num, String code);
    //验证手机号和密码

    @Select("select count(*) from user where phone_num=#{phone_num} and If_manager=true")
    public boolean If_is_manager(String phone_num);
    //验证密码和是否是管理员

    @Select("select Logging_status from user where phone_num=#{phone_num}")
    public boolean If_logging(String phone_num);
    //验证是否登录

    @Select("select id from user where phone_num=#{phone_num}")
    public int get_id(String phone_num);
    //获取用户id

    @Select("select name from user where phone_num=#{phone_num}")
    public String get_name(String phone_num);
    //根据手机号获取用户昵称

    @Select("select name from user where id=#{id}")
    public String get_name_id(int id);
    //根据id获取用户昵称

    @Select("select logging_status from user where phone_num=#{phone_num}")
    public boolean If_logging_status(String phone_num);
    //获取用户登录状态
}
