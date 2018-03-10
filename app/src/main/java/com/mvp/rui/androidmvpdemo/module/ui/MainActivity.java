package com.mvp.rui.androidmvpdemo.module.ui;

import android.os.Bundle;
import android.widget.TextView;

import com.mvp.rui.androidmvpdemo.R;
import com.mvp.rui.androidmvpdemo.common.activity.BaseActivity;
import com.mvp.rui.androidmvpdemo.example.Test;
import com.mvp.rui.androidmvpdemo.example.TestContract;
import com.mvp.rui.androidmvpdemo.module.di.contract.MainView;
import com.mvp.rui.androidmvpdemo.module.presenter.MainPresenter;
import com.mvp.rui.androidmvpdemo.module.viewstate.MainActivityViewState;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * 2018.2.10 上传GitHub测试
 */
public class MainActivity extends BaseActivity<
        MainView
        , MainPresenter
        , MainActivityViewState> implements MainView {

    @BindView(R.id.tv)
    TextView tv;

    @Inject
    Test test;

    //这个是通过接口接收的，不能通过实现类上面的构造来注入
    //如果是通过本类来接收的，可以直接通过构造来注入
    @Inject
    TestContract.TestInner test2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tv.setText("" + test2.toString());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void showLoadingBar() {

    }

    @Override
    public void dismissLoadingBar() {

    }

    @Override
    public void showLoadingFailureError() {

    }
}
