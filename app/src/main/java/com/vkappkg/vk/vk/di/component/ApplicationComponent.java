package com.vkappkg.vk.vk.di.component;


import com.vkappkg.vk.vk.di.module.ApplicationModule;
import com.vkappkg.vk.vk.di.module.ManagerModule;
import com.vkappkg.vk.vk.di.module.RestModule;
import com.vkappkg.vk.vk.ui.activity.BaseActivity;
import com.vkappkg.vk.vk.ui.activity.MainActivity;
import com.vkappkg.vk.vk.ui.fragment.NewsFeedFragment;
import com.vkappkg.vk.vk.ui.holder.NewsItemBodyHolder;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, ManagerModule.class, RestModule.class})
public interface ApplicationComponent {

    //activities
    void inject(BaseActivity activity);
    void inject(MainActivity activity);

    //fragment
    void inject(NewsFeedFragment fragment);


    //holders
    void inject(NewsItemBodyHolder holder);
}
