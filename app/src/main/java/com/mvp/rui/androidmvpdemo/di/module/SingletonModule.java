package com.mvp.rui.androidmvpdemo.di.module;


import com.mvp.rui.androidmvpdemo.datasource.UserInfoRepository;
import com.mvp.rui.androidmvpdemo.netservice.UserExampleService;

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
