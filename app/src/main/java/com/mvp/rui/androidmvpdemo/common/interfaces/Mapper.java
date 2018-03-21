package com.mvp.rui.androidmvpdemo.common.interfaces;

/**
 * Created by rui on 2018/3/9.
 */
public interface Mapper<FROM, TO> {

    TO map(FROM from);
}
