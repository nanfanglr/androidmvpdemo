package com.rui.common.basepage;

import android.support.annotation.UiThread;

import com.rui.mvp.basemvp.LoadMvpView;

/**
 * 定义上拉下拉刷新的结束动画接口
 * Created by rui on 2018/9/8.
 */
public interface LoadPageView extends LoadMvpView {

    @UiThread
    void finishRefreshOrLoadMore(int type);

    @UiThread
    void finishLoadMoreWithNoMoreData();

}
