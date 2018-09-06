package com.mvp.rui.androidmvpdemo.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.mvp.rui.androidmvpdemo.R;
import com.rui.mvp.fragment.BaseFragment;


/**
 * Created by rui on 2018/3/12.
 */
public class MallFragment extends BaseFragment {

    public static MallFragment newInstance(Context context) {
        Bundle bundle = new Bundle();
        return (MallFragment) Fragment.instantiate(context, MallFragment.class.getName(), bundle);
    }

    
    @Override
    protected int getLayout() {
        return R.layout.fragment_mall;
    }


}
