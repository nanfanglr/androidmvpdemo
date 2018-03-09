package com.mvp.rui.androidmvpdemo.base.dagger.modules;

import android.content.res.AssetManager;
import android.content.res.Resources;

import com.mvp.rui.androidmvpdemo.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public final class AndroidModule {

    private AndroidModule() {
        throw new AssertionError();
    }

    @Provides
    @Singleton
    public static Resources providesResources(App application) {
        return application.getResources();
    }

    @Provides
    @Singleton
    public static AssetManager providesAssetManager(Resources resources) {
        return resources.getAssets();
    }

}
