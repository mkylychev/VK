package com.vkappkg.vk.vk.di.module;


import com.vkappkg.vk.vk.common.manager.MyFragmentManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ManagerModule {

    @Singleton
    @Provides
    MyFragmentManager provideMyFragmentManager(){
        return new MyFragmentManager();
    }
}
