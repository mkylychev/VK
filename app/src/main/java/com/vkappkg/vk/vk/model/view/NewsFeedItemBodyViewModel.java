package com.vkappkg.vk.vk.model.view;


import android.view.View;

import com.vkappkg.vk.vk.model.WallItem;
import com.vkappkg.vk.vk.ui.holder.BaseViewHolder;
import com.vkappkg.vk.vk.ui.holder.NewsItemBodyHolder;

public class NewsFeedItemBodyViewModel extends BaseViewModel{

    private int mId;
    private String mText;
    private String mAttachmentsString;

    private boolean mIsRepost;

    public NewsFeedItemBodyViewModel(WallItem item) {
        this.mId = item.getId();
        this.mIsRepost = item.haveSharedRepost();

        if(mIsRepost){
            this.mText = item.getSharedRepost().getText();
            this.mAttachmentsString = item.getSharedRepost().getAttachmentsString();
        } else {
            this.mText = item.getText();
            this.mAttachmentsString = item.getAttachmentsString();
        }




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

    public String getAttachmentsString() {
        return mAttachmentsString;
    }
}
