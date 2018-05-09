package com.vkappkg.vk.vk.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.vkappkg.vk.vk.CurrentUser;
import com.vkappkg.vk.vk.MyApplication;
import com.vkappkg.vk.vk.R;
import com.vkappkg.vk.vk.rest.api.WallApi;
import com.vkappkg.vk.vk.rest.model.response.BaseItemResponse;
import com.vkappkg.vk.vk.rest.model.response.Full;
import com.vkappkg.vk.vk.rest.model.response.WallGetResponse;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFeedFragment extends BaseFragment {

    @Inject
    WallApi mWallApi;

    public NewsFeedFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getsApplicationCopmonent().inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mWallApi.get("-86529522", CurrentUser.getAccesToken(), 1, "5.67").enqueue(new Callback<WallGetResponse>() {
            @Override
            public void onResponse(Call<WallGetResponse> call, Response<WallGetResponse> response) {
                Toast.makeText(getActivity(), "Likes = "+ response.body().response.getItems().get(0).getLikes().getCount(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call  <WallGetResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    protected int getMainContentLayout() {
        return R.layout.fragment_feed;
    }


    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_news;
    }

}
