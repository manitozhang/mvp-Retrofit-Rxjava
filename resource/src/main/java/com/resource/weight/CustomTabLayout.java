package com.resource.weight;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;

import com.resource.R;


/**
 * Author: 张
 * Email: 1271396448@qq.com
 * Date 2018/11/29
 *
 * 自定义TabLayout 免于每次使用写一堆重复的属性
 */

public class CustomTabLayout extends TabLayout {

    public CustomTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTabTextColors(getResources().getColor(R.color.black),getResources().getColor(R.color.blue));
        setSelectedTabIndicatorColor(getResources().getColor(R.color.blue));
        setTabMode(MODE_FIXED);
        setTabGravity(GRAVITY_FILL);
    }
}
