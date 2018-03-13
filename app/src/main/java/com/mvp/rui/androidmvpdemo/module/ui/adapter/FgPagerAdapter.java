package com.mvp.rui.androidmvpdemo.module.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 0200030 on 2018/3/13.
 */
public class FgPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> list;
    //    private List<InfoCategory> selectedDatas;
    private List<String> selectedDatas;

    public FgPagerAdapter(FragmentManager fm
            , List<Fragment> list
            , List<String> selectedData) {
        super(fm);
        this.list = list;
        this.selectedDatas = selectedData;
    }

    @Override
    public Fragment getItem(int position) {
        return (list == null || list.size() == 0) ? null
                : list.get(position);
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
//        return selectedDatas.get(position).getTitle();
        return selectedDatas.get(position);
    }

    @Override
    public int getItemPosition(Object object) {
        super.getItemPosition(object);
        return POSITION_NONE;
    }

}



