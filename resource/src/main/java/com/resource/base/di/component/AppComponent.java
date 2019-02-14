package com.resource.base.di.component;

import android.app.Application;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;


import com.resource.base.di.AppModule;

import dagger.Component;


/*
 * Author: 张
 * Email: 1271396448@qq.com
 * Date: 2018/10/19.
 * 基类Model
 */

@Component(modules = {AppModule.class})
public interface AppComponent {
    Context context();
    LinearLayoutManager provideLinearLayoutManager();
    void inject(Application application);
}
