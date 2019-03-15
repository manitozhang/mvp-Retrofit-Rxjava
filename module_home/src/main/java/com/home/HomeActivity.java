package com.home;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.resource.base.BaseActivity;
import com.resource.common.ARouterConstant;

@Route(path = ARouterConstant.ROUTE_HOME_MAINACTIVITY)
public class HomeActivity extends BaseActivity {
    @Override
    public int initLayout() {
        return R.layout.activity_home;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}
