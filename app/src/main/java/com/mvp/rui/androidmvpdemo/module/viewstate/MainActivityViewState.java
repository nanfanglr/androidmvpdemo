package com.mvp.rui.androidmvpdemo.module.viewstate;

import com.hannesdorfmann.mosby3.mvp.viewstate.ViewState;
import com.mvp.rui.androidmvpdemo.module.di.contract.MainView;

import javax.inject.Inject;

/**
 * Created by rui on 2018/3/9.
 */

public class MainActivityViewState implements ViewState<MainView> {

    @Inject
    public MainActivityViewState() {
        // used by dagger
    }

    @Override
    public void apply(MainView view, boolean retained) {

    }
}
