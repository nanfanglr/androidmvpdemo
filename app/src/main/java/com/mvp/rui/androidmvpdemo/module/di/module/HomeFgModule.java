package com.mvp.rui.androidmvpdemo.module.di.module;


import android.content.Context;
import android.support.v4.app.Fragment;

import com.mvp.rui.androidmvpdemo.common.dagger.modules.BaseFragmentModule;
import com.mvp.rui.androidmvpdemo.common.dagger.scopes.PerChildFragment;
import com.mvp.rui.androidmvpdemo.common.dagger.scopes.PerFragment;
import com.mvp.rui.androidmvpdemo.module.mapper.HomeMapper;
import com.mvp.rui.androidmvpdemo.module.networkservice.HomeService;
import com.mvp.rui.androidmvpdemo.module.ui.fragment.HomeChildFragment;
import com.mvp.rui.androidmvpdemo.module.ui.fragment.HomeFragment;

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
