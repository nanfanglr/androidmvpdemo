package com.mvp.rui.androidmvpdemo.di.module;

import android.support.v4.app.FragmentActivity;

import com.mvp.rui.androidmvpdemo.ui.UserExampleActivity;
import com.rui.mvp.activity.BaseVSActivity;
import com.rui.mvp.dagger.modules.BaseActivityModule;
import com.rui.mvp.dagger.scopes.ActivityScope;

import dagger.Binds;
import dagger.Module;

/**
 * 负责提供MainActivity所需要的依赖
 */
@Module(includes = BaseActivityModule.class)
public abstract class UserExampleActModule {

//    @Provides
//    static MainService providesMainService(Retrofit retrofit) {
//        return retrofit.create(MainService.class);
//    }
//
//    @Provides
//    static UserInfoRepository providesUserInfoRepository(MainService mainService) {
//        return new UserInfoRepository(mainService);
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
    abstract FragmentActivity activity(UserExampleActivity activity);

}
