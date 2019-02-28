package com.rthttp;


import java.util.HashMap;


/**
 * Author: 张
 * Email: 1271396448@qq.com
 * Date 2018/10/16
 * <p>
 * 接口参数封装
 */

public class Mobile {


    public final static String LOCAL_BASE_URL = "http://140.143.80.58:8888/";

    //全局 获取用户的图片
    public static HashMap login(String username, String password) {
        HashMap<String, Object> map = new HashMap();
        map.put("username", username);
        map.put("password", password);
        return map;
    }

}
