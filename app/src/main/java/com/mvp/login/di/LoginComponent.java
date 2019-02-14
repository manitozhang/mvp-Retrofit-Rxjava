package com.mvp.login.di;

import com.mvp.login.LoginActivity;
import com.resource.base.di.component.AppComponent;
import com.resource.base.di.scope.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(dependencies = {AppComponent.class}, modules = {LoginModule.class})
public interface LoginComponent {
    void inject(LoginActivity activity);
}