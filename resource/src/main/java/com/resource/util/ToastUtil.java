package com.resource.util;

import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.resource.R;

/**
 * Author: 张
 * Email: 1271396448@qq.com
 * Date 2017/6/12
 *
 * 吐司工具类
 */

public class ToastUtil {

    private static Toast mToast;

    //中间弹窗
    public static void showCenterToast(int resId){
        if(mToast == null){
            mToast = Toast.makeText(Utils.getApp(),resId,Toast.LENGTH_LONG);
            mToast.setGravity(Gravity.CENTER,0,0);
        }else{
            mToast.setText(resId);
        }
        mToast.show();
    }

    //中间弹窗
    public static void showCenterToast(String msg){
        if(mToast == null){
            mToast = Toast.makeText(Utils.getApp(),msg,Toast.LENGTH_LONG);
            mToast.setGravity(Gravity.CENTER,0,0);
        }else{
            mToast.setText(msg);
        }
        mToast.show();
    }
}