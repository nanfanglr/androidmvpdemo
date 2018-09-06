package com.mvp.rui.androidmvpdemo;

import com.mvp.rui.androidmvpdemo.di.component.ApplicationComponent;
import com.mvp.rui.androidmvpdemo.di.component.DaggerApplicationComponent;
import com.rui.mvp.BaseApplication.BaseApplication;

public class App extends BaseApplication {

    private static ApplicationComponent applicationComponent;

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

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
