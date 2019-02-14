package com.resource.base;


import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.ButterKnife;

/**
 * Author: 张
 * Email: 1271396448@qq.com
 * Date 2018/10/15
 * <p>
 * Activity基类
 */

public abstract class BaseActivity extends AppCompatActivity {

    //    /***是否显示标题栏*/
//    private  boolean isshowtitle = true;
//    /***是否显示标题栏*/
//    private  boolean isshowstate = true;
    /***封装toast对象**/
    private static Toast toast;
    /***获取TAG的activity名称**/
    protected final String TAG = this.getClass().getSimpleName();
    @Subscribe
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(useEventBus())//如果使用EventBus,请在子类实现此方法,返回true
            EventBus.getDefault().register(this);
        //设置布局
        setContentView(initLayout());
        ButterKnife.bind(this);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        initIntent();
        //初始化控件
        initView();
        //设置数据
        initListener();
        initData();
    }

    //如果使用EventBus,请在子类实现此方法,返回true
    public boolean useEventBus(){
        return false;
    }

    /**
     * 设置布局
     *
     * @return
     */
    public abstract int initLayout();

    /**
     * 初始化布局
     */
    public abstract void initView();

    /**
     * 初始化intent
     */
    public void initIntent(){};

    /**
     * 设置数据
     */
    public abstract void initData();

    /**
     * 点击事件
     */
    public void initListener(){};

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(useEventBus())//如果使用EventBus,请在子类实现此方法,返回true
            EventBus.getDefault().unregister(this);
    }
}
