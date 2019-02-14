package com.resource.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Author: 张
 * Email: 1271396448@qq.com
 * Date 2016/10/16
 *
 * SharedPrefences数据库工具类
 */

public class SpUtil {

    public static SharedPreferences sp;
    public static SharedPreferences.Editor edit;

    public static void init(Context context){
        sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        edit = sp.edit();
    }


    /**
     * obj仅限int,float,boolean,long,String类型
     */
    public static void put(String key, Object obj) {
        SharedPreferences.Editor editor = sp.edit();
        if (obj instanceof String) {
            editor.putString(key, (String) obj);
        } else if (obj instanceof Integer) {
            editor.putInt(key, (int) obj);
        } else if (obj instanceof Boolean) {
            editor.putBoolean(key, (boolean) obj);
        } else if (obj instanceof Float) {
            editor.putFloat(key, (float) obj);
        }
        editor.apply();
    }


}
