package com.rui.android_mvp_with_componentization.di.module;

import com.rui.android_mvp_with_componentization.datasource.UserInfoRepository;
import com.rui.android_mvp_with_componentization.netservice.UserExampleService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * 专门提供全局唯一对象的module
 * Created by rui on 2018/8/23
 */
@Module
public final class SingletonModule {

    private SingletonModule() {
        throw new AssertionError();
    }

    @Provides
    @Singleton
    static UserExampleService providesMainService(Retrofit retrofit) {
        return retrofit.create(UserExampleService.class);
    }

    @Provides
    @Singleton
    static UserInfoRepository providesUserInfoRepository(UserExampleService userExampleService) {
        return new UserInfoRepository(userExampleService);
    }


}
