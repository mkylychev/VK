package com.vkappkg.vk.vk.rest.model.request;


import com.google.gson.annotations.SerializedName;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vkappkg.vk.vk.CurrentUser;
import com.vkappkg.vk.vk.consts.ApiConstants;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseRequestModel {

    @SerializedName(VKApiConst.VERSION)
    Double version = ApiConstants.DEFAULT_VERSION;

    @SerializedName(VKApiConst.ACCESS_TOKEN)
    String accessToken = CurrentUser.getAccesToken();


    public Double getVersion() {
        return version;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public Map<String, String> toMap(){
        Map<String, String> map = new HashMap<>();

        map.put(VKApiConst.VERSION, String.valueOf(getVersion()));
        if(accessToken !=null){
            map.put(VKApiConst.ACCESS_TOKEN, getAccessToken());
        }
        onMapCreate(map);
        return map;
    }

    public abstract void onMapCreate(Map<String, String> map);
}
