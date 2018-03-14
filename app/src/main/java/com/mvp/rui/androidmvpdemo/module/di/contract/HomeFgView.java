package com.mvp.rui.androidmvpdemo.module.di.contract;

import com.mvp.rui.androidmvpdemo.common.basemvp.LoadMvpView;
import com.mvp.rui.androidmvpdemo.module.model.InfomationVModel;

/**
 * Created by rui on 2018/3/9.
 */
public interface HomeFgView extends LoadMvpView {

    void onCategoryLoad(InfomationVModel infomationVModel);

}
