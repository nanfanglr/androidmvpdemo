package com.rui.mvp.dagger.modules;


import com.rui.mvp.network.networkconfig.PropertiesManager;
import com.rui.mvp.network.networking.AuthenticationInterceptor;
import com.rui.mvp.network.networking.BaseUrlInterceptor;

import java.util.concurrent.TimeUnit;

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
    /**
     * 网络请求超时时间
     */
    private static final long TIMEOUT_CONNECT = 10 * 1000;

    private NetworkModule() {
        throw new AssertionError();
    }

    @Provides
    @Singleton
    static HttpLoggingInterceptor providesHttpLoggingInterceptor(PropertiesManager propertiesManager) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        if (propertiesManager.isDebug()) {
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

        okHttpBuilder.connectTimeout(TIMEOUT_CONNECT, TimeUnit.MILLISECONDS);
        okHttpBuilder.writeTimeout(TIMEOUT_CONNECT, TimeUnit.MILLISECONDS);
        okHttpBuilder.readTimeout(TIMEOUT_CONNECT, TimeUnit.MILLISECONDS);

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
                .validateEagerly(propertiesManager.isDebug())// Fail early: check Retrofit configuration at creation time in Debug build.
                .addConverterFactory(GsonConverterFactory.create())
//                .addConverterFactory(MyGsonConverterFactory.create())
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
