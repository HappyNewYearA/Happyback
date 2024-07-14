package com.happynewyeara.mapper;

import com.happynewyeara.pojo.comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {

    @Insert("insert into comment(member_id, scene_id, create_time, status, content)" +
            "values (#{member_id},#{scene_id},#{create_time},true,#{content})")
    public void AddComment(comment comment);

    @Select("select count(*) from comment where member_id=#{member_id} and status=true")
    public boolean If_user_comment_exist(int member_id);

    @Select("select * from comment where member_id=#{member_id} and status=true")
    public List<comment> get_user_comment(int member_id);

    @Select("select * from comment where member_id!=#{member_id} and scene_id=#{scene_id} and status=true order by create_time desc")
    public List<comment> get_comment1(int member_id, int scene_id);

    @Select("select * from comment where member_id=#{member_id} and scene_id=#{scene_id} and status=true order by create_time desc")
    public List<comment> get_comment2(int member_id, int scene_id);
}