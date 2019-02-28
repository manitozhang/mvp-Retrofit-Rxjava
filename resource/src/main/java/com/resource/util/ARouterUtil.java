package com.resource.util;


import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Author: 张
 * Email: 1271396448@qq.com
 * Date 2018/10/31
 *
 * ARouter路由跳转
 */

public class ARouterUtil {

    public static void start(String path){
        ARouter.getInstance().build(path).navigation();
    }

}
