package com.vkappkg.vk.vk.ui.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.vkappkg.vk.vk.model.view.BaseViewModel;

public abstract class BaseViewHolder<Item extends BaseViewModel> extends RecyclerView.ViewHolder {


    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindViewHolder(Item item);

    public abstract void unBindViewHolder();
}
