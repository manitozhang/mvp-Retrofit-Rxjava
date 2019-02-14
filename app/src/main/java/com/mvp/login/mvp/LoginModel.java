package com.mvp.login.mvp;

import com.resource.base.mvp.BaseModel;
import com.rthttp.Mobile;
import com.rthttp.RetrofitFactory;
import com.rthttp.base.BaseResponse;
import com.rthttp.bean.LoginBean;

import javax.inject.Inject;

import io.reactivex.Observable;

public class LoginModel extends BaseModel implements LoginContract.Model {

    @Inject
    public LoginModel() {

    }

    @Override
    public Observable<BaseResponse<LoginBean>> login(String username, String password) {
        return RetrofitFactory.getApi().login(Mobile.login(username, password));
    }
}