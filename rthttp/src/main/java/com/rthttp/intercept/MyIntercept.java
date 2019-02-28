package com.rthttp.intercept;

import com.resource.common.Constant;
import com.resource.util.LogUtil;
import com.resource.util.SpUtil;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Author: 张
 * Email: 1271396448@qq.com
 * Date 2018/10/16
 *
 * 拦截器
 */
public class MyIntercept implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl build = request.url()
                .newBuilder()
                .build();
        LogUtil.i(build);
        Request requestNew = request.newBuilder()
                .addHeader("Authorization", SpUtil.sp.getString(Constant.USER_TOKEN,""))
                .url(build)
                .build();
        return chain.proceed(requestNew);
    }
}