package com.rui.android_mvp_with_componentization.di.contract;


import com.rui.mvp.basemvp.LoadMvpView;

/**
 * Created by rui on 2018/3/9.
 */
public interface LoginActView extends LoadMvpView {

    void onLogin(String result);

}
