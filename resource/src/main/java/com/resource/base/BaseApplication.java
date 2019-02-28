package com.resource.base;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.resource.BuildConfig;
import com.resource.base.di.AppModule;
import com.resource.base.di.component.AppComponent;
import com.resource.base.di.component.DaggerAppComponent;
import com.resource.util.AppComponentUtil;
import com.resource.util.SpUtil;
import com.resource.util.Utils;


/**
 * Author: 张
 * Email: 1271396448@qq.com
 * Date 2018/10/16
 *
 * 全局配置类
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        SpUtil.init(this);
        initDagger();
        initARouter();
//        FileDownloader.setupOnApplicationOnCreate(this);
    }

    //初始化Dagger
    private void initDagger() {
        AppComponent appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        AppComponentUtil.setAppComponent(appComponent);
    }

    private void initARouter(){
        //如果是调试模式
        if(BuildConfig.DEBUG){
            ARouter.openLog();//打印日志
            ARouter.openDebug();//开启调试模式
            ARouter.printStackTrace();//打印日志的时候,打印线程信息
        }
        //初始化ARouter路由跳转
        ARouter.init(this);
    }

}
