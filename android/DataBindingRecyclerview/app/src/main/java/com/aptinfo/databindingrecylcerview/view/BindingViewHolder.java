package com.aptinfo.databindingrecylcerview.view;

import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public class BindingViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {
    private final T binding;

    public BindingViewHolder(View view) {
        super(view);
        this.binding = (T)DataBindingUtil.bind(view);
    }

    public T binding() {
        return binding;
    }
}