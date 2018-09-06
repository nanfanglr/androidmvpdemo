package com.rui.mvp.network.basemodel;

import android.text.TextUtils;

/**
 * Created by rui on 2018/3/9.
 */
public class BaseResultModel extends BaseModel {

    protected static final String LOGOUT_CODE = "99999";
    protected static final String OUTDATE_CODE = "-1001";
    public static int PAGE_LIMIT = 20;
    protected boolean success;
    protected String msg;
    protected int total;
    protected String imagePath;
    protected String code;
    protected String error_code;
    protected int error;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSumPage() {
        return getSumPage(PAGE_LIMIT);
    }

    public int getSumPage(int limitPage) {
        return total % limitPage == 0 ? total / limitPage : total / limitPage + 1;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public boolean isLogout() {
        return TextUtils.equals(LOGOUT_CODE, code);
    }

    public boolean isOutDate() {
        return TextUtils.equals(OUTDATE_CODE, code);
    }

    public String getCode() {
        return code;
    }

    public String getError_code() {
        return error_code;
    }

}
