package com.resource.weight;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.resource.R;

/**
 * Author: 张
 * Email: 1271396448@qq.com
 * Date 2018/11/23
 *
 * 自定义标题栏
 */

public class CustomToolbar extends LinearLayout {

    private TextView tvBack;
    private TextView tvTitle;
    private RelativeLayout rlBgRoot;
    private OnBackClickListener onBackClickListener;
    private OnTitleClickListener onTitleClickListener;

    public CustomToolbar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    private void initView(Context context, @Nullable AttributeSet attrs){
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_custom_toolbar,this);
        rlBgRoot = inflate.findViewById(R.id.rl_bg_root);
        tvBack = inflate.findViewById(R.id.tv_back);
        tvTitle = inflate.findViewById(R.id.tv_title);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomToolbar);
        String title = typedArray.getString(R.styleable.CustomToolbar_text_title);
        int backType = typedArray.getInt(R.styleable.CustomToolbar_back_type, 10);
        int bgType = typedArray.getInt(R.styleable.CustomToolbar_bg_type, 10);
        tvTitle.setText(title);
        if(backType==10){//无返回按钮
            tvBack.setVisibility(GONE);
        }else if(bgType==11){//有返回按钮
            tvBack.setVisibility(VISIBLE);
        }
        if(bgType==10){//蓝底白字
            rlBgRoot.setBackground(getResources().getDrawable(R.drawable.icon_bg_toolbar));
            tvTitle.setTextColor(getResources().getColor(R.color.white));
            //白色返回图片
            Drawable drawable = getResources().getDrawable(R.drawable.icon_back_white);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            tvBack.setCompoundDrawables(drawable,null,null,null);
        }else if(bgType==11){//白底黑字
            rlBgRoot.setBackgroundColor(getResources().getColor(R.color.white));
            tvTitle.setTextColor(getResources().getColor(R.color.black));
            tvBack.setTextColor(getResources().getColor(R.color.black));
            //灰色返回图片
            Drawable drawable = getResources().getDrawable(R.drawable.icon_back_gray);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            tvBack.setCompoundDrawables(drawable,null,null,null);
        }
        tvBack.setOnClickListener(new OnClickListener() {//返回点击监听
            @Override
            public void onClick(View v) {
                if(onBackClickListener!=null)
                    onBackClickListener.onBackClick(v);
            }
        });
        tvTitle.setOnClickListener(new OnClickListener() {//标题点击监听
            @Override
            public void onClick(View v) {
                if(onTitleClickListener!=null)
                    onTitleClickListener.onTitleClick(v);
            }
        });
    }

    public interface OnBackClickListener{
        void onBackClick(View v);
    }

    public void setOnBackClickListener(OnBackClickListener onBackClickListener) {
        this.onBackClickListener = onBackClickListener;
    }

    public interface OnTitleClickListener{
        void onTitleClick(View v);
    }
    public void setOnTitleClickListener(OnTitleClickListener onTitleClickListener) {
        this.onTitleClickListener = onTitleClickListener;
    }

    public void setTitle(String str){
        tvTitle.setText(str);
    }

}
