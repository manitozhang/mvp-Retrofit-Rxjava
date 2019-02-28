package com.login.di;


import com.login.mvp.LoginContract;
import com.login.mvp.LoginModel;
import com.resource.base.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

@ActivityScope
@Module
public class LoginModule {

    private LoginContract.View view;

    public LoginModule(LoginContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    public LoginContract.View view() {
        return view;
    }

    @ActivityScope
    @Provides
    public LoginContract.Model model() {
        return new LoginModel();
    }

}

