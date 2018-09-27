package com.rui.common.basepage;

import android.content.Context;

import com.rui.mvp.network.ApiErro.MyConsumer;

/**
 * Created by rui on 2018/8/1
 */
public class MyListConsumer extends MyConsumer {

    private LoadPageView loadMvpView;
    private int refresh = -1;


    /**
     * 列表下拉刷新出错处理
     *
     * @param context
     * @param loadMvpView
     * @param refresh
     */
    public MyListConsumer(Context context, LoadPageView loadMvpView, int refresh) {
        super(context);
        this.loadMvpView = loadMvpView;
        this.refresh = refresh;
    }

    @Override
    public void accept(Throwable throwable) throws Exception {
        if (refresh != -1 && loadMvpView != null) {
            loadMvpView.finishRefreshOrLoadMore(refresh);
        }
        super.accept(throwable);
    }
}
