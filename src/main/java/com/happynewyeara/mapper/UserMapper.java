package com.happynewyeara.mapper;

import com.happynewyeara.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("insert into user(phone_num, code,logging_status,If_manager,name,logging_time)" +
            "values (#{phone_num},#{code},#{logging_status},#{If_manager},#{name},#{logging_time})")
    public void insertUser(User user);

    @Select("select * from user")
    public List<User> list();
    
}
