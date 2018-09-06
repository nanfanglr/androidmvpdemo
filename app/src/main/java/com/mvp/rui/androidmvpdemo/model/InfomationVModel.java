package com.mvp.rui.androidmvpdemo.model;

import android.support.v4.app.Fragment;

import java.util.List;

/**
 * Created by rui on 2018/3/13.
 */
public class InfomationVModel {

    private List<Fragment> fragmentList;
    private List<InfoCategory> selectedDatas;
    private List<InfoCategory> unSelectedDatas;

    public InfomationVModel(List<Fragment> fragmentList
            , List<InfoCategory> selectedDatas, List<InfoCategory> unSelectedDatas) {
        this.fragmentList = fragmentList;
        this.selectedDatas = selectedDatas;
        this.unSelectedDatas = unSelectedDatas;
    }

    public List<Fragment> getFragmentList() {
        return fragmentList;
    }

    public void setFragmentList(List<Fragment> fragmentList) {
        this.fragmentList = fragmentList;
    }

    public List<InfoCategory> getSelectedDatas() {
        return selectedDatas;
    }

    public void setSelectedDatas(List<InfoCategory> selectedDatas) {
        this.selectedDatas = selectedDatas;
    }

    public List<InfoCategory> getUnSelectedDatas() {
        return unSelectedDatas;
    }

    public void setUnSelectedDatas(List<InfoCategory> unSelectedDatas) {
        this.unSelectedDatas = unSelectedDatas;
    }
}
