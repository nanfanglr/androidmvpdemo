package com.mvp.rui.androidmvpdemo.rxutils;


import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.mvp.rui.androidmvpdemo.ui.UserInfoActivity;
import com.rui.mvp.network.ApiErro.ApiException;
import com.rui.mvp.network.basemodel.ResultModel;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

/**
 * 利用RxJavaPlugins处理Api相关异常,在这里写相关处理异常的代码
 * 用这个类处理之后需要到NetworkModule切换addConverterFactory(GsonConverterFactory.create())
 * https://www.jianshu.com/p/d6552d020307
 * Created by rui on 2018/10/18
 */
public class ObservableSubscribeHooker<T> implements Observer<T> {

    private static final String TAG = "OSibeHooker";
    private Observer<T> actual;
    private Handler mainHandler;
    private Context context;

    public ObservableSubscribeHooker(Observer<T> actual
            , Context context) {
        this.actual = actual;
        this.context = context;
        this.mainHandler = new Handler(context.getMainLooper());
    }

    @Override
    public void onSubscribe(Disposable d) {
        actual.onSubscribe(d);
    }

    @Override
    public void onNext(T t) {
        hookOnNext(t);
        actual.onNext(t);
    }

    private void hookOnNext(T t) {
        if (t instanceof ResultModel) {
            ResultModel baseResponse = (ResultModel) t;
            if (!baseResponse.isSuccess()) {
                mainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(context, baseResponse.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                });

                Intent intent = new Intent(context.getApplicationContext(), UserInfoActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                throw new ApiException(baseResponse.getCode(), baseResponse.getMsg());
            }
        }
    }


    @Override
    public void onError(Throwable e) {
        if (e instanceof ConnectException) {
            Log.e(TAG, "Connect failed: ", e);
            mainHandler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context.getApplicationContext(), "无网络连接", Toast.LENGTH_SHORT).show();
                }
            });
            actual.onError(e);
            return;
        }

        if (e instanceof SocketTimeoutException) {
            Log.e(TAG, "Time out ", e);
            mainHandler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context.getApplicationContext(), "服务连接超时", Toast.LENGTH_SHORT).show();
                }
            });
            actual.onError(e);
            return;
        }

        if (e instanceof HttpException) {
            Log.e(TAG, "HttpException ", e);
            int code = ((HttpException) e).code();
            mainHandler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context.getApplicationContext(), String.format("服务不可用，请稍后重试(%d)", code), Toast.LENGTH_SHORT).show();
                }
            });
            actual.onError(e);
            return;
        }

        //其余的异常处理...

        actual.onError(e);
    }

    @Override
    public void onComplete() {
        actual.onComplete();
    }

}
