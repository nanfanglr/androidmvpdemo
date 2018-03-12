package com.mvp.rui.androidmvpdemo.module.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.mvp.rui.androidmvpdemo.R;
import com.mvp.rui.androidmvpdemo.common.fragment.BaseLazyFragment;
import com.mvp.rui.androidmvpdemo.module.di.contract.HomeFgView;
import com.mvp.rui.androidmvpdemo.module.presenter.HomeFgPresenter;
import com.mvp.rui.androidmvpdemo.module.viewstate.HomeFgViewState;

/**
 * Created by rui on 2018/3/12.
 */
public class HomeFragment extends BaseLazyFragment<
        HomeFgView,
        HomeFgPresenter,
        HomeFgViewState
        > {

    public static HomeFragment newInstance(Context context) {
        Bundle bundle = new Bundle();
        return (HomeFragment) Fragment.instantiate(context, HomeFragment.class.getName(), bundle);
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
        return R.layout.fragment_home;
    }

    @Override
    protected void lazyFetchData() {

    }
}
