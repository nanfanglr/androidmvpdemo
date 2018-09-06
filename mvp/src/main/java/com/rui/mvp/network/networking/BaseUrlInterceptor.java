package com.rui.mvp.network.networking;

import java.io.IOException;

import javax.annotation.Nullable;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 用于修改APP域名的，主要用来测试
 * An interceptor that allows runtime changes to the URL hostname.
 * Usually used in combination with MockWebServer.
 */
public final class BaseUrlInterceptor implements Interceptor {

    private final String realBaseUrl;
    @Nullable
    private volatile String host;

    public BaseUrlInterceptor(String realBaseUrl) {
        this.realBaseUrl = realBaseUrl;
    }

    public void setBaseUrl(String host) {
        this.host = host;
    }

    public void resetBaseUrl() {
        this.host = realBaseUrl;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (host != null && !realBaseUrl.equals(host)) {
            @Nullable HttpUrl newUrl = HttpUrl.parse(host);
            request = request.newBuilder()
                    .url(newUrl)
                    .build();
        }
        return chain.proceed(request);
    }

}
