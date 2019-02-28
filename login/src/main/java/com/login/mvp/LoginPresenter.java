package com.login.mvp;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.OnLifecycleEvent;

import com.alibaba.android.arouter.launcher.ARouter;
import com.resource.base.mvp.BasePresenter;
import com.resource.common.ARouterConstant;
import com.resource.common.Constant;
import com.resource.util.LogUtil;
import com.rthttp.RxJavaHelper;
import com.rthttp.base.BaseObserver;
import com.rthttp.base.BaseResponse;
import com.rthttp.bean.LoginBean;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

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
                .compose(RxJavaHelper.<BaseResponse<LoginBean>>observeOnMainThread())
                .subscribe(new BaseObserver<LoginBean>(getContext()) {
                    @Override
                    public void onSuccess(BaseResponse<LoginBean> response) {
                        ARouter.getInstance()
                                .build(ARouterConstant.ROUTE_LOGIN_LOGINSUCCESSACTIVITY)
                                .withString(Constant.USER_NAME,response.getData().getUsername())
                                .navigation();
                    }
                });
    }

}