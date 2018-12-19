package com.vkappkg.vk.vk.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.vkappkg.vk.vk.CurrentUser;
import com.vkappkg.vk.vk.MyApplication;
import com.vkappkg.vk.vk.R;
import com.vkappkg.vk.vk.common.BaseAdapter;
import com.vkappkg.vk.vk.common.utils.VkListHelper;
import com.vkappkg.vk.vk.model.WallItem;
import com.vkappkg.vk.vk.model.view.BaseViewModel;
import com.vkappkg.vk.vk.model.view.NewsFeedItemBodyViewModel;
import com.vkappkg.vk.vk.model.view.NewsItemHeaderViewModel;
import com.vkappkg.vk.vk.rest.api.WallApi;
import com.vkappkg.vk.vk.rest.model.request.WallGetRequestModel;
import com.vkappkg.vk.vk.rest.model.response.BaseItemResponse;
import com.vkappkg.vk.vk.rest.model.response.Full;
import com.vkappkg.vk.vk.rest.model.response.WallGetResponse;

import java.util.ArrayList;
import java.util.List;

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

    RecyclerView mRecyclerView;
    BaseAdapter mBaseAdapter;


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

        mWallApi.get(new WallGetRequestModel(-86529522).toMap()).enqueue(new Callback<WallGetResponse>() {
            @Override
            public void onResponse(Call<WallGetResponse> call, Response<WallGetResponse> response) {
                List<WallItem> wallItems = VkListHelper.getWallList(response.body().response);
                List<BaseViewModel> list = new ArrayList<>();

                for (WallItem item : wallItems){
                    list.add(new NewsItemHeaderViewModel(item));
                    list.add(new NewsFeedItemBodyViewModel(item));
                }

                mBaseAdapter.addIems(list);

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

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpRecyclerView(view);
        setUpAdapter(mRecyclerView);
    }

    private void setUpRecyclerView(View rootView){
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.rv_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void setUpAdapter(RecyclerView recyclerView){
        mBaseAdapter = new BaseAdapter();
        recyclerView.setAdapter(mBaseAdapter);
    }

}
