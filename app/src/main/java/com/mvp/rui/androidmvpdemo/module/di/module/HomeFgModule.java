package com.mvp.rui.androidmvpdemo.module.di.module;


import android.support.v4.app.Fragment;

import com.mvp.rui.androidmvpdemo.common.dagger.modules.BaseFragmentModule;
import com.mvp.rui.androidmvpdemo.common.dagger.scopes.PerChildFragment;
import com.mvp.rui.androidmvpdemo.common.dagger.scopes.PerFragment;
import com.mvp.rui.androidmvpdemo.module.ui.fragment.HomeChildFragment;
import com.mvp.rui.androidmvpdemo.module.ui.fragment.HomeFragment;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
/**
 * 负责提供HomeFragment所需要的依赖
 */
@Module(includes = BaseFragmentModule.class)
public abstract class HomeFgModule {

    @Binds
    @Named(BaseFragmentModule.FRAGMENT)
    @PerFragment
    abstract Fragment fragment(HomeFragment homeFragment);

    /**
     * Provides the injector for the {@link HomeChildFragment}, which has access to the
     * dependencies provided by this fragment and activity and application instance
     * (singleton scoped objects).
     */
    @PerChildFragment
    @ContributesAndroidInjector(modules = HomeChildFgModule.class)
    abstract HomeChildFragment homeChildFragmentInjector();

}
