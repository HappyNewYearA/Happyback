package com.happynewyeara.mapper;

import com.happynewyeara.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SceneMapper {

    @Select("select id from scene where scene_name=#{scene_name}")
    public int get_id(String scene_name);
    //获取景点id

    @Select("select count(*) from scene where scene_name=#{scene_name}")
    public boolean If_scene_exist(String scene_name);
    //是否存在该景点

}
