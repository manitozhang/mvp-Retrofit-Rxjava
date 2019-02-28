package com.rthttp.base;


import android.content.Context;
import android.support.v7.app.AlertDialog;

import com.google.gson.JsonSyntaxException;
import com.resource.util.LogUtil;
import com.resource.util.NetworkUtils;
import com.resource.util.ToastUtil;
import com.resource.util.WaitLoadingDialogUtill;
import com.rthttp.R;

import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

/**
 * @Author: 张
 * @Email: 1271396448@qq.com
 * @Date 2018/11/14 10:26
 *
 * 统一错误码处理
 */

public abstract class BaseObserver<T> implements Observer<BaseResponse<T>> {

    private Context context;
    private AlertDialog dialog;

    public BaseObserver() {
        super();
    }

    public  BaseObserver(Context context) {
        this.context = context;
        dialog = WaitLoadingDialogUtill.showLoadingDialog(context);
    }


    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(BaseResponse<T> response) {
        if (response.getCode() == 10000) {//数据请求成功
            onSuccess(response);
        } else {
            ToastUtil.showCenterToast(response.getMsg());
        }
        dialog.cancel();
    }

    @Override
    public void onError(Throwable e) {
        LogUtil.e(e.getMessage());
        //错误码统一处理
        if (e instanceof UnknownHostException) {
            if (!NetworkUtils.isNetworkAvailable()) {//网络不可用
                ToastUtil.showCenterToast(R.string.net_error);
            }else {
                ToastUtil.showCenterToast(R.string.server_error);
            }
        } else if (e instanceof ConnectException || e instanceof SocketTimeoutException || e instanceof SocketException) {//连接超时等
            ToastUtil.showCenterToast(R.string.time_out_error);
        } else if (e instanceof HttpException || e instanceof retrofit2.adapter.rxjava2.HttpException) {
            ToastUtil.showCenterToast(R.string.server_error);
        }
        if(dialog.isShowing())
        dialog.cancel();
    }

    @Override
    public void onComplete() {

    }

    public abstract void onSuccess(BaseResponse<T> response);

}
