package com.mvp.login.mvp;

import com.resource.base.mvp.interfaces.IModel;
import com.resource.base.mvp.interfaces.IView;
import com.rthttp.base.BaseResponse;
import com.rthttp.bean.LoginBean;

import io.reactivex.Observable;

public interface LoginContract {
    interface View extends IView {

    }

    interface Model extends IModel {
        Observable<BaseResponse<LoginBean>> login(String username, String password);
    }
}