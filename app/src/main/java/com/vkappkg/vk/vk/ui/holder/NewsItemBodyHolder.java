package com.vkappkg.vk.vk.ui.holder;


import android.view.View;
import android.widget.TextView;

import com.vkappkg.vk.vk.R;
import com.vkappkg.vk.vk.model.view.NewsFeedItemBodyViewModel;

public class NewsItemBodyHolder extends BaseViewHolder<NewsFeedItemBodyViewModel>{

    public TextView mText;

    public NewsItemBodyHolder(View itemView) {
        super(itemView);
        mText = (TextView) itemView.findViewById(R.id.tv_text);
    }

    @Override
    public void bindViewHolder(NewsFeedItemBodyViewModel newsFeedItemBody) {
        mText.setText(newsFeedItemBody.getText());
    }

    @Override
    public void unBindViewHolder() {
        mText.setText(null);
    }
}
