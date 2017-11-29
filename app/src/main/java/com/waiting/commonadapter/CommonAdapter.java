package com.waiting.commonadapter;

import android.databinding.ViewDataBinding;

import com.waiting.commonadapter.BR;

import java.util.List;

/**
 * Created by hechao on 2017/11/29.
 */

public class CommonAdapter<M, B extends ViewDataBinding> extends BaseAdapter<M, B> {
    public CommonAdapter(int layoutId, List<M> datas) {
        super(layoutId, datas);
    }

    @Override
    protected void convert(B binding, M item, int position) {
        binding.setVariable(BR.item, item);
        binding.executePendingBindings();
    }
}
