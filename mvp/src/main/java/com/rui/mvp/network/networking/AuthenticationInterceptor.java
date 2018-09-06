package com.rui.mvp.network.networking;

import com.rui.mvp.network.networkconfig.PropertiesManager;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import timber.log.Timber;

/**
 * 这类是用来添加请求头的
 */
public class AuthenticationInterceptor implements Interceptor {

    private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
    private static final String AUTHORIZATION_HEADER_VALUE_WITH_PLACEHOLDER = "Bearer %s";

    private static final String AUTHORIZATION_FAKE_HEADER_KEY = "Authentication";
    private static final String AUTHORIZATION_FAKE_HEADER_VALUE = ": True";

    /**
     * Fake authorization header. Only added so that this interceptor replaces it with the correct auth key.
     */
    public static final String DO_AUTHENTICATION = AUTHORIZATION_FAKE_HEADER_KEY + AUTHORIZATION_FAKE_HEADER_VALUE;

    private final PropertiesManager propertiesManager;

    @Inject
    public AuthenticationInterceptor(PropertiesManager propertiesManager) {

        this.propertiesManager = propertiesManager;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();

        if (request.header(AUTHORIZATION_FAKE_HEADER_KEY) != null) {
            Timber.d("Secure network request encountered. Adding authentication headers.");
            request = request.newBuilder()
                    .addHeader(AUTHORIZATION_HEADER_KEY,
                            String.format(AUTHORIZATION_HEADER_VALUE_WITH_PLACEHOLDER, propertiesManager.getDribleClientAccessToken()))
                    .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                    .addHeader("Accept-Encoding", "gzip, deflate")
                    .addHeader("Connection", "keep-alive")
                    .addHeader("Accept", "*/*")
//                    .addHeader("syt_app_t", "android")
//                    .addHeader("syt_app_v", AppUtils.getVersionName(application))
//                    .addHeader("syt_m_id", GlobalValue.MB_ID)
//                    .addHeader("syt_app_c", android.os.Build.SERIAL==null?"":android.os.Build.SERIAL)
                    .build();
        }
        return chain.proceed(request);
    }

}
