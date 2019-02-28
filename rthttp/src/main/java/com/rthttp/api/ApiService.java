package com.rthttp.api;

import com.rthttp.base.BaseResponse;
import com.rthttp.bean.LoginBean;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * @Author: 张
 * @Email: 1271396448@qq.com
 * @Date 2018/10/16 16:49
 *
 * 参数封装类
 */

public interface ApiService {

    //登录
    @POST("user/login")
    Observable<BaseResponse<LoginBean>> login(@QueryMap HashMap<String, Object> map);

}
