package com.mvp.rui.androidmvpdemo;

import android.app.Activity;
import android.support.multidex.MultiDexApplication;

import com.mvp.rui.androidmvpdemo.dagger.components.ApplicationComponent;
import com.mvp.rui.androidmvpdemo.dagger.components.DaggerApplicationComponent;
import com.mvp.rui.androidmvpdemo.tools.stetho.StethoTool;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import timber.log.Timber;

@SuppressWarnings("checkstyle:ClassDataAbstractionCoupling")
public class App extends MultiDexApplication implements HasActivityInjector {

    private static ApplicationComponent applicationComponent;

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingActivityInjector;
    @Inject
    StethoTool stethoTool;


    @Override
    public void onCreate() {
        super.onCreate();
        initTimber(); // Timber at the very start of initialization so that we have logging.
        initDagger();
        initStetho();
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingActivityInjector;
    }

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    private void initDagger() {
        applicationComponent = DaggerApplicationComponent.builder()
                .application(this)
                .build();
        applicationComponent.inject(this);
    }

    /**
     * Setup Timber. We only enable the timber logcat tree in debug builds. Release builds tend to not have have logs:
     * a) As logs are not accessible to developers.
     * b) For security reasons.
     * c) For performance reasons.
     * <p>
     * Having said that, we plant a second tree that takes {@link Timber#wtf} calls and posts them to crashlytics (but not logcat).
     */
    private void initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }


    private void initStetho() {
        stethoTool.init();
    }


}
