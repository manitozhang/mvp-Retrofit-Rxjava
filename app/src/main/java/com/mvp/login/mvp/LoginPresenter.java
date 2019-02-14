package com.mvp.login.mvp;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Intent;

import com.mvp.loginsuccess.LoginSuccessActivity;
import com.resource.base.mvp.BasePresenter;
import com.resource.util.LogUtil;
import com.rthttp.RxJavaHelper;
import com.rthttp.base.BaseObserver;
import com.rthttp.base.BaseResponse;
import com.rthttp.bean.LoginBean;

import javax.inject.Inject;

public class LoginPresenter extends BasePresenter<LoginContract.Model, LoginContract.View> {

    @Inject
    public LoginPresenter(LoginContract.Model model, LoginContract.View rootView) {
        super(model, rootView);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        LogUtil.i("LoginPresenter初始化");
    }

    public void login(String username, String password){
        model.login(username, password)
                .compose(RxJavaHelper.observeOnMainThread())
                .subscribe(new BaseObserver<LoginBean>(getContext()) {
                    @Override
                    public void onSuccess(BaseResponse<LoginBean> response) {
                        LoginSuccessActivity.intent(getContext());
                    }
                });
    }

}