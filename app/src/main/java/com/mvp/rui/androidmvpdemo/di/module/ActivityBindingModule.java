package com.mvp.rui.androidmvpdemo.di.module;

import com.mvp.rui.androidmvpdemo.ui.LoginActivity;
import com.mvp.rui.androidmvpdemo.ui.MainActivity;
import com.mvp.rui.androidmvpdemo.ui.MainVSActivity;
import com.mvp.rui.androidmvpdemo.ui.UserExampleActivity;
import com.mvp.rui.androidmvpdemo.ui.UserInfoActivity;
import com.rui.mvp.dagger.scopes.ActivityScope;

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

    /**
     * 注入依赖到LoginActivity
     *
     * @return
     */
    @ActivityScope
    @ContributesAndroidInjector(modules = LoginActModule.class)
    abstract LoginActivity contributeLoginActivityInjector();

    /**
     * 注入依赖到 MainActivity
     *
     * @return
     */
    @ActivityScope
    @ContributesAndroidInjector(modules = UserExampleActModule.class)
    abstract UserExampleActivity contributeUserExampleActivityInjector();

    /**
     * 注入依赖到 UserInfoActivity
     *
     * @return
     */
    @ActivityScope
    @ContributesAndroidInjector(modules = UserInfoActModule.class)
    abstract UserInfoActivity contributeUserInfoActivityInjector();


}
