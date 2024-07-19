package com.happynewyeara.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class comment {
    Integer id;
    int member_id;
    int scene_id;
    String create_time;
    boolean status;
    String content;

    public comment(int member_id, int scene_id, String create_time, String content) {
        this.member_id = member_id;
        this.scene_id = scene_id;
        this.create_time = create_time;
        this.status = true;
        this.content = content;
    }
}
