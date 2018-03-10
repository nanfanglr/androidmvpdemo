package com.mvp.rui.androidmvpdemo.common.basemvp;

import android.support.annotation.UiThread;

import com.hannesdorfmann.mosby3.mvp.MvpView;

/**
 * Created by 0200030 on 2017/9/16.
 */

public interface LoadMvpView extends MvpView {

    @UiThread
    void showLoadingBar();

    @UiThread
    void dismissLoadingBar();

    @UiThread
    void showLoadingFailureError();

}
