/**
 * Copyright 2017 JessYan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.resource.base.mvp;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.resource.base.other.AppManager;
import com.resource.base.mvp.interfaces.IActivity;
import com.resource.base.mvp.interfaces.IPresenter;
import com.resource.util.AppComponentUtil;
import com.trello.rxlifecycle.LifecycleProvider;
import com.trello.rxlifecycle.LifecycleTransformer;
import com.trello.rxlifecycle.RxLifecycle;
import com.trello.rxlifecycle.android.ActivityEvent;
import com.trello.rxlifecycle.android.RxLifecycleAndroid;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/*
 * Author: 张
 * Email: 1271396448@qq.com
 * Date: 2018/10/19.
 * 因为 Java 只能单继承,所以如果要用到需要继承特定 {@link Activity} 的三方库,那你就需要自己自定义 {@link Activity}
 * 继承于这个特定的 {@link Activity},然后再按照 {@link MvpBaseActivity} 的格式,将代码复制过去,记住一定要实现{@link IActivity}
 */

public abstract class MvpBaseActivity<P extends IPresenter>
        extends AppCompatActivity
        implements IActivity,
        LifecycleProvider<ActivityEvent>,
        View.OnClickListener{

    private final BehaviorSubject<ActivityEvent> lifecycleSubject = BehaviorSubject.create();
    protected final String TAG = this.getClass().getSimpleName();
    private Unbinder mUnbinder;
    protected AppManager mAppManager = AppManager.getAppManager();

    @Inject
    protected P mPresenter;
    protected Context mContext;

    private boolean statusBarLightMode = true;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (mAppManager.shouldRestartApp()) {
//            return;
//        }
        mAppManager.addActivity(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mContext = this;
        lifecycleSubject.onNext(ActivityEvent.CREATE);
        try {
            int layoutResID = setContentView(savedInstanceState);
            if (layoutResID != 0) {//如果initView返回0,框架则不会调用setContentView(),当然也不会 Bind ButterKnife
                setContentView(layoutResID);
                initStatusBar();
                //绑定到butterknife
                mUnbinder = ButterKnife.bind(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        initIntent();

        setupActivityComponent(AppComponentUtil.getAppComponent());
        initView();
        initData(savedInstanceState);
    }

    /**
     * 在此调用{@link MvpBaseActivity#unLightStatusBar}。
     * 默认设置StatusBarLightMode，调用后不设置。可在initView中设置其他模式
     */
    protected void initStatusBar() {

    }

    protected void unLightStatusBar() {
        statusBarLightMode = false;
    }

    protected void initIntent(){}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(useEventBus()){
            EventBus.getDefault().unregister(this);
        }
        lifecycleSubject.onNext(ActivityEvent.DESTROY);
        if (mUnbinder != null && mUnbinder != Unbinder.EMPTY)
            mUnbinder.unbind();
        this.mUnbinder = null;
        if (mPresenter != null)
            mPresenter.onDestroy();//释放资源
        this.mPresenter = null;
        mAppManager.finishActivity(this);
    }

    /**
     * 是否使用eventBus,默认为使用(true)，
     *
     * @return
     */
    @Override
    public boolean useEventBus() {
        return false;
    }

    /**
     * 这个Activity是否会使用Fragment,框架会根据这个属性判断是否注册{@link android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks}
     * 如果返回false,那意味着这个Activity不需要绑定Fragment,那你再在这个Activity中绑定继承于 {@link MvpBaseFragment} 的Fragment将不起任何作用
     *
     * @return
     */
    @Override
    public boolean useFragment() {
        return false;
    }

    @Override
    @NonNull
    @CheckResult
    public final Observable<ActivityEvent> lifecycle() {
        return lifecycleSubject.asObservable();
    }

    @Override
    @NonNull
    @CheckResult
    public final <T> LifecycleTransformer<T> bindUntilEvent(@NonNull ActivityEvent event) {
        return RxLifecycle.bindUntilEvent(lifecycleSubject, event);
    }

    @Override
    @NonNull
    @CheckResult
    public final <T> LifecycleTransformer<T> bindToLifecycle() {
        return RxLifecycleAndroid.bindActivity(lifecycleSubject);
    }



    @Override
    @CallSuper
    protected void onStart() {
        super.onStart();
        if(useEventBus()){
            if (!EventBus.getDefault().isRegistered(this)) {
                EventBus.getDefault().register(this);
            }
        }
        lifecycleSubject.onNext(ActivityEvent.START);
    }

    @Override
    @CallSuper
    protected void onResume() {
        super.onResume();
//        MobclickAgent.onResume(this);
        lifecycleSubject.onNext(ActivityEvent.RESUME);
    }

    @Override
    @CallSuper
    protected void onPause() {
        lifecycleSubject.onNext(ActivityEvent.PAUSE);
//        MobclickAgent.onPause(this);
        super.onPause();
    }

    @Override
    @CallSuper
    protected void onStop() {
        lifecycleSubject.onNext(ActivityEvent.STOP);

        super.onStop();
    }

    @Override
    public void onClick(View view) {

    }


}
