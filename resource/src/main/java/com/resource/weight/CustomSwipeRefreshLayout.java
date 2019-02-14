package com.resource.weight;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;

import com.resource.R;

/**
 * Author: 张
 * Email: 1271396448@qq.com
 * Date 2018/11/1
 *
 * 自定义SwiperRefresLayout
 */

public class CustomSwipeRefreshLayout extends SwipeRefreshLayout {

    public CustomSwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setColorSchemeResources(
                R.color.red,
                R.color.blue,
                R.color.orange,
                R.color.black,
                R.color.green
        );

    }
}
