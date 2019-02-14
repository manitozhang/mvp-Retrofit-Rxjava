package com.resource.weight.recyclerview;

import android.content.Context;
import android.support.annotation.StringRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * Author: 张
 * Email: 1271396448@qq.com
 * Date 2017/08/13
 *
 * RecyclerView适配器父类
 */

public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerViewHolder> {

    protected List<T>                             mData;
    protected Context                             mContext;
    private   OnRecyclerViewItemClickListener     mClickListener;
    private   OnRecyclerViewItemLongClickListener mLongClickListener;

    public BaseRecyclerAdapter(List<T> list) {
        mData = list == null ? (List<T>) new ArrayList<>() : list;
    }

    public BaseRecyclerAdapter() {
        mData = new ArrayList<>();
    }

    public void change(int pos, T item) {
        mData.remove(pos);
        mData.add(pos, item);
        notifyItemChanged(pos);
    }

    public void addAll(List<T> list) {
        if (list.size() > 0) {
            mData.clear();
            mData.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void add(List<T> list) {
        if (list.size() > 0) {
            mData.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void add(int position, T data) {
        mData.add(position, data);
        notifyDataSetChanged();
    }

    public void remove(int position) {
        mData.remove(position);
        notifyDataSetChanged();
    }

    public void clear() {
        mData.clear();
        notifyDataSetChanged();
    }

    public List<T> getData() {
        return mData;
    }


    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(getItemLayoutId(viewType), parent, false);
        final RecyclerViewHolder holder = new RecyclerViewHolder(view);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mClickListener != null) {
                    mClickListener.onItemClick(holder.itemView, holder.getLayoutPosition());
                }
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mLongClickListener!= null) {
                    mLongClickListener.onItemLongClick(holder.itemView, holder.getLayoutPosition());
                    return true;
                }
                return false;
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        bindData(holder, position, mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    protected abstract int getItemLayoutId(int viewType);

    protected abstract void bindData(RecyclerViewHolder holder, int position, T item);

    protected String getString(@StringRes int resId) {
        return mContext.getString(resId);
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        mClickListener = listener;
    }

    public void setOnItemLongClickListener(OnRecyclerViewItemLongClickListener listener) {
        mLongClickListener = listener;
    }
}
