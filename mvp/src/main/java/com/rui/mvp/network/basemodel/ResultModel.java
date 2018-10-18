package com.rui.mvp.network.basemodel;

/**
 * Created by rui on 2018/3/9.
 */
public class ResultModel<T> extends BaseResultModel {

//    protected T data;
//
//    public T getData() {
//        return data;
//    }
//
//    public void setData(T data) {
//        this.data = data;
//    }

    /*******************************************************************************/

    protected T obj;

    public T getData() {
        return obj;
    }

    public void setData(T data) {
        this.obj = data;
    }


}
