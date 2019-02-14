/**
 * Copyright 2017 JessYan
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.resource.base.mvp;

import android.app.Activity;
import android.app.Service;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.SupportActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.resource.base.mvp.interfaces.IModel;
import com.resource.base.mvp.interfaces.IPresenter;
import com.resource.base.mvp.interfaces.IView;
import com.resource.util.Preconditions;
import com.trello.rxlifecycle.LifecycleProvider;
import com.trello.rxlifecycle.LifecycleTransformer;
import com.trello.rxlifecycle.android.ActivityEvent;

import org.greenrobot.eventbus.EventBus;


/*
 * Author: 张
 * Email: 1271396448@qq.com
 * Date: 2018/10/19.
 * 基类 Presenter
 */

public class BasePresenter<M extends IModel, V extends IView> implements IPresenter, LifecycleObserver {
    protected final String TAG = this.getClass().getSimpleName();

    protected M model;
    protected V rootView;

    /**
     * 如果当前页面同时需要 Model 层和 View 层,则使用此构造函数(默认)
     *
     * @param model
     * @param rootView
     */
    public BasePresenter(M model, V rootView) {
        Preconditions.checkNotNull(model, "%s cannot be null", IModel.class.getName());
        Preconditions.checkNotNull(rootView, "%s cannot be null", IView.class.getName());
        this.model = model;
        this.rootView = rootView;
        onStart();
    }

    /**
     * 如果当前页面不需要操作数据,只需要 View 层,则使用此构造函数
     *
     * @param rootView
     */
    public BasePresenter(V rootView) {
        Preconditions.checkNotNull(rootView, "%s cannot be null", IView.class.getName());
        this.rootView = rootView;
        onStart();
    }

    public BasePresenter() {
        onStart();
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume(){
    }

    @Override
    public void onStart() {
        initIntent();
        //将 LifecycleObserver 注册给 LifecycleOwner 后 @OnLifecycleEvent 才可以正常使用
        if (rootView != null && rootView instanceof LifecycleOwner) {
            ((LifecycleOwner) rootView).getLifecycle().addObserver(this);
            if (model != null && model instanceof LifecycleObserver){
                ((LifecycleOwner) rootView).getLifecycle().addObserver((LifecycleObserver) model);
            }
        }
        if (useEventBus())//如果要使用 Eventbus 请将此方法返回 true
            EventBus.getDefault().register(this);//注册 Eventbus
    }

    /**
     * 在框架中 {@link Activity#onDestroy()} 时会默认调用 {@link IPresenter#onDestroy()}
     */
    @Override
    public void onDestroy() {
        if (useEventBus())//如果要使用 Eventbus 请将此方法返回 true
            EventBus.getDefault().unregister(this);//解除注册 Eventbus
        if (model != null)
            model.onDestroy();
        this.model = null;
        this.rootView = null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate(){

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop(){

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause(){

    }

    /**
     * 只有当 {@code rootView} 不为 null, 并且 {@code rootView} 实现了 {@link LifecycleOwner} 时, 此方法才会被调用
     * 所以当您想在 {@link Service} 以及一些自定义 {@link View} 或自定义类中使用 {@code Presenter} 时
     * 您也将不能继续使用 {@link OnLifecycleEvent} 绑定生命周期
     *
     * @param owner link {@link SupportActivity} and {@link Fragment}
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy(LifecycleOwner owner) {
        /**
         * 注意, 如果在这里调用了 {@link #onDestroy()} 方法, 会出现某些地方引用 {@code model} 或 {@code rootView} 为 null 的情况
         * 比如在 {@link RxLifecycle} 终止 {@link Observable} 时, 在 {@link io.reactivex.Observable#doFinally(Action)} 中却引用了 {@code rootView} 做一些释放资源的操作, 此时会空指针
         * 或者如果你声明了多个 @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY) 时在其他 @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
         * 中引用了 {@code model} 或 {@code rootView} 也可能会出现此情况
         */
        owner.getLifecycle().removeObserver(this);
    }

    /**
     * 是否使用 {@link EventBus},默认为使用(true)，
     *
     * @return
     */
    public boolean useEventBus() {
        return false;
    }

    public void initIntent(){}

    public void finishActivity(){
        getActivity().finish();
    }

    public FragmentActivity getActivity(){
        if(rootView instanceof Activity) {
            return ((FragmentActivity) rootView);
        }else if(rootView instanceof Fragment){
            return ((Fragment)rootView).getActivity();
        }
        return null;
    }
    public Fragment getFragment(){
        if(rootView instanceof Fragment) {
            return ((Fragment) rootView);
        }
        return null;
    }
    public Context getContext(){
        if(rootView instanceof Activity) {
            return (Context) rootView;
        }else if(rootView instanceof Fragment){
            return ((Fragment)rootView).getContext();
        }
        return null;
    }


    public LifecycleTransformer lifecycleTransformer(){
        return ((LifecycleProvider<ActivityEvent>) rootView).bindToLifecycle();
    }

    public FragmentManager fragmentManager(){
        return ((AppCompatActivity)rootView).getSupportFragmentManager();
    }
}
