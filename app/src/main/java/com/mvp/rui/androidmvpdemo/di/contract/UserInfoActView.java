package com.mvp.rui.androidmvpdemo.di.contract;

import com.rui.android_mvp_with_componentization.model.UserInfo;
import com.rui.mvp.basemvp.LoadMvpView;

/**
 * Created by rui on 2018/8/24
 */
public interface UserInfoActView extends LoadMvpView {

    void onUserInfo(UserInfo userInfo);

}
