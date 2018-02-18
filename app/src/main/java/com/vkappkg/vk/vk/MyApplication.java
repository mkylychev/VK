package com.vkappkg.vk.vk;

import android.app.Application;

import com.vk.sdk.VKSdk;

/**
 * Created by myrzabek on 2/18/18.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        VKSdk.initialize(this);
    }
}
