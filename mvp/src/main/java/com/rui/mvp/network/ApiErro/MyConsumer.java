package com.rui.mvp.network.ApiErro;

import android.content.Context;

import io.reactivex.functions.Consumer;

/**
 * Created by rui on 2018/8/1
 */
public class MyConsumer implements Consumer<Throwable> {

    private Context context;

    public MyConsumer(Context context) {
        this.context = context;
    }

    @Override
    public void accept(Throwable throwable) throws Exception {
        throwable.printStackTrace();
        ApiErrorHelper.handleCommonError(context, throwable);
    }
}
