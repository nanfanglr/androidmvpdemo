package com.rui.common.basepage;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.rui.common.R;
import com.rui.mvp.activity.BaseActivity;
import com.rui.mvp.basemvp.LoadMvpView;
import com.rui.toolkit.util.BarUtils;

import javax.annotation.Nullable;

/**
 * 沉浸式状态栏及
 * Created by rui on 2018/4/3.
 */
public abstract class BaseTranActivity<
        VIEW extends LoadMvpView,
        PRESENTER extends MvpPresenter<VIEW>>
        extends BaseActivity<VIEW, PRESENTER> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BarUtils.setStatusBarColor(this, ContextCompat.getColor(this, R.color.colorPrimary), 0);
        BarUtils.setStatusBarLightMode(this, true);
        BarUtils.addMarginTopEqualStatusBarHeight(getRootLayout());
    }

    public abstract ViewGroup getRootLayout();
}
