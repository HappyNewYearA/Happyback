package com.happynewyeara.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResultJson {

    private Integer code;
    private Object message;
    private String data;
    private ResultJson(Integer code,Object message){
        this.code=code;
        this.message=message;
    }

    public static ResultJson success(Object message){
        return new ResultJson(200,message);
    }

    public static ResultJson error(Object message){
        return new ResultJson(500,message);
    }

    public static ResultJson success(Object message,String data){
        return new ResultJson(500,message,data);
    }



}
