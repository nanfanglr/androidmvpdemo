package com.rui.mvp.BaseApplication;

import android.app.Activity;
import android.support.multidex.MultiDexApplication;

import com.squareup.leakcanary.LeakCanary;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import timber.log.Timber;

public abstract class BaseApplication extends MultiDexApplication implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingActivityInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
        initTimber();
        setupLeakCanary();
    }

    /**
     * 初始化dagger2注入
     */
    protected abstract void initDagger();

    /**
     * 初始化timber日志
     */
    private void initTimber() {
        if (isDebug()) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    /**
     * 获取当前是否debug模式
     *
     * @return
     */
    public abstract boolean isDebug();

    protected void setupLeakCanary() {
        if (isDebug()) {
            if (LeakCanary.isInAnalyzerProcess(this)) {
                // This process is dedicated to LeakCanary for heap analysis.
                // You should not init your app in this process.
                return;
            }
            LeakCanary.install(this);
        }
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingActivityInjector;
    }

}
