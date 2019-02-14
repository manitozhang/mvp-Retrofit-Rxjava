package com.resource.util;

import android.hardware.Camera;

import java.util.List;

/**
 * @Author: 张
 * @Email: 1271396448@qq.com
 * @Date 2019/1/22 13:38
 *
 * 自定义相机工具类
 */

public class SurfaceCameraUtil {

        /**
         * 打开相机
         */
        public static Camera openCamera() {
            Camera c = null;
            try {
                c = Camera.open();
            } catch (Exception e) {
            }
            return c;
        }

        /**
         * Android相机的预览尺寸都是4:3或者16:9，这里遍历所有支持的预览尺寸，得到16:9的最大尺寸，保证成像清晰度
         *
         * @param sizes
         * @return 最佳尺寸
         */
        public static Camera.Size getBestSize(List<Camera.Size> sizes) {
            Camera.Size bestSize = null;
            for (Camera.Size size : sizes) {
                if ((float) size.width / (float) size.height == 16.0f / 9.0f) {
                    if (bestSize == null) {
                        bestSize = size;
                    } else {
                        if (size.width > bestSize.width) {
                            bestSize = size;
                        }
                    }
                }
            }
            return bestSize;
        }
}
