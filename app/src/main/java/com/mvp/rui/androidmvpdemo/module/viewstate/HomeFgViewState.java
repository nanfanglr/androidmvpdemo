package com.mvp.rui.androidmvpdemo.module.viewstate;

import com.hannesdorfmann.mosby3.mvp.viewstate.ViewState;
import com.mvp.rui.androidmvpdemo.module.di.contract.HomeFgView;

import javax.inject.Inject;

/**
 * Created by rui on 2018/3/9.
 */
public class HomeFgViewState implements ViewState<HomeFgView> {

    @Inject
    public HomeFgViewState() {
        // used by dagger
    }

    @Override
    public void apply(HomeFgView view, boolean retained) {

    }
}
