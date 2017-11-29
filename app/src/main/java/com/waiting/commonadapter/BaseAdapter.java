package com.waiting.commonadapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by hechao on 2017/11/29.
 */

public abstract class BaseAdapter<M, B extends ViewDataBinding> extends RecyclerView.Adapter {

    private @LayoutRes
    int mLayoutId;
    private List<M> mDatas;

    public BaseAdapter(int layoutId, List<M> datas) {
        mLayoutId = layoutId;
        mDatas = datas;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(mLayoutId, parent, false);
        return new BaseViewModel(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        B binding = DataBindingUtil.bind(holder.itemView);
        convert(binding, mDatas.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    protected abstract void convert(B binding, M item, int position);

    class BaseViewModel extends RecyclerView.ViewHolder {
        public BaseViewModel(View itemView) {
            super(itemView);
        }
    }
}
