package com.mvp.rui.androidmvpdemo.di.contract;


import com.mvp.rui.androidmvpdemo.model.InfomationVModel;
import com.rui.mvp.basemvp.LoadMvpView;

/**
 * Created by rui on 2018/3/9.
 */
public interface HomeFgView extends LoadMvpView {

    void onCategoryLoad(InfomationVModel infomationVModel);

}
