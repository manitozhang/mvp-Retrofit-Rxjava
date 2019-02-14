package com.mvp.login;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.mvp.R;
import com.mvp.login.di.DaggerLoginComponent;
import com.mvp.login.di.LoginModule;
import com.mvp.login.mvp.LoginContract;
import com.mvp.login.mvp.LoginPresenter;
import com.resource.base.di.component.AppComponent;
import com.resource.base.mvp.MvpBaseActivity;
import com.resource.util.LogUtil;
import com.resource.util.RegexUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends MvpBaseActivity<LoginPresenter>
        implements LoginContract.View {

    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.tv_login)
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

    @OnClick({R.id.tv_login})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.tv_login://登录
                mPresenter.login(RegexUtil.getEditStr(etUsername), RegexUtil.getEditStr(etPassword));
                break;
        }
    }
}
