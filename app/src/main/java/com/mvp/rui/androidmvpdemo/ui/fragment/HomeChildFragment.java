package com.mvp.rui.androidmvpdemo.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.mvp.rui.androidmvpdemo.R;
import com.mvp.rui.androidmvpdemo.di.contract.HomeChildFgView;
import com.mvp.rui.androidmvpdemo.di.presenter.HomeChildFgPresenter;
import com.rui.mvp.fragment.BaseLazyFragment;

import butterknife.BindView;

/**
 * Created by rui on 2018/3/12.
 */
public class HomeChildFragment extends BaseLazyFragment<
        HomeChildFgView
        , HomeChildFgPresenter
        > implements
        HomeChildFgView {

    protected int fragmentId;
    protected String fragmentTitle;
    //    @BindView(R.id.rv_info)
//    RecyclerView rvInfo;
    @BindView(R.id.tv_name)
    TextView tvName;

    public static HomeChildFragment newInstance(
            Context context
            , int fragmentId
            , String fragmentTitle) {
        Bundle bundle = new Bundle();
        bundle.putInt("id", fragmentId);
        bundle.putString("title", fragmentTitle);
        return (HomeChildFragment) Fragment.instantiate(context
                , HomeChildFragment.class.getName(), bundle);
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
    }

    @Override
    protected void lazyFetchData() {

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_homechild;
    }

}
