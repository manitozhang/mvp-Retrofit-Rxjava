package com.resource.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

/**
 * Author: 张
 * Email: 1271396448@qq.com
 * Date 2018/10/24
 *
 * Base64转码解码工具类
 */

public class Base64Util {


    /**
     * Base64码转为图片文件
     * @return
     */
    public static Bitmap base64ToBitmap(String string) {
        Bitmap bitmap = null;
        try {
            byte[] bitmapArray = Base64.decode(string.split(",")[1], Base64.DEFAULT);
            bitmap = BitmapFactory.decodeByteArray(bitmapArray, 0, bitmapArray.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

}
