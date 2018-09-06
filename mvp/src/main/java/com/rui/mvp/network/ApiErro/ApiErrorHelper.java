package com.rui.mvp.network.ApiErro;

import android.content.Context;
import android.widget.Toast;

import java.io.IOException;

import retrofit2.HttpException;

/**
 * api错误处理逻辑类
 * Created by rui on 2018/7/31.
 */
public class ApiErrorHelper {

    public static void handleCommonError(Context context, Throwable e) {
        if (e instanceof HttpException) {
            Toast.makeText(context, "服务暂不可用", Toast.LENGTH_SHORT).show();
        } else if (e instanceof IOException) {
            Toast.makeText(context, "连接失败", Toast.LENGTH_SHORT).show();
        } else if (e instanceof ApiException) {
            //ApiException处理
            ApiException exception = (ApiException) e;
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
                case ApiErrorCode.ERROR_NO_INTERNET:
                    //handle
                    Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
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
