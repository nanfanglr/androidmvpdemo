package com.mvp.rui.androidmvpdemo.presenter;


import android.content.Context;

import com.rui.android_mvp_with_componentization.datasource.UserInfoRepository;
import com.rui.android_mvp_with_componentization.di.contract.UserInfoActView;
import com.rui.mvp.basemvp.BaseLoadPresenter;

import javax.inject.Inject;

/**
 * Created by rui on 2018/3/9.
 */
public class UserInfoActPresenter extends BaseLoadPresenter<UserInfoActView> {

    private final UserInfoRepository userInfoRepository;
    private Context context;

    @Inject
    public UserInfoActPresenter(UserInfoRepository userInfoRepository, Context context) {
        this.userInfoRepository = userInfoRepository;
        this.context = context;
    }

    public void getUserInfo() {
        composite.add(userInfoRepository.getUserInfoOB()
                .subscribe(userInfo -> getView().onUserInfo(userInfo))
        );
    }


}
