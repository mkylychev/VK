package com.vkappkg.vk.vk.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;
import com.vk.sdk.util.VKUtil;
import com.vkappkg.vk.vk.CurrentUser;
import com.vkappkg.vk.vk.MyApplication;
import com.vkappkg.vk.vk.R;
import com.vkappkg.vk.vk.consts.ApiConstants;
import com.vkappkg.vk.vk.mvp.presenter.MainPresenter;
import com.vkappkg.vk.vk.mvp.view.MainView;
import com.vkappkg.vk.vk.ui.fragment.NewsFeedFragment;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainActivity extends BaseActivity implements MainView {

    @InjectPresenter
    MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getsApplicationCopmonent().inject(this);
        mPresenter.checkAuth();
    }

    @Override
    protected int getMainContentLayout() {
        return R.layout.activity_main;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                // User passed Authorization
                mPresenter.checkAuth();
            }
            @Override
            public void onError(VKError error) {
                // User didn't pass Authorization
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void startSignIn() {
        VKSdk.login(this, ApiConstants.DEFAULT_LOGIN_SCOPE);
    }

    @Override
    public void signedId() {
        Toast.makeText(this, "Current user id: " + CurrentUser.getId(),Toast.LENGTH_SHORT).show();
        setContent(new NewsFeedFragment());
    }

}
