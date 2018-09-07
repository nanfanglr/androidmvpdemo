package com.mvp.rui.androidmvpdemo.ui;

import android.os.Bundle;
import android.widget.TextView;

import com.mvp.rui.androidmvpdemo.R;
import com.mvp.rui.androidmvpdemo.di.contract.UserInfoActView;
import com.mvp.rui.androidmvpdemo.presenter.UserInfoActPresenter;
import com.rui.mvp.activity.BaseActivity;

import butterknife.BindView;

public class UserInfoActivity extends BaseActivity<
        UserInfoActView
        , UserInfoActPresenter>
        implements
     UserInfoActView {

    @BindView(R.id.tv_header)
    TextView tvHeader;
    @BindView(R.id.tv_user_info)
    TextView tvUserInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPresenter().getUserInfo();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_user_info;
    }

    @Override
    public void onUserInfo(com.rui.android_mvp_with_componentization.model.UserInfo userInfo) {
        tvUserInfo.setText(userInfo.toString());
    }
}
