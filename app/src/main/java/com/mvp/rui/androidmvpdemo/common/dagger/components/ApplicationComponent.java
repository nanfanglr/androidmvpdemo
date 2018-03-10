package com.mvp.rui.androidmvpdemo.common.dagger.components;


import com.mvp.rui.androidmvpdemo.App;
import com.mvp.rui.androidmvpdemo.common.dagger.modules.ActivityBindingModule;
import com.mvp.rui.androidmvpdemo.common.dagger.modules.AndroidModule;
import com.mvp.rui.androidmvpdemo.common.dagger.modules.ApplicationModule;
import com.mvp.rui.androidmvpdemo.common.dagger.modules.NetworkModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;


@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        ActivityBindingModule.class,
        ApplicationModule.class,
        NetworkModule.class,
        AndroidModule.class,
//        BuildTypeAwareModule.class
})
public interface ApplicationComponent {

    void inject(App application);

    //    @ForTestingPurposes
//    MainService mainServiceService();

    //    @ForTestingPurposes
//    BaseUrlInterceptor baseUrlInterceptor();

//    @ForTestingPurposes
//    OkReplayInterceptor okReplayInterceptor();

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(App app);

        ApplicationComponent build();
    }

}
