package com.happynewyeara.mapper;

import com.happynewyeara.pojo.img;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface ImgMapper {

    @Insert("insert into img(member_id, scene_id, create_time, status, url)" +
            "values (#{member_id},#{scene_id},#{create_time},true,#{url})")
    public void AddImg(img img);

    @Select("select count(*) from img where member_id=#{member_id} and status=true")
    public boolean If_user_img_exist(int member_id);

    @Select("select * from img where member_id=#{member_id} and status=true")
    public List<img> get_user_img(int member_id);

    @Select("select * from img "+
            "where member_id!=#{member_id} and scene_id=#{scene_id} and status=true order by create_time desc")
    public List<img> get_img1(int member_id, int scene_id);

    @Select("select * from img "+
            "where member_id=#{member_id} and scene_id=#{scene_id} and status=true order by create_time desc")
    public List<img> get_img2(int member_id, int scene_id);

    @Select("select i.url from img i "+
            "where scene_id=#{scene_id} and status=true order by create_time desc")
    public List<Map<String,String>> get_img3(int scene_id);

    @Update("update img set status=false" +
            " where member_id=#{member_id} and scene_id=#{scene_id} and create_time=#{create_time} and url=#{url}")
    public boolean delete_img(int member_id, int scene_id, String create_time, String url);

    @Select("select count(*) from img " +
            " where member_id=#{member_id} and scene_id=#{scene_id} and create_time=#{create_time} and url=#{url}")
    public int If_img_exist(int member_id, int scene_id, String create_time, String url);


    @Update("update img set status=false" +
            " where create_time=#{create_time} and url=#{url}")
    boolean delete_img2(String url, String create_time);
}
