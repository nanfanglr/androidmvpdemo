package com.mvp.rui.androidmvpdemo.common.dagger.modules;

import android.content.Context;
import android.content.res.AssetManager;

import com.mvp.rui.androidmvpdemo.App;
import com.mvp.rui.androidmvpdemo.common.dagger.scopes.ApplicationContext;
import com.mvp.rui.androidmvpdemo.common.network.networkconfig.PropertiesManager;
import com.mvp.rui.androidmvpdemo.tools.images.ImageLoader;
import com.mvp.rui.androidmvpdemo.tools.stetho.StethoTool;
import com.mvp.rui.androidmvpdemo.tools.stetho.StethoToolImpl;

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
    static PropertiesManager providesPropertyManager(AssetManager assetManager) {
        return new PropertiesManager(assetManager);
    }


    @Provides
    @Singleton
    static StethoTool providesStetho(App application) {
        return new StethoToolImpl(application.getApplicationContext());
    }


    @Provides
    @Singleton
    static ImageLoader providesImageLoader(App application) {
        return new ImageLoader(application.getApplicationContext());
    }

    @Provides
    @ApplicationContext
    static Context provideApplicationContext(App app) {
        return app.getApplicationContext();
    }

}
