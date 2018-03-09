package com.mvp.rui.androidmvpdemo.module.di.module;

import android.content.Context;

import com.mvp.rui.androidmvpdemo.base.dagger.scopes.ActivityContext;
import com.mvp.rui.androidmvpdemo.module.ui.MainActivity;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MainActivityModule {

    @Binds
    @ActivityContext
    public abstract Context providesActivityContext(MainActivity mainActivity);

}
