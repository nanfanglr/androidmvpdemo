package com.mvp.rui.androidmvpdemo.module.di.module;

import android.content.Context;

import com.mvp.rui.androidmvpdemo.common.dagger.scopes.ActivityContext;
import com.mvp.rui.androidmvpdemo.example.Test;
import com.mvp.rui.androidmvpdemo.example.TestContract;
import com.mvp.rui.androidmvpdemo.example.TestInnerImpl;
import com.mvp.rui.androidmvpdemo.module.ui.MainActivity;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * 负责提供MainActivity所需要的依赖
 */
@Module
public abstract class MainActivityModule {

    @Binds
    @ActivityContext
    abstract Context providesActivityContext(MainActivity mainActivity);

    /**
     * 通过接口来接收类的写法，必须在实现类的构造方法上加上@inject；
     * 如果是通过本类来接收的话，不写需要此方法；
     *
     * @param testInnerImpl
     * @return
     */
    @Binds
    abstract TestContract.TestInner providesTest2(TestInnerImpl testInnerImpl);

    /**
     * provides 的对象写法
     *
     * @return
     */
    @Provides
    static Test providesTest() {
        return new Test();
    }

}
