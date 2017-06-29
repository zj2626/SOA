package com.em.controller;

import common.FastDFSClient;
import common.JsonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zj on 2017/6/29.
 */
@Controller
public class PictureController {

    @Value("${IMG_SERVER_URL}")
    private String IMG_SERVER_URL; //读取配置文件中数据 配置文件的读取配置在springmvc.xml中

    @RequestMapping(value = "/pic/upload", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String uploadFile(MultipartFile uploadFile) {
        // 如果返回string而不是对象或者map 则响应的数据的content-type即为text/plain(其他格式响应为application/json) text/plain的兼容性最好

        Map<String, Object> map = new HashMap<>();

        //上传图片到图片服务器 获取地址和文件名
        try {
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:conf/client.conf");
            String originalFileName = uploadFile.getOriginalFilename();
            String extName = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
            String url = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
            //得到完整的url
            url = IMG_SERVER_URL + url;

            //封装为map
            map.put("error", 0);
            map.put("url", url);
        } catch (Exception e) {
            map.put("error", 1);
            map.put("message", e.getMessage());
        }

        return JsonUtils.objectToJson(map);
    }
}
