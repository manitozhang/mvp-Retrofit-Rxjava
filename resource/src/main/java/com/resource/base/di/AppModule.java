package com.resource.base.di;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import dagger.Module;
import dagger.Provides;

/*
 * Author: 张
 * Email: 1271396448@qq.com
 * Date: 2018/10/19.
 */
@Module
public class AppModule {
    private Context context;


    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context context(){
        return context;
    }

    @Provides
    public LinearLayoutManager provideLinearLayoutManager() {
        return new LinearLayoutManager(context);
    }

}
