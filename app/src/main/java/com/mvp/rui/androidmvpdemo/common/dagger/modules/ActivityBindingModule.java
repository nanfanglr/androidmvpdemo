package com.mvp.rui.androidmvpdemo.common.dagger.modules;

import com.mvp.rui.androidmvpdemo.common.dagger.scopes.ActivityScope;
import com.mvp.rui.androidmvpdemo.module.di.module.MainActModule;
import com.mvp.rui.androidmvpdemo.module.di.module.MainActVSModule;
import com.mvp.rui.androidmvpdemo.module.ui.MainActivity;
import com.mvp.rui.androidmvpdemo.module.ui.MainVSActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by rui on 2018/3/9.
 */
@Module
public abstract class ActivityBindingModule {
    /**
     * 注入依赖到MainActivity
     *
     * @return
     */
    @ActivityScope
    @ContributesAndroidInjector(modules = MainActModule.class)
    abstract MainActivity contributeMainActivityInjector();

    /**
     * 注入依赖到MainVSActivity
     *
     * @return
     */
    @ActivityScope
    @ContributesAndroidInjector(modules = MainActVSModule.class)
    abstract MainVSActivity contributeMainVSActivityInjector();

//    @ActivityScope
//    @ContributesAndroidInjector
//    abstract RuntimePermissionsActivity contributeRuntimePermissionsActivity();

}
