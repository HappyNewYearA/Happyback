package com.happynewyeara.mapper;

import com.happynewyeara.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface SceneMapper {

    @Select("select id from scene where scene_name=#{scene_name}")
    public int get_id(String scene_name);
    //获取景点id

    @Select("select count(*) from scene where scene_name=#{scene_name}")
    public boolean If_scene_exist(String scene_name);
    //是否存在该景点

    @Select("select scene_name from scene where id=#{id}")
    public String get_scene_name(int id);
    //获取景点名称

    @Update("update scene set like_num=like_num+1 where scene_name=#{scene_name}")
    public boolean add_like_num(String scene_name);
    //点赞



}
