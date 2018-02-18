package com.vkappkg.vk.vk;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKSdk;

/**
 * Created by myrzabek on 2/18/18.
 */

public class CurrentUser {
    public static String getAccesToken(){
        if(VKAccessToken.currentToken() ==null)
            return  null;

        return VKAccessToken.currentToken().accessToken;

    }

    public static String getId(){
        if(VKAccessToken.currentToken() == null)
            return null;

        return VKAccessToken.currentToken().userId;
    }

    public static boolean isAuthorized(){
        return VKSdk.isLoggedIn()
                && VKAccessToken.currentToken() != null
                && !VKAccessToken.currentToken().isExpired();
    }

}
