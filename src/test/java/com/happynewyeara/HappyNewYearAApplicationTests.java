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

//        User user=userMapper.If_logging("1234");
//        System.out.println(user.toString());
    }

}
