package com.rui.common.basepage;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.rui.common.R;
import com.rui.toolkit.util.BarUtils;

import javax.annotation.Nullable;

/**
 * 这是一个给列表封装的BaseActivity,封转列表的初始化，emptyView，上拉加载下拉刷新框架
 * 根据项目需求修改页面相关的逻辑
 * Created by rui on 2018/7/28.
 */
public abstract class BaseTranListActivity<
        VIEW extends LoadPageView,
        PRESENTER extends MvpPresenter<VIEW>,
        ADAPTER extends BaseQuickAdapter,
        LAYOUTMANAGER extends RecyclerView.LayoutManager
        >
        extends BaseListActivity<VIEW, PRESENTER, ADAPTER, LAYOUTMANAGER> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BarUtils.setStatusBarColor(this, ContextCompat.getColor(this, R.color.colorPrimary), 0);
        BarUtils.setStatusBarLightMode(this, true);
        BarUtils.addMarginTopEqualStatusBarHeight(getRootLayout());
    }


    public abstract ViewGroup getRootLayout();
}
