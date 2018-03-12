package com.mvp.rui.androidmvpdemo.module.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.mvp.rui.androidmvpdemo.R;
import com.mvp.rui.androidmvpdemo.common.fragment.BaseFragment;

/**
 * Created by rui on 2018/3/12.
 */
public class ConnectionFragment extends BaseFragment {

    public static ConnectionFragment newInstance(Context context) {
        Bundle bundle = new Bundle();
        return (ConnectionFragment) Fragment.instantiate(context, ConnectionFragment.class.getName(), bundle);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_connection;
    }

}
