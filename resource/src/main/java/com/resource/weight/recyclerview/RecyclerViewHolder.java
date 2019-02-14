package com.resource.weight.recyclerview;

import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Author: 张
 * Email: 1271396448@qq.com
 * Date 2017/08/13
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    private final SparseArray<View> mViews;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        mViews = new SparseArray<>();
    }

    public <T extends View> T findViewById(@IdRes int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public View getView(@IdRes int viewId) {
        return findViewById(viewId);
    }

    public TextView getTextView(@IdRes int viewId) {
        return findViewById(viewId);
    }

    public ImageView getImageView(@IdRes int viewId) {
        return findViewById(viewId);
    }

    public RelativeLayout getRelativeLayout(@IdRes int viewId) {
        return findViewById(viewId);
    }

    public LinearLayout getLinearLayout(@IdRes int viewId) {
        return findViewById(viewId);
    }

    public CheckBox getCheckBox(@IdRes int viewId) {
        return findViewById(viewId);
    }
    public Button getButton(@IdRes int viewId) {
        return findViewById(viewId);
    }
    public ProgressBar getProgressBar(@IdRes int viewId) {
        return findViewById(viewId);
    }

}
