package com.mvp.rui.androidmvpdemo.dagger.modules;


import com.mvp.rui.androidmvpdemo.App;
import com.mvp.rui.androidmvpdemo.BuildConfig;
import com.mvp.rui.androidmvpdemo.networkconfig.PropertiesManager;
import com.mvp.rui.androidmvpdemo.networking.AuthenticationInterceptor;
import com.mvp.rui.androidmvpdemo.networking.BaseUrlInterceptor;

import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public final class NetworkModule {

    private NetworkModule() {

        throw new AssertionError();
    }

    @Provides
    @Singleton
    public static HttpLoggingInterceptor providesHttpLoggingInterceptor() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG) {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        return interceptor;
    }

//    @Provides
//    @Singleton
//    public static OkReplayInterceptor provideOkReplayInterceptor() {
//        return new OkReplayInterceptor();
//    }

    @Provides
    @Singleton
    public static OkHttpClient provideOkHttpClient(PropertiesManager propertiesManager, HttpLoggingInterceptor httpLoggingInterceptor,
                                                   List<Interceptor> networkInterceptors, BaseUrlInterceptor baseUrlInterceptor,
                                                   App application) {

        final OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();

        // Adds authentication headers when required in network calls
        okHttpBuilder.addInterceptor(new AuthenticationInterceptor(propertiesManager));

        // Helps with changing base url of network calls in espresso tests to the MockWebServer base url.
        okHttpBuilder.addInterceptor(baseUrlInterceptor);

        // For https://github.com/airbnb/okreplay library, recording and replaying server responses.
//        okHttpBuilder.addInterceptor(okReplayInterceptor);

        // For release builds nothing is added, the list is empty. For debug builds Stetho interceptor is added.
        for (Interceptor networkInterceptor : networkInterceptors) {
            okHttpBuilder.addNetworkInterceptor(networkInterceptor);
        }

//        // Displaying all network calls within the app through a notification. Debug builds only. See https://github.com/jgilfelt/chuck
//        if (!TestUtil.areRobolectricTestsRunning()) { // Robolectric doesn't like this library
//            okHttpBuilder.addInterceptor(new ChuckInterceptor(application.getApplicationContext()));
//        }

        // Logs network calls for debug builds
        okHttpBuilder.addInterceptor(httpLoggingInterceptor);

        return okHttpBuilder.build();
    }

    @Provides
    @Singleton
    public static Retrofit providesRetrofit(OkHttpClient okHttpClient, PropertiesManager propertiesManager) {

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
    public static BaseUrlInterceptor providesBaseUrlInterceptor(PropertiesManager propertiesManager) {
        return new BaseUrlInterceptor(propertiesManager.getBaseUrl());
    }

}
