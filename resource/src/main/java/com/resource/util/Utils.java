package com.resource.util;

import android.annotation.SuppressLint;
import android.app.Application;
import android.support.annotation.NonNull;

/**
 * Author: 张
 * Email: 1271396448@qq.com
 * Date 2017/10/16
 *
 * 全局上下文工具类
 */

public class Utils {

    @SuppressLint("StaticFieldLeak")
    private static Application sApplication;

    public static void init(@NonNull Application app) {
        Utils.sApplication = app;
    }

    public static Application getApp() {
        if (sApplication != null) {
            return sApplication;
        } else {
            throw new NullPointerException("u should init Utils first");
        }
    }
}
