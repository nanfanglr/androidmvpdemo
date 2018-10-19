package com.mvp.rui.androidmvpdemo;

import com.mvp.rui.androidmvpdemo.di.component.ApplicationComponent;
import com.mvp.rui.androidmvpdemo.di.component.DaggerApplicationComponent;
import com.mvp.rui.androidmvpdemo.rxutils.ObservableSubscribeHooker;
import com.rui.mvp.BaseApplication.BaseApplication;

import io.reactivex.plugins.RxJavaPlugins;

public class App extends BaseApplication {

    private static ApplicationComponent applicationComponent;

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化利用RxJavaPlugins处理Api相关异常，这样就不需要自定义GsonConverterFactory
        RxJavaPlugins.setOnObservableSubscribe((observable, observer) ->
                new ObservableSubscribeHooker(observer, App.this));
    }

    @Override
    protected void initDagger() {
        applicationComponent = DaggerApplicationComponent.builder()
                .application(this)
                .build();
        applicationComponent.inject(this);
    }

    @Override
    public boolean isDebug() {
        return BuildConfig.DEBUG;
    }


}
