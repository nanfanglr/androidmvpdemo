package com.mvp.rui.androidmvpdemo.di.module;


import android.content.Context;
import android.support.v4.app.Fragment;

import com.mvp.rui.androidmvpdemo.mapper.HomeMapper;
import com.mvp.rui.androidmvpdemo.netservice.HomeService;
import com.mvp.rui.androidmvpdemo.ui.fragment.HomeChildFragment;
import com.mvp.rui.androidmvpdemo.ui.fragment.HomeChildVSFragment;
import com.mvp.rui.androidmvpdemo.ui.fragment.HomeFragment;
import com.rui.mvp.dagger.modules.BaseFragmentModule;
import com.rui.mvp.dagger.scopes.ChildFragmentScope;
import com.rui.mvp.dagger.scopes.FragmentScope;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import retrofit2.Retrofit;

/**
 * 负责提供HomeFragment所需要的依赖
 */
@Module(includes = BaseFragmentModule.class)
public abstract class HomeFgModule {

    @Binds
    @Named(BaseFragmentModule.FRAGMENT)
    @FragmentScope
    abstract Fragment fragment(HomeFragment homeFragment);

    /**
     * Provides the injector for the {@link HomeChildVSFragment}, which has access to the
     * dependencies provided by this fragment and activity and application instance
     * (singleton scoped objects).
     */
    @ChildFragmentScope
    @ContributesAndroidInjector(modules = HomeChildFgModule.class)
    abstract HomeChildFragment homeChildFragmentInjector();

    /**
     * provides 的对象写法
     *
     * @return
     */
    @Provides
    static HomeService providesHomeService(Retrofit retrofit) {
        return retrofit.create(HomeService.class);
    }

    /**
     * provides 的对象写法
     *
     * @return
     */
    @Provides
    static HomeMapper providesHomeMapper(Context context) {
        return new HomeMapper(context);
    }
}
