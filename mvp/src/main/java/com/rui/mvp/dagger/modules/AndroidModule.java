package com.rui.mvp.dagger.modules;

import android.content.res.AssetManager;
import android.content.res.Resources;

import com.rui.mvp.BaseApplication.BaseApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rui on 2018/3/9.
 */
@Module
public final class AndroidModule {

    private AndroidModule() {
        throw new AssertionError();
    }

    @Provides
    @Singleton
    public static Resources providesResources(BaseApplication application) {
        return application.getResources();
    }

    @Provides
    @Singleton
    public static AssetManager providesAssetManager(Resources resources) {
        return resources.getAssets();
    }

}
