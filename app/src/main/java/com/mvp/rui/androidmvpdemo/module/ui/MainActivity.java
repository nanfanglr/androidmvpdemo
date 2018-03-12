package com.mvp.rui.androidmvpdemo.module.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mvp.rui.androidmvpdemo.R;
import com.mvp.rui.androidmvpdemo.common.activity.BaseActivity;
import com.mvp.rui.androidmvpdemo.common.constants.APPValue;
import com.mvp.rui.androidmvpdemo.example.Test;
import com.mvp.rui.androidmvpdemo.example.TestContract;
import com.mvp.rui.androidmvpdemo.module.di.contract.MainActView;
import com.mvp.rui.androidmvpdemo.module.presenter.MainActPresenter;
import com.mvp.rui.androidmvpdemo.module.ui.fragment.ConnectionFragment;
import com.mvp.rui.androidmvpdemo.module.ui.fragment.HomeFragment;
import com.mvp.rui.androidmvpdemo.module.ui.fragment.MallFragment;
import com.mvp.rui.androidmvpdemo.module.ui.fragment.OfferFragment;
import com.mvp.rui.androidmvpdemo.module.viewstate.MainActViewState;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * 2018.2.10 上传GitHub测试
 */
public class MainActivity extends BaseActivity<
        MainActView
        , MainActPresenter
        , MainActViewState>
        implements
        MainActView
        , RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.fl_container)
    FrameLayout flContainer;
    @BindView(R.id.view_mainapp)
    View viewMainapp;
    @BindView(R.id.rb_home)
    RadioButton rbHome;
    @BindView(R.id.rb_mall)
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
    HomeFragment homeFragment;
    @Inject
    MallFragment mallFragment;
    @Inject
    OfferFragment offerFragment;
    @Inject
    ConnectionFragment connectionFragment;

    @Inject
    Test test;
    //这个是通过接口接收的，不能通过实现类上面的构造来注入
    //如果是通过本类来接收的，可以直接通过构造来注入
    @Inject
    TestContract.TestInner test2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switchMenu(getFragmenTag(R.id.rb_home));
        radioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    private Fragment mCurrentFragment;

    private void switchMenu(String fragmentTag) {

        Fragment fragment = fragmentManager.findFragmentByTag(fragmentTag);

        if (fragment != null) {
            if (fragment == mCurrentFragment) return;
            fragmentManager.beginTransaction().show(fragment).commit();
        } else {
            if (TextUtils.equals(fragmentTag, APPValue.FRAGMENT_HOME)) {
                //加载首页
                fragment = homeFragment;
            } else if (TextUtils.equals(fragmentTag, APPValue.FRAGMENT_OFFER)) {
                //加载报价
                fragment = offerFragment;
            } else if (TextUtils.equals(fragmentTag, APPValue.FRAGMENT_Mall)) {
                //加载商城
                fragment = mallFragment;
            } else if (TextUtils.equals(fragmentTag, APPValue.FRAGMENT_CONNECTIONS)) {
                //加载人脉
                fragment = connectionFragment;
            }
            if (fragment != null) {
                fragmentManager.beginTransaction().add(R.id.fl_container
                        , fragment, fragmentTag).commit();
            }
        }
        if (mCurrentFragment != null) {
            fragmentManager.beginTransaction().hide(mCurrentFragment).commit();
        }
        mCurrentFragment = fragment;
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        switchMenu(getFragmenTag(checkedId));
    }

    private String getFragmenTag(int menuId) {
        switch (menuId) {
            case R.id.rb_home:
                return APPValue.FRAGMENT_HOME;
            case R.id.rb_offer:
                return APPValue.FRAGMENT_OFFER;
//                return APPValue.FRAGMENT_INDEX;
            case R.id.rb_mall:
                return APPValue.FRAGMENT_Mall;
            case R.id.rb_connections:
                return APPValue.FRAGMENT_CONNECTIONS;
            default:
                return "";
        }
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
