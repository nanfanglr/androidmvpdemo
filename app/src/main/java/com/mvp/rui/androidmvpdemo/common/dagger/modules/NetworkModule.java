package com.mvp.rui.androidmvpdemo.common.dagger.modules;


import com.mvp.rui.androidmvpdemo.BuildConfig;
import com.mvp.rui.androidmvpdemo.common.network.networkconfig.PropertiesManager;
import com.mvp.rui.androidmvpdemo.common.network.networking.AuthenticationInterceptor;
import com.mvp.rui.androidmvpdemo.common.network.networking.BaseUrlInterceptor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rui on 2018/3/9.
 */
@Module
public final class NetworkModule {

    private NetworkModule() {

        throw new AssertionError();
    }

    @Provides
    @Singleton
    static HttpLoggingInterceptor providesHttpLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG) {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        return interceptor;
    }

    @Provides
    @Singleton
    static OkHttpClient provideOkHttpClient(PropertiesManager propertiesManager, HttpLoggingInterceptor httpLoggingInterceptor,
                                            BaseUrlInterceptor baseUrlInterceptor) {

        final OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();

        // Adds authentication headers when required in network calls
        okHttpBuilder.addInterceptor(new AuthenticationInterceptor(propertiesManager));

        // Helps with changing base url of network calls in espresso tests to the MockWebServer base url.
        okHttpBuilder.addInterceptor(baseUrlInterceptor);

        // Logs network calls for debug builds
        okHttpBuilder.addInterceptor(httpLoggingInterceptor);

        return okHttpBuilder.build();
    }

    @Provides
    @Singleton
    static Retrofit providesRetrofit(OkHttpClient okHttpClient, PropertiesManager propertiesManager) {

        return new Retrofit.Builder()
                .baseUrl(propertiesManager.getBaseUrl())
                .validateEagerly(BuildConfig.DEBUG)// Fail early: check Retrofit configuration at creation time in Debug build.
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
//    @ForTestingPurposes
    static BaseUrlInterceptor providesBaseUrlInterceptor(PropertiesManager propertiesManager) {
        return new BaseUrlInterceptor(propertiesManager.getBaseUrl());
    }

}
