package com.mvp.rui.androidmvpdemo.common.basemvp;

import android.support.annotation.UiThread;

import com.hannesdorfmann.mosby3.mvp.MvpView;

/**
 * Created by rui on 2018/3/9.
 */
public interface LoadMvpView extends MvpView {

    @UiThread
    void showLoadingBar();

    @UiThread
    void dismissLoadingBar();

    @UiThread
    void showLoadingFailureError();

}
