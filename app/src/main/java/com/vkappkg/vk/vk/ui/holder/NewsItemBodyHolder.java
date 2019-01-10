package com.vkappkg.vk.vk.ui.holder;


import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

import com.vkappkg.vk.vk.MyApplication;
import com.vkappkg.vk.vk.R;
import com.vkappkg.vk.vk.model.view.NewsFeedItemBodyViewModel;

import javax.inject.Inject;

public class NewsItemBodyHolder extends BaseViewHolder<NewsFeedItemBodyViewModel>{

    private TextView tvText;

    private TextView tvAttachments;

    @Inject
    protected Typeface mFontGoogle;

    public NewsItemBodyHolder(View itemView) {
        super(itemView);
        MyApplication.getsApplicationCopmonent().inject(this);
        tvText = (TextView) itemView.findViewById(R.id.tv_text);
        tvAttachments = (TextView) itemView.findViewById(R.id.tv_attachments);

        if(tvAttachments != null){
            tvAttachments.setTypeface(mFontGoogle);
        }
    }

    @Override
    public void bindViewHolder(NewsFeedItemBodyViewModel newsFeedItemBody) {
        tvText.setText(newsFeedItemBody.getText());
        tvAttachments.setText(newsFeedItemBody.getAttachmentsString());
    }

    @Override
    public void unBindViewHolder() {
        tvText.setText(null);
        tvAttachments.setText(null);
    }
}
