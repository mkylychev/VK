package com.vkappkg.vk.vk.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.vkappkg.vk.vk.CurrentUser;
import com.vkappkg.vk.vk.mvp.view.MainView;

/**
 * Created by myrzabek on 3/4/18.
 */

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView>{

    public void checkAuth(){
        if(!CurrentUser.isAuthorized()){
            getViewState().startSignIn();
        }else {
            getViewState().signedId();
        }
    }
}
