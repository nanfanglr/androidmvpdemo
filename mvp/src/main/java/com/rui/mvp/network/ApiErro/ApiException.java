package com.rui.mvp.network.ApiErro;

/**
 * 自定义的api错误类，以方便统一处理
 * Created by rui on 2018/7/31.
 */
public class ApiException extends RuntimeException {
    private int errorCode;

    public ApiException(int code, String msg) {
        super(msg);
        this.errorCode = code;
    }

    public int getErrorCode() {
        return errorCode;
    }

}