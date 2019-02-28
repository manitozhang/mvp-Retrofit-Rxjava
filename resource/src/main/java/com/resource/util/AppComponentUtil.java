package com.resource.util;


import com.resource.base.di.component.AppComponent;

/**
 * Author: 张
 * Email: 1271396448@qq.com
 * Date 2017/9/15
 */

public class AppComponentUtil {
    private static AppComponent sAppComponent;

    public static void setAppComponent(AppComponent appComponent){
        sAppComponent = appComponent;
    }

    public static AppComponent getAppComponent(){
        return sAppComponent;
    }
}
