package com.vkappkg.vk.vk.common.utils;


import com.vkappkg.vk.vk.model.Owner;
import com.vkappkg.vk.vk.model.WallItem;
import com.vkappkg.vk.vk.rest.model.response.ItemWithSendersResponse;

import java.util.List;

public class VkListHelper {
    public static List<WallItem> getWallList(ItemWithSendersResponse<WallItem> response){
     List<WallItem> wallItems = response.items;

        for (WallItem wallItem : wallItems){
            Owner sender = response.getSenders(wallItem.getFromId());
            wallItem.setSenderName(sender.getFullName());
            wallItem.setSenderPhoto(sender.getPhoto());

            if(wallItem.haveSharedRepost()){
                Owner repostSender = response.getSenders(wallItem.getSharedRepost().getFromId());
                wallItem.getSharedRepost().setSenderName(repostSender.getFullName());
                wallItem.getSharedRepost().setSenderPhoto(repostSender.getPhoto());

                wallItem.getSharedRepost().setAttachmentsString(Utils.convertAttachmentsToFontIcons(
                        wallItem.getSharedRepost().getApiAttachments()));

            }
        }
        return wallItems;
    }
}
