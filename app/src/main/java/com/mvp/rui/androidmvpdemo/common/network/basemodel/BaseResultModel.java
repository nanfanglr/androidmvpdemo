package com.mvp.rui.androidmvpdemo.common.network.basemodel;

import android.text.TextUtils;

/**
 * Created by linet on 16/9/30.
 */

public class BaseResultModel extends BaseModel {

    public static int PAGE_LIMIT = 20;
    /**
     * 这个是个后台准备的 app不需要关心
     */
//    protected static final int API_CALL_FALLBACK_CODE = 0;
    /**
     * 所有未知异常
     */
    public static final int UNKOWN_RESULT_CODE = -1;
    /**
     * 请求成功的返回码
     */
    public static final int SUCCESS_RESULT_CODE = 1;
    /**
     * api 参数验证错误码
     */
//    protected static final int API_PARAM_ERROR_CODE = 2;
    /**
     * 不合法的请求
     */
//    protected static final int UNVALID_REQUEST_CODE = 3;
    /**
     * 未登录
     */
    public static final int NOT_AUTH = 9999;
    /**
     * 无权限
     */
    public static final int NOT_PRIV = 9998;
    /**
     * 登录环境有问题
     */
    public static final int LOGIN_ENIRONMENTAL = 9997;
    /**
     * TOKEN不合法
     */
    public static final int TOKEN_ERROR = 9996;

    /**
     * TOKEN验证不通过
     */
    public static final int TOKEN_ERROR2 = 10001;

    /**
     * 未绑定微信
     */
    public static final int MEMBER_NO_WX = 10016;
    /**
     * 未绑定QQ
     */
    public static final int MEMBER_NO_QQ = 10017;

    //    protected boolean success;
    protected String msg;
    /**
     * 总记录数
     */
    protected int total;
    protected String imagePath;
    /**
     * 返回码，正常返回为 1
     */
    protected int code;
//    protected String error_code;
    /**
     * 返回的错误信息 ,
     */
    protected String errMsg;

    public String getErrMsg() {
        if (TextUtils.isEmpty(errMsg)) {
            return "";
        }
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return code == SUCCESS_RESULT_CODE;
    }

    public int getTotal() {
        return total;
    }

    public int getSumPage() {
        return getSumPage(PAGE_LIMIT);
    }

    public int getSumPage(int limitPage) {
        return total % limitPage == 0 ? total / limitPage : total / limitPage + 1;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }


    public boolean isLogout() {
        return NOT_AUTH == code;
    }

    public boolean isOutDate() {
        return TOKEN_ERROR == code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
