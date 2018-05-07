package com.vkappkg.vk.vk.di.component;


import com.vkappkg.vk.vk.di.module.ApplicationModule;
import com.vkappkg.vk.vk.di.module.ManagerModule;
import com.vkappkg.vk.vk.ui.activity.BaseActivity;
import com.vkappkg.vk.vk.ui.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, ManagerModule.class})
public interface ApplicationComponent {

    //activities
    void inject(BaseActivity activity);
    void inject(MainActivity activity);
}
