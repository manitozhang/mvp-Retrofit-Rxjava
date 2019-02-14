package com.mvp.loginsuccess;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mvp.R;
import com.resource.base.BaseActivity;
import com.resource.weight.CustomToolbar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginSuccessActivity extends BaseActivity {

    @BindView(R.id.tool_bar)
    CustomToolbar toolBar;

    @Override
    public int initLayout() {
        return R.layout.activity_login_success;
    }

    public static void intent(Context context) {
        Intent intent = new Intent(context, LoginSuccessActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void initView() {

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
}
