package com.rui.mvp.network.ApiErro;

/**
 * 定义APP相关网络错误常量
 * Created by rui on 2018/7/31.
 */
public interface ApiErrorCode {
    /**
     * 客户端错误
     */
    int ERROR_CLIENT_AUTHORIZED = 1;
    /**
     * 用户授权失败
     */
    int ERROR_USER_AUTHORIZED = 2;
    /**
     * 请求参数错误
     */
    int ERROR_REQUEST_PARAM = 3;
    /**
     * 参数检验不通过
     */
    int ERROR_PARAM_CHECK = 4;
    /**
     * 自定义错误
     */
    int ERROR_OTHER = 10;

}
