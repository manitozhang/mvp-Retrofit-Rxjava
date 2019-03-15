package com.mvp;

import android.view.View;
import android.widget.Button;

import com.resource.base.BaseActivity;
import com.resource.common.ARouterConstant;
import com.resource.util.ARouterUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R2.id.btn_intent_login)
    Button btnIntentLogin;

    @Override
    public int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
    }

    @Override
    public void initData() {
    }

    @OnClick({R2.id.btn_intent_login})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.btn_intent_login)
            ARouterUtil.start(ARouterConstant.ROUTE_LOGIN_LOGINACTIVITY);
    }
}
