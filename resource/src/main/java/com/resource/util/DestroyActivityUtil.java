package com.resource.util;

import android.app.Activity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Author: 张
 * Email: 1271396448@qq.com
 * Date 2018/12/5
 *
 * 销毁指定Activity
 */

public class DestroyActivityUtil {

    private static Map<String, Activity> destoryMap = new HashMap<>();

    //将Activity添加到队列中
    public static void addDestoryActivityToMap(Activity activity, String activityName) {
        destoryMap.put(activityName, activity);
    }

    //根据名字销毁制定Activity
    public static void destoryActivity(String activityName) {
        Set<String> keySet = destoryMap.keySet();
        LogUtil.i(keySet.size());
        if (keySet.size() > 0) {
            for (String key : keySet) {
                if (activityName.equals(key)) {
                    destoryMap.get(key).finish();
                }
            }
        }
    }

}
