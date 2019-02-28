package com.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.resource.base.BaseActivity;
import com.resource.common.ARouterConstant;
import com.resource.util.ARouterUtil;
import com.rthttp.Mobile;
import com.rthttp.RetrofitFactory;
import com.rthttp.RxJavaHelper;
import com.rthttp.base.BaseObserver;
import com.rthttp.base.BaseResponse;
import com.rthttp.bean.LoginBean;

import butterknife.BindView;
import butterknife.ButterKnife;
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
        switch (view.getId()){
            case R.id.btn_intent_login:
                ARouterUtil.start(ARouterConstant.ROUTE_LOGIN_LOGINACTIVITY);
        }
    }
}
