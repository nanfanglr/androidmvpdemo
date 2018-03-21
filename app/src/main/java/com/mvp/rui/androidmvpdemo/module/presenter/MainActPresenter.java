package com.mvp.rui.androidmvpdemo.module.presenter;

import com.mvp.rui.androidmvpdemo.common.basemvp.BasePresenter;
import com.mvp.rui.androidmvpdemo.module.di.contract.MainActView;

import javax.inject.Inject;

/**
 * Created by rui on 2018/3/9.
 */
public class MainActPresenter extends BasePresenter<MainActView> {

    @Inject
    public MainActPresenter() {
    }

}
