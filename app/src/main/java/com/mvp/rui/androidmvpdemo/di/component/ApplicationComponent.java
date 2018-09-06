package com.mvp.rui.androidmvpdemo.di.component;


import com.mvp.rui.androidmvpdemo.App;
import com.rui.android_mvp_with_componentization.di.module.ActivityBindingModule;
import com.rui.android_mvp_with_componentization.di.module.SingletonModule;
import com.rui.mvp.BaseApplication.BaseApplication;
import com.rui.mvp.dagger.modules.AndroidModule;
import com.rui.mvp.dagger.modules.ApplicationModule;
import com.rui.mvp.dagger.modules.NetworkModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class,
        ApplicationModule.class,
        NetworkModule.class,
        AndroidModule.class,
        SingletonModule.class,
        ActivityBindingModule.class,
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
        Builder application(BaseApplication app);

        //这里可以修改提供application的形式 App,BaseApplication,Application
        //这样就可以方便的对其进行转换,以便在BaseApplication类库操作
        ApplicationComponent build();
    }


}






