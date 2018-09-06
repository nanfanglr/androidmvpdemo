package com.mvp.rui.androidmvpdemo.viewstate;

import com.hannesdorfmann.mosby3.mvp.viewstate.ViewState;
import com.mvp.rui.androidmvpdemo.di.contract.HomeChildFgView;

import javax.inject.Inject;

/**
 * Created by rui on 2018/3/9.
 */
public class HomeChildFgViewState implements ViewState<HomeChildFgView> {

    @Inject
    public HomeChildFgViewState() {
        // used by dagger
    }

    @Override
    public void apply(HomeChildFgView view, boolean retained) {

    }
}
