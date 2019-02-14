package com.rthttp;


import com.rthttp.api.ApiService;
import com.rthttp.common.Constant;
import com.rthttp.intercept.MyIntercept;
import com.resource.util.SpUtil;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Author: 张
 * @Email: 1271396448@qq.com
 * @Date 2018/10/16 13:16
 *
 * 网络请求总入口
 */

public class RetrofitFactory {

    private Retrofit mRetrofit;
    private static ApiService apiService;

    private RetrofitFactory() {
        initRetrofit();
    }

    public static RetrofitFactory getInstance() {
        return Holder.INSTANCE;
    }

    //请求网络的方法入口
    public static ApiService getApi(){
        if(apiService==null){
            synchronized (ApiService.class){
                if(apiService==null){
                    apiService = getInstance().initRetrofit().create(ApiService.class);
                }
            }
        }
        return apiService;
    }

    // 内部类单利
    private static class Holder {
        private static final RetrofitFactory INSTANCE = new RetrofitFactory();

    }

    private Retrofit initRetrofit() {

        mRetrofit = new Retrofit.Builder()
                .baseUrl(Mobile.LOCAL_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(initClient())
                .build();
        return mRetrofit;
    }


    private OkHttpClient initClient() {

        return new OkHttpClient.Builder()
                .addInterceptor(new MyIntercept())
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();
    }

}