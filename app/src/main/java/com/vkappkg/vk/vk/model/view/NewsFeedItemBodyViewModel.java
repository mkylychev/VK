package com.vkappkg.vk.vk.model.view;


import android.view.View;

import com.vkappkg.vk.vk.model.WallItem;
import com.vkappkg.vk.vk.ui.holder.BaseViewHolder;
import com.vkappkg.vk.vk.ui.holder.NewsItemBodyHolder;

public class NewsFeedItemBodyViewModel extends BaseViewModel{

    private int mId;
    private String mText;

    public NewsFeedItemBodyViewModel(WallItem item) {
        this.mId = item.getId();
        this.mText = item.getText();
    }

    @Override
    public LayoutTypes getType() {
        return LayoutTypes.NewsFeedItemBody;
    }

    @Override
    protected BaseViewHolder onCreateViewHolder(View view) {
        return new NewsItemBodyHolder(view);
    }


    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getText() {
        return mText;
    }

    public void setText(String mText) {
        this.mText = mText;
    }
}
