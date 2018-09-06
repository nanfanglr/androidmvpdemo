package com.rui.mvp.network.ApiErro;

import android.content.Context;

import io.reactivex.SingleObserver;

/**
 * Created by rui on 2018/8/1
 */
public abstract class MySingleObserver<T> implements SingleObserver<T> {

    private Context context;

    public MySingleObserver(Context context) {
        this.context = context;
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
        ApiErrorHelper.handleCommonError(context, throwable);
    }
}
