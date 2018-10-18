package com.rui.mvp.network.ApiErro;

import android.content.Context;
import android.widget.Toast;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import retrofit2.HttpException;

/**
 * api错误处理逻辑类，不同的数据源需要共用这个类，如果只有一种数据源可以直接在consumer后面处理；
 * Created by rui on 2018/7/31.
 */
public class ApiErrorHelper {

    public static void handleCommonError(Context context, Throwable throwable) {
        if (throwable instanceof ConnectException) {
            Toast.makeText(context, "无网络连接", Toast.LENGTH_SHORT).show();
        } else if (throwable instanceof SocketTimeoutException) {
            Toast.makeText(context, "服务连接超时", Toast.LENGTH_SHORT).show();
        } else if (throwable instanceof HttpException) {
            int code = ((HttpException) throwable).code();
            Toast.makeText(context, String.format("服务不可用，请稍后重试(%d)", code), Toast.LENGTH_SHORT).show();
        } else if (throwable instanceof ApiException) {
            //ApiException处理
            ApiException exception = (ApiException) throwable;
            int code = exception.getErrorCode();
            switch (code) {
                case ApiErrorCode.ERROR_CLIENT_AUTHORIZED:
                    //handle
                    break;
                case ApiErrorCode.ERROR_USER_AUTHORIZED:
                    //handle
                    break;
                case ApiErrorCode.ERROR_REQUEST_PARAM:
                    //handle
                    break;
                case ApiErrorCode.ERROR_PARAM_CHECK:
                    //handle
                    break;
                case ApiErrorCode.ERROR_OTHER:
                    //handle
                    break;
                default:
                    Toast.makeText(context, "Api未知错误", Toast.LENGTH_SHORT).show();
                    break;
            }
        } else {
            Toast.makeText(context, "未知错误", Toast.LENGTH_SHORT).show();
        }
    }

}
