package com.mvp.rui.androidmvpdemo.di.module;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;

import com.mvp.rui.androidmvpdemo.ui.LoginActivity;
import com.rui.android_mvp_with_componentization.example.TestModel;
import com.rui.mvp.activity.BaseVSActivity;
import com.rui.mvp.dagger.modules.BaseActivityModule;
import com.rui.mvp.dagger.scopes.ActivityScope;
import com.rui.mvp.dagger.scopes.ApplicationContext;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * 负责提供LoginActivity所需要的依赖
 */
@Module(includes = BaseActivityModule.class)
public abstract class LoginActModule {

//    /**
//     * Provides the injector for the {@link HomeVSFgModule}, which has access to the dependencies
//     * provided by this activity and application instance (singleton scoped objects).
//     */
//    @FragmentScope
//    @ContributesAndroidInjector(modules = HomeFgModule.class)
//    abstract HomeFragment homeFragmentInjector();
//
//    @FragmentScope
//    @ContributesAndroidInjector
//    abstract OfferFragment offerFragmentInjector();
//
//    @FragmentScope
//    @ContributesAndroidInjector
//    abstract MallFragment mallFragmentInjector();
//
//    @FragmentScope
//    @ContributesAndroidInjector
//    abstract ConnectionFragment connectionFragmentInjector();

    /**
     * provides 的对象写法,对参数做了限制
     *
     * @return
     */
    @Provides
    static TestModel providesTest(@ApplicationContext Context application) {
        return new TestModel(application);
    }

//    /**
//     * 通过接口来接收类的写法，必须在实现类的构造方法上加上@inject；
//     * 如果是通过本类来接收的话，不写需要此方法；
//     *
//     * @param testInnerImpl
//     * @return
//     */
//    @Binds
//    abstract TestContract.TestInner providesTest2(TestInnerImpl testInnerImpl);

//    @Provides
//    static MainService providesMainService(Retrofit retrofit) {
//        return retrofit.create(MainService.class);
//    }

    /**
     * As per the contract specified in {@link BaseActivityModule}; "This must be included in all
     * activity modules, which must provide a concrete implementation of {@link Activity}."
     * <p>
     * This provides the activity required to inject the
     * {@link BaseActivityModule#ACTIVITY_FRAGMENT_MANAGER} into the
     * {@link BaseVSActivity}.
     *
     * @param activity the activity
     * @return the activity
     */
    @Binds
    @ActivityScope
    abstract FragmentActivity activity(LoginActivity activity);

}
