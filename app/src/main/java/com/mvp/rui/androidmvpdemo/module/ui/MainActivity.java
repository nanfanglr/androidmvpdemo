package com.mvp.rui.androidmvpdemo.module.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mvp.rui.androidmvpdemo.R;
import com.mvp.rui.androidmvpdemo.common.activity.BaseActivity;
import com.mvp.rui.androidmvpdemo.example.Test;
import com.mvp.rui.androidmvpdemo.example.TestContract;
import com.mvp.rui.androidmvpdemo.module.di.contract.MainActView;
import com.mvp.rui.androidmvpdemo.module.presenter.MainActPresenter;
import com.mvp.rui.androidmvpdemo.module.viewstate.MainActViewState;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * 2018.2.10 上传GitHub测试
 */
public class MainActivity extends BaseActivity<
        MainActView
        , MainActPresenter
        , MainActViewState> implements MainActView {

    @BindView(R.id.fl_container)
    FrameLayout flContainer;
    @BindView(R.id.view_mainapp)
    View viewMainapp;
    @BindView(R.id.rb_home)
    RadioButton rbHome;
    @BindView(R.id.rb_index)
    RadioButton rbIndex;
    @BindView(R.id.rb_offer)
    RadioButton rbOffer;
    @BindView(R.id.rb_connections)
    RadioButton rbConnections;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;
    @BindView(R.id.tv_publish)
    TextView tvPublish;
    @BindView(R.id.iv_connetion_msgcount)
    TextView ivConnetionMsgcount;
    @BindView(R.id.rl_home)
    RelativeLayout rlHome;

    @Inject
    Test test;

    //这个是通过接口接收的，不能通过实现类上面的构造来注入
    //如果是通过本类来接收的，可以直接通过构造来注入
    @Inject
    TestContract.TestInner test2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
