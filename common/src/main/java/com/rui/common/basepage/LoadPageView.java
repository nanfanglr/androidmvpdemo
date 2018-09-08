package com.rui.common.basepage;

import android.support.annotation.UiThread;

import com.rui.mvp.basemvp.LoadMvpView;

/**
 * Created by rui on 2018/3/9.
 */
public interface LoadPageView extends LoadMvpView {

    @UiThread
    void finishRefreshOrLoadMore(int type);

    @UiThread
    void finishLoadMoreWithNoMoreData();

}
