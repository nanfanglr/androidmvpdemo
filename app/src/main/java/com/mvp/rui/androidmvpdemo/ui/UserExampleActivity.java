package com.mvp.rui.androidmvpdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mvp.rui.androidmvpdemo.R;
import com.mvp.rui.androidmvpdemo.di.contract.UserExampleActView;
import com.mvp.rui.androidmvpdemo.di.presenter.UserExamplePresenter;
import com.rui.mvp.activity.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;
import timber.log.Timber;

/**
 * userinfo显示的页面
 */
public class UserExampleActivity extends BaseActivity<
        UserExampleActView
        , UserExamplePresenter>
        implements
        UserExampleActView {

    @BindView(R.id.tv_user_info)
    TextView tvUserInfo;
    @BindView(R.id.tv_login)
    Button tvLogin;
    @BindView(R.id.btn_to_user)
    Button btnToUser;
    @BindView(R.id.tv_header)
    TextView tvHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPresenter().updateUserInfo();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //系统退出
//        System.exit(0);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_user_example;
    }

    @Override
    public void updateUserInfo(String result) {
        Timber.d("-------->updateUserInfo=" + result);
        tvUserInfo.setText(result);
    }

    @Override
    public void onLogin() {
        startActivity(new Intent(this, UserInfoActivity.class));
    }

    @OnClick({R.id.tv_login, R.id.btn_to_user})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_login:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.btn_to_user:
                //前往用户信息页面前，先要判断是否登录
                getPresenter().checkLogin();
                break;
        }
    }
}
