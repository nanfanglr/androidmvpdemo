package com.rui.mvp.network.basemodel;

/**
 * Created by rui on 2018/3/9.
 */
public class BaseResultModel extends BaseModel {
    /**
     * 请求成功的返回码
     */
    public static final int SUCCESS_RESULT_CODE = 1;
    public static int PAGE_LIMIT = 20;
    /**
     * 返回的信息
     */
    protected String msg;
    /**
     * 列表总记录数，主要是用来处理分页
     */
    protected int total;
    /**
     * 返回码，正常返回为 1
     */
    protected int code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

//    public boolean isSuccess() {
//        return code == SUCCESS_RESULT_CODE;
//    }

    public int getSumPage() {
        return getSumPage(PAGE_LIMIT);
    }

    public int getSumPage(int limitPage) {
        return total % limitPage == 0 ? total / limitPage : total / limitPage + 1;
    }

    /*******************************************************************************/

    private boolean success;

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }
}
