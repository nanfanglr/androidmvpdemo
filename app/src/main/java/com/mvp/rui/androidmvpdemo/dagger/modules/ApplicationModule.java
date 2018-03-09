package com.mvp.rui.androidmvpdemo.dagger.modules;

import android.content.Context;
import android.content.res.AssetManager;

import com.mvp.rui.androidmvpdemo.App;
import com.mvp.rui.androidmvpdemo.dagger.scopes.ApplicationContext;
import com.mvp.rui.androidmvpdemo.networkconfig.PropertiesManager;
import com.mvp.rui.androidmvpdemo.tools.images.ImageLoader;
import com.mvp.rui.androidmvpdemo.tools.stetho.StethoTool;
import com.mvp.rui.androidmvpdemo.tools.stetho.StethoToolImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public final class ApplicationModule {

    private ApplicationModule() {
        throw new AssertionError();
    }

    @Provides
    @Singleton
    public static PropertiesManager providesPropertyManager(AssetManager assetManager) {
        return new PropertiesManager(assetManager);
    }


    @Provides
    @Singleton
    public static StethoTool providesStetho(App application) {
        return new StethoToolImpl(application.getApplicationContext());
    }


    @Provides
    @Singleton
    public static ImageLoader providesImageLoader(App application) {
        return new ImageLoader(application.getApplicationContext());
    }

    @Provides
    @ApplicationContext
    public static Context provideApplicationContext(App app) {
        return app.getApplicationContext();
    }

}
