package com.login;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.login.di.DaggerLoginComponent;
import com.login.di.LoginModule;
import com.login.mvp.LoginContract;
import com.login.mvp.LoginPresenter;
import com.resource.base.di.component.AppComponent;
import com.resource.base.mvp.MvpBaseActivity;
import com.resource.common.ARouterConstant;
import com.resource.util.LogUtil;
import com.resource.util.RegexUtil;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = ARouterConstant.ROUTE_LOGIN_LOGINACTIVITY)
public class LoginActivity extends MvpBaseActivity<LoginPresenter>
        implements LoginContract.View {

    @BindView(R2.id.et_username)
    EditText etUsername;
    @BindView(R2.id.et_password)
    EditText etPassword;
    @BindView(R2.id.tv_login)
    TextView tvLogin;

    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        DaggerLoginComponent.builder()
                .appComponent(appComponent)
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int setContentView(Bundle savedInstanceState) {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        LogUtil.i("LoginActivity初始化");
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void showMessage(String message) {
    }

    @OnClick({R2.id.tv_login})
    public void onViewClicked(View v) {
        int id = v.getId();
        if (id == R.id.tv_login) {
            mPresenter.login(RegexUtil.getEditStr(etUsername), RegexUtil.getEditStr(etPassword));
        }
    }
}
