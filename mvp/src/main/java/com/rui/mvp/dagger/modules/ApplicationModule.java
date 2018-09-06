package com.rui.mvp.dagger.modules;

import android.content.Context;
import android.content.res.AssetManager;

import com.rui.mvp.BaseApplication.BaseApplication;
import com.rui.mvp.dagger.scopes.ApplicationContext;
import com.rui.mvp.network.networkconfig.PropertiesManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rui on 2018/3/9.
 */
@Module
public final class ApplicationModule {

    private ApplicationModule() {
        throw new AssertionError();
    }

    @Provides
    @Singleton
    static PropertiesManager providesPropertyManager(AssetManager assetManager, BaseApplication app) {
        return new PropertiesManager(assetManager, app.isDebug());
    }


//    @Provides
//    @Singleton
//    static StethoTool providesStetho(App application) {
//        return new StethoToolImpl(application.getApplicationContext());
//    }


//    @Provides
//    @Singleton
//    static ImageLoader providesImageLoader(App application) {
//        return new ImageLoader(application.getApplicationContext());
//    }

    @Provides
    @ApplicationContext
    static Context provideApplicationContext(BaseApplication app) {
        return app.getApplicationContext();
    }

}
