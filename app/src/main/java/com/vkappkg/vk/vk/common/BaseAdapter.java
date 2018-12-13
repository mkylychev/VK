package com.vkappkg.vk.vk.common;

import android.support.v7.widget.RecyclerView;
import android.util.ArrayMap;
import android.view.ViewGroup;

import com.vkappkg.vk.vk.model.view.BaseViewModel;
import com.vkappkg.vk.vk.ui.holder.BaseViewHolder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class BaseAdapter extends RecyclerView.Adapter<BaseViewHolder<BaseViewModel>> {

    private List<BaseViewModel> list = new ArrayList<>();

    private ArrayMap<Integer, BaseViewModel> mTypeInstances = new ArrayMap<>();

    @Override
    public BaseViewHolder<BaseViewModel> onCreateViewHolder(ViewGroup parent, int viewType) {
        return mTypeInstances.get(viewType).createViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder<BaseViewModel> holder, int position) {
        holder.bindViewHolder(getItem(position));
    }

    @Override
    public void onViewRecycled(BaseViewHolder<BaseViewModel> holder) {
        super.onViewRecycled(holder);
        holder.unBindViewHolder();
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).getType().getValue();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private BaseViewModel getItem(int position) {
        return list.get(position);
    }


    public void registerTypeInstance(BaseViewModel item){
        if(!mTypeInstances.containsKey(item.getType())){
            mTypeInstances.put(item.getType().getValue(), item);
        }
    }

    public void addIems(List<BaseViewModel> newItems){
            for (BaseViewModel newItem: newItems){
                registerTypeInstance(newItem);
            }

            list.addAll(newItems);

            notifyDataSetChanged();
    }

    public void setItems(List<BaseViewModel> items){
        clearList();
        addIems(items);
    }


    public void clearList(){
        list.clear();
    }
}
