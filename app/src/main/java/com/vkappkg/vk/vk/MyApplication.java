package com.vkappkg.vk.vk;

import android.app.Application;

import com.vk.sdk.VKSdk;
import com.vkappkg.vk.vk.di.component.ApplicationComponent;
import com.vkappkg.vk.vk.di.component.DaggerApplicationComponent;
import com.vkappkg.vk.vk.di.module.ApplicationModule;

/**
 * Created by myrzabek on 2/18/18.
 */

public class MyApplication extends Application {

    private static ApplicationComponent sApplicationCopmonent;

    @Override
    public void onCreate() {
        super.onCreate();
        initComponent();
        VKSdk.initialize(this);
    }

    private void initComponent(){
        sApplicationCopmonent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
    }

    public static ApplicationComponent getsApplicationCopmonent(){
        return sApplicationCopmonent;
    }

}
