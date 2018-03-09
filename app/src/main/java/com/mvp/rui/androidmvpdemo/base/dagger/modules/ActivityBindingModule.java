package com.mvp.rui.androidmvpdemo.base.dagger.modules;

import com.mvp.rui.androidmvpdemo.base.dagger.scopes.ActivityScope;
import com.mvp.rui.androidmvpdemo.module.di.module.MainActivityModule;
import com.mvp.rui.androidmvpdemo.module.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity contributeMainActivityInjector();

//    @ActivityScope
//    @ContributesAndroidInjector
//    abstract RuntimePermissionsActivity contributeRuntimePermissionsActivity();

}
