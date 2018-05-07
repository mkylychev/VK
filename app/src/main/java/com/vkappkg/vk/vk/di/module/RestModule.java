package com.vkappkg.vk.vk.di.module;


import com.vkappkg.vk.vk.rest.RestClient;
import com.vkappkg.vk.vk.rest.api.WallApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RestModule {
    private RestClient mRestClient;

    public RestModule(){
        mRestClient = new RestClient();
    }

    @Singleton
    @Provides
    public RestClient provideRestClient(){
        return mRestClient;
    }

    @Singleton
    @Provides
    public WallApi provideWallApi(){
        return mRestClient.createService(WallApi.class);
    }
}
