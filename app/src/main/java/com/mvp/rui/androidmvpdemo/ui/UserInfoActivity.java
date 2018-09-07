package com.mvp.rui.androidmvpdemo.ui;

import android.os.Bundle;
import android.widget.TextView;

import com.mvp.rui.androidmvpdemo.R;
import com.mvp.rui.androidmvpdemo.di.contract.UserInfoActView;
import com.mvp.rui.androidmvpdemo.di.presenter.UserInfoActPresenter;
import com.mvp.rui.androidmvpdemo.model.UserInfo;
import com.rui.mvp.activity.BaseActivity;

import butterknife.BindView;

/**
 * 个人信息页面
 */
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
    public void onUserInfo(UserInfo userInfo) {
        tvUserInfo.setText(userInfo.toString());
    }
}
