package com.happynewyeara.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class img {
    int member_id;
    int scene_id;
    String create_time;
    boolean status;
    String url;

    public img(int member_id, int scene_id, String create_time, String url) {
        this.member_id = member_id;
        this.scene_id = scene_id;
        this.create_time = create_time;
        this.status = true;
        this.url = url;
    }
}