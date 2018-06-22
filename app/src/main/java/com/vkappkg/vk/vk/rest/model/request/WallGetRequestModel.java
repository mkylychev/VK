package com.vkappkg.vk.vk.rest.model.request;


import com.google.gson.annotations.SerializedName;
import com.vk.sdk.api.VKApiConst;
import com.vkappkg.vk.vk.consts.ApiConstants;

import java.util.Map;

public class WallGetRequestModel extends BaseRequestModel{

    @SerializedName(VKApiConst.OWNER_ID)
    int ownerID;

    @SerializedName(VKApiConst.COUNT)
    int count = ApiConstants.DEFAULT_COUNT;

    @SerializedName(VKApiConst.OFFSET)
    int offset;

    @SerializedName(VKApiConst.EXTENDED)
    int extended = 1;


    public WallGetRequestModel(int ownerID, int count, int offset) {
        this.ownerID = ownerID;
        this.count = count;
        this.offset = offset;
    }

    public WallGetRequestModel(int ownerID) {
        this.ownerID = ownerID;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getExtended() {
        return extended;
    }

    public void setExtended(int extended) {
        this.extended = extended;
    }

    @Override
    public void onMapCreate(Map<String, String> map) {
          map.put(VKApiConst.OWNER_ID, String.valueOf(getOwnerID()));
          map.put(VKApiConst.COUNT, String.valueOf(getCount()));
          map.put(VKApiConst.OFFSET, String.valueOf(getOffset()));
          map.put(VKApiConst.EXTENDED, String.valueOf(getExtended()));
    }
}
