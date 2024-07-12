package com.happynewyeara;

import com.happynewyeara.mapper.UserMapper;
import com.happynewyeara.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HappyNewYearAApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testInsert(){
        User user = new User("1234", "Tom", false,false,"123","123");
        userMapper.insertUser(user);
    }

}
