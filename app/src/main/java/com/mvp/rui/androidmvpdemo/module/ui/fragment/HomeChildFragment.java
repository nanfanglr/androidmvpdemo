package com.mvp.rui.androidmvpdemo.module.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.mvp.rui.androidmvpdemo.R;
import com.mvp.rui.androidmvpdemo.common.fragment.BaseLazyFragment;
import com.mvp.rui.androidmvpdemo.module.di.contract.HomeChildFgView;
import com.mvp.rui.androidmvpdemo.module.presenter.HomeChildFgPresenter;
import com.mvp.rui.androidmvpdemo.module.viewstate.HomeChildFgViewState;

/**
 * Created by rui on 2018/3/12.
 */
public class HomeChildFragment extends BaseLazyFragment<
        HomeChildFgView
        , HomeChildFgPresenter
        , HomeChildFgViewState
        > {

    public static HomeChildFragment newInstance(Context context) {
        Bundle bundle = new Bundle();
        return (HomeChildFragment) Fragment.instantiate(context, HomeChildFragment.class.getName(), bundle);
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

    @Override
    protected int getLayout() {
        return R.layout.fragment_homechild;
    }

    @Override
    protected void lazyFetchData() {

    }
}
