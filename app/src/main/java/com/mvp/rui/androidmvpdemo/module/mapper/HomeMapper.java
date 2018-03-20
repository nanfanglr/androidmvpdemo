package com.mvp.rui.androidmvpdemo.module.mapper;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.text.TextUtils;

import com.mvp.rui.androidmvpdemo.common.constants.APPValue;
import com.mvp.rui.androidmvpdemo.common.interfaces.Mapper;
import com.mvp.rui.androidmvpdemo.module.model.InfoCategory;
import com.mvp.rui.androidmvpdemo.module.model.InfomationVModel;
import com.mvp.rui.androidmvpdemo.module.ui.fragment.HomeChildFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rui on 2018/3/14.
 */
public class HomeMapper implements Mapper<List<InfoCategory>, InfomationVModel> {

    private Context context;

    public HomeMapper(Context context) {
        this.context = context;
    }

    @Override
    public InfomationVModel map(List<InfoCategory> categorys) {

        List<Fragment> mList = new ArrayList<>();
        List<InfoCategory> selectedDatas = new ArrayList<>();
        List<InfoCategory> unSelectedDatas = new ArrayList<>();

        for (InfoCategory model : categorys) {
            if (TextUtils.equals(model.getTypeGroup(), APPValue.CATEGORY_DEFUALT)) {
                selectedDatas.add(model);
                mList.add(HomeChildFragment.newInstance(context, 0, model.getTitle()));
            } else if (TextUtils.equals(model.getTypeGroup(), APPValue.CATEGORY_DEFUALT)) {
                unSelectedDatas.add(model);
            }
        }

        return new InfomationVModel(mList, selectedDatas, unSelectedDatas);
    }

}
