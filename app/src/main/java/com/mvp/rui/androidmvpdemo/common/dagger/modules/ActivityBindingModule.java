package com.mvp.rui.androidmvpdemo.common.dagger.modules;

import com.mvp.rui.androidmvpdemo.common.dagger.scopes.ActivityScope;
import com.mvp.rui.androidmvpdemo.module.di.module.MainActModule;
import com.mvp.rui.androidmvpdemo.module.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

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

//    @ActivityScope
//    @ContributesAndroidInjector
//    abstract RuntimePermissionsActivity contributeRuntimePermissionsActivity();

}
