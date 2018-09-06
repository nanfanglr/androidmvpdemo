package com.rui.mvp.interfaces;

/**
 * 数据转换的定义接口
 * Created by rui on 2018/3/9.
 */
public interface Mapper<FROM, TO> {

    TO map(FROM from);
}
