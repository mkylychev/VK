package com.vkappkg.vk.vk.rest.api;


import com.vkappkg.vk.vk.rest.model.response.BaseItemResponse;
import com.vkappkg.vk.vk.rest.model.response.Full;
import com.vkappkg.vk.vk.rest.model.response.WallGetResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WallApi {

    @GET(ApiMethods.WALL_GET)
    Call<WallGetResponse> get(@Query("owner_id") String ownerId,
                                    @Query("access_token") String accessToken,
                                    @Query("extended") Integer  extended,
                                    @Query("v") String version);

}
