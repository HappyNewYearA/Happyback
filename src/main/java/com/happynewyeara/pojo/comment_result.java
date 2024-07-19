package com.happynewyeara.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class comment_result {
    private Integer id;
    private int memberId;
    private String Content;
    private String Scene_name;
    private String User_name;
    private String Create_time;




}
