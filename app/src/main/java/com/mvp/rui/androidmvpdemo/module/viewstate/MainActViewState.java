package com.mvp.rui.androidmvpdemo.module.viewstate;

import com.hannesdorfmann.mosby3.mvp.viewstate.ViewState;
import com.mvp.rui.androidmvpdemo.module.di.contract.MainActView;

import javax.inject.Inject;

/**
 * Created by rui on 2018/3/9.
 */
public class MainActViewState implements ViewState<MainActView> {

    @Inject
    public MainActViewState() {
        // used by dagger
    }

    @Override
    public void apply(MainActView view, boolean retained) {

    }
}
