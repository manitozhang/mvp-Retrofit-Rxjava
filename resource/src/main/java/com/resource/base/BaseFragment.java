package com.resource.base;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.ButterKnife;


/**
 * Author: 张
 * Email: 1271396448@qq.com
 * Date 2018/10/15
 * <p>
 * Fragment基类
 */


public abstract class BaseFragment extends Fragment {


    protected abstract int setView();

    protected abstract void init(View view);

    protected abstract void initData(Bundle savedInstanceState);

    protected abstract void initListener();

    @SuppressLint("NewApi")
    @Override
    @Subscribe
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        builder.detectFileUriExposure();
        if (useEventBus()) {//如果使用EventBus,请将此方法返回true
            if (!EventBus.getDefault().isRegistered(this))
                EventBus.getDefault().register(this);
        }
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(setView(), container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        initData(savedInstanceState);
        initListener();
    }

    public boolean useEventBus() {
        return false;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (useEventBus()) {//如果使用EventBus,请将此方法返回true
            if (EventBus.getDefault().isRegistered(this))
                EventBus.getDefault().unregister(this);
        }
    }
}
