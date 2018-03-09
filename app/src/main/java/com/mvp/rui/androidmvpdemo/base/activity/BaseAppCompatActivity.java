package com.mvp.rui.androidmvpdemo.base.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.annotation.Nullable;

import butterknife.ButterKnife;

/**
 * 为加载fragment抽出来的，此activity不需要获取数据显示因此没有MVP类
 * Created by rui on 2018/3/9.
 */
public abstract class BaseAppCompatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
    }

    protected abstract int getLayoutId();

}
