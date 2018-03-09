package com.mvp.rui.androidmvpdemo.module.ui;

import android.os.Bundle;

import com.mvp.rui.androidmvpdemo.R;
import com.mvp.rui.androidmvpdemo.base.activity.BaseActivity;
import com.mvp.rui.androidmvpdemo.module.di.contract.MainView;
import com.mvp.rui.androidmvpdemo.module.presenter.MainPresenter;
import com.mvp.rui.androidmvpdemo.module.viewstate.MainActivityViewState;

/**
 * 2018.2.10 上传GitHub测试
 */
public class MainActivity extends BaseActivity<
        MainView
        , MainPresenter
        , MainActivityViewState> implements MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void showLoadingBar() {

    }

    @Override
    public void dismissLoadingBar() {

    }

    @Override
    public void showLoadingFailureError() {

    }
}
