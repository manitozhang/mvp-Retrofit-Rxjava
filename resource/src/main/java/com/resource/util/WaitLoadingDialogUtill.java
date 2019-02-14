package com.resource.util;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.resource.R;

/**
 * Author: 张
 * Email: 1271396448@qq.com
 * Date 2018/11/30
 * <p>
 * 加载框
 */

public class WaitLoadingDialogUtill {

    //显示加载框
    public static AlertDialog showLoadingDialog(Context context) {
        AlertDialog loadingDialog = new AlertDialog.Builder(context)
                .create();
        View inflate = LayoutInflater.from(context).inflate(R.layout.dialog_wait_loading, null);
        ImageView ivWaitLoading = inflate.findViewById(R.id.iv_wait_loading);
        loadingDialog.setView(inflate);
        Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.dialog_wait_loading_rotate);
        ivWaitLoading.startAnimation(loadAnimation);
        loadingDialog.setCanceledOnTouchOutside(false);
        if (!loadingDialog.isShowing()) {
            loadingDialog.show();
        }
        Window window = loadingDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.gravity = Gravity.CENTER;
        lp.width = 350;
        lp.height = 200;
        loadingDialog.getWindow().setAttributes(lp);
        return loadingDialog;
    }
}
