package com.mvp.rui.androidmvpdemo.common.network.basemodel;

/**
 * Created by linet on 16/9/22.
 */

public class ResultModel<T> extends BaseResultModel {

    protected T data;
//    protected List<T> data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

//    public List getData() {
//        return data;
//    }

//    public void setData(List data) {
//        this.data = data;
//    }

}
