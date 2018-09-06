package com.rui.android_mvp_with_componentization.di.module;


import com.rui.android_mvp_with_componentization.ui.UserExampleActivity;
import com.rui.android_mvp_with_componentization.ui.LoginActivity;
import com.rui.android_mvp_with_componentization.ui.UserInfoActivity;
import com.rui.mvp.dagger.scopes.ActivityScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by rui on 2018/3/9.
 */
@Module
public abstract class ActivityBindingModule {
    /**
     * 注入依赖到LoginActivity
     *
     * @return
     */
    @ActivityScope
    @ContributesAndroidInjector(modules = LoginActModule.class)
    abstract LoginActivity contributeMainActivityInjector();

    /**
     * 注入依赖到 MainActivity
     *
     * @return
     */
    @ActivityScope
    @ContributesAndroidInjector(modules = UserExampleActModule.class)
    abstract UserExampleActivity contributeSplashActivityInjector();

    /**
     * 注入依赖到 SplashActivity
     *
     * @return
     */
    @ActivityScope
    @ContributesAndroidInjector(modules =  UserInfoActModule.class)
    abstract UserInfoActivity contributeUserInfoActivityInjector();
//    /**
//     * 注入依赖到MainVSActivity
//     *
//     * @return
//     */
//    @ActivityScope
//    @ContributesAndroidInjector(modules = MainActVSModule.class)
//    abstract MainVSActivity contributeMainVSActivityInjector();

//    @ActivityScope
//    @ContributesAndroidInjector
//    abstract RuntimePermissionsActivity contributeRuntimePermissionsActivity();

}
