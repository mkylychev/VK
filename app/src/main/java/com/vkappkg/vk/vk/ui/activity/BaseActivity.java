package com.vkappkg.vk.vk.ui.activity;


import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.vkappkg.vk.vk.MyApplication;
import com.vkappkg.vk.vk.R;
import com.vkappkg.vk.vk.common.manager.MyFragmentManager;
import com.vkappkg.vk.vk.ui.fragment.BaseFragment;

import javax.inject.Inject;

public abstract class BaseActivity extends MvpAppCompatActivity {

    @Inject
    MyFragmentManager myFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getsApplicationCopmonent().inject(this);
        setContentView(R.layout.activity_base);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FrameLayout parent = (FrameLayout) findViewById(R.id.main_wrapper);
        getLayoutInflater().inflate(getMainContentLayout(), parent);
    }

    @LayoutRes
    protected abstract int getMainContentLayout();

    public void fragmentOnScreen(BaseFragment fragment){
        setToolbarTitle(fragment.createToolbarTitle(this));
    }


    public void setToolbarTitle(String title){
            if(getSupportActionBar()!=null){
                getSupportActionBar().setTitle(title);
            }
    }

    public void setContent(BaseFragment fragment){
        myFragmentManager.setFragment(this, fragment, R.id.main_wrapper);
    }

    public void addContent(BaseFragment fragment){
        myFragmentManager.addFragmet(this, fragment, R.id.main_wrapper);
    }

    public boolean removeCurrentFragment(){
        return myFragmentManager.removeCurrentFragment(this);
    }

    public boolean removeFragment(BaseFragment fragment){
        return myFragmentManager.removeFragment(this, fragment);
    }

    @Override
    public void onBackPressed() {
        removeCurrentFragment();
    }
}
