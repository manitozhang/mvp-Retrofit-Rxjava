package com.resource.util;


import com.resource.base.di.component.AppComponent;

/**
 * Created by 87871 on 2017/12/6.
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
