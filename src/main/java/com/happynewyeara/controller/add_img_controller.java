//package com.happynewyeara.controller;
//
//import com.happynewyeara.service.add_img_service;
//import com.happynewyeara.utils.AliOSSUtils;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//
//@RestController
//public class add_img_controller {
//    @Autowired
//    private add_img_service add_img_service;
//    @Autowired
//    private AliOSSUtils aliOSSUtils;
//
//    @RequestMapping("/api/img/add")
//    public String register(String phone_num, String scene_name, MultipartFile img) throws IOException {
//        String url = aliOSSUtils.upload(img);
//        return add_img_service.Addimg(phone_num, scene_name, url);
//    }
//}