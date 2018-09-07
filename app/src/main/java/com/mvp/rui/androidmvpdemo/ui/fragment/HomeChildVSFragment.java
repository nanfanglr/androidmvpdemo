package com.mvp.rui.androidmvpdemo.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mvp.rui.androidmvpdemo.R;
import com.mvp.rui.androidmvpdemo.di.contract.HomeChildFgView;
import com.mvp.rui.androidmvpdemo.di.presenter.HomeChildFgPresenter;
import com.mvp.rui.androidmvpdemo.viewstate.HomeChildFgViewState;
import com.rui.mvp.fragment.BaseLazyVSFragment;

import butterknife.BindView;

/**
 * Created by rui on 2018/3/12.
 */
public class HomeChildVSFragment extends BaseLazyVSFragment<
        HomeChildFgView
        , HomeChildFgPresenter
        , HomeChildFgViewState
        > implements
        HomeChildFgView {

    protected int fragmentId;
    protected String fragmentTitle;
    //    @BindView(R.id.rv_info)
//    RecyclerView rvInfo;
    @BindView(R.id.tv_name)
    TextView tvName;

    public static HomeChildVSFragment newInstance(
            Context context
            , int fragmentId
            , String fragmentTitle) {
        Bundle bundle = new Bundle();
        bundle.putInt("id", fragmentId);
        bundle.putString("title", fragmentTitle);
        return (HomeChildVSFragment) Fragment.instantiate(context
                , HomeChildVSFragment.class.getName(), bundle);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            fragmentId = arguments.getInt("id", -1);
            fragmentTitle = arguments.getString("title");
        }
        tvName.setText(fragmentTitle);
        tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "homechildvsfragment", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void lazyFetchData() {

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_homechild;
    }

}
