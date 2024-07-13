package com.happynewyeara.mapper;

import com.happynewyeara.pojo.User;
import com.happynewyeara.pojo.comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CommentMapper {

    @Insert("insert into comment(member_id, scene_id, create_time, status, content)" +
            "values (#{member_id},#{scene_id},#{create_time},true,#{content})")
    public void AddComment(comment comment);

}
