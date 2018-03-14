package com.mvp.rui.androidmvpdemo.common.interfaces;

/**
 * Created by linet on 2017/8/21.
 */

public interface Mapper<FROM, TO> {

    TO map(FROM from);
}
