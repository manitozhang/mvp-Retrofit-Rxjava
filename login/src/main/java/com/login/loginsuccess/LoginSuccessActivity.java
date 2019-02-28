package com.login.loginsuccess;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.login.R;
import com.login.R2;
import com.resource.base.BaseActivity;
import com.resource.common.ARouterConstant;
import com.resource.common.Constant;
import com.resource.weight.CustomToolbar;

import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = ARouterConstant.ROUTE_LOGIN_LOGINSUCCESSACTIVITY)
public class LoginSuccessActivity extends BaseActivity {

    @BindView(R2.id.tool_bar)
    CustomToolbar toolBar;
    @BindView(R2.id.tv_user_name)
    TextView tvUserName;

    @Override
    public int initLayout() {
        return R.layout.activity_login_success;
    }

    @Override
    public void initView() {
    }

    @Override
    public void initIntent() {
        super.initIntent();
        String userName = getIntent().getStringExtra(Constant.USER_NAME);
        tvUserName.setText(userName);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        super.initListener();
        toolBar.setOnBackClickListener(new CustomToolbar.OnBackClickListener() {
            @Override
            public void onBackClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
