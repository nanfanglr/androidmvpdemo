package com.rui.mvp.network.basemodel;

/**
 * Created by rui on 2018/3/9.
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

//
//    protected T obj;
//    protected List<T> data;
//
//    public T getObj() {
//        return obj;
//    }
//
//    public void setObj(T obj) {
//        this.obj = obj;
//    }
//
//    public List getData() {
//        return data;
//    }
//
//    public void setData(List data) {
//        this.data = data;
//    }

}
