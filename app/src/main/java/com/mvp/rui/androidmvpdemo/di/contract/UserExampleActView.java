package com.mvp.rui.androidmvpdemo.di.contract;


import com.rui.mvp.basemvp.LoadMvpView;

/**
 * Created by rui on 2018/3/9.
 */
public interface UserExampleActView extends LoadMvpView {
    /**
     * 登录后刷新userinfo的回调
     *
     * @param result
     */
    void updateUserInfo(String result);

    /**
     * 登录完成后的回调
     */
    void onLogin();

}
