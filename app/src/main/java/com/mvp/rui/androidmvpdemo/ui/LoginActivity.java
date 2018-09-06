package com.mvp.rui.androidmvpdemo.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mvp.rui.androidmvpdemo.R;
import com.mvp.rui.androidmvpdemo.presenter.LoginActPresenter;
import com.rui.mvp.activity.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import timber.log.Timber;

public class LoginActivity extends BaseActivity<
        com.rui.android_mvp_with_componentization.di.contract.LoginActView
        , LoginActPresenter>
        implements
        com.rui.android_mvp_with_componentization.di.contract.LoginActView {

    @Inject
    com.rui.android_mvp_with_componentization.example.TestModel testModel;
    @BindView(R.id.et_input)
    EditText etInput;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_login)
    TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Timber.d("----------->" + testModel.getContext().getClass().getSimpleName());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }


    @Override
    public void onLogin(String result) {
//        tvLogin.setText(result);
        finish();
    }

    @OnClick({R.id.btn_login, R.id.tv_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                Timber.d("----------->onViewClicked");
                String phone = etInput.getText().toString().trim();
                getPresenter().login(phone);
                break;
            case R.id.tv_login:
                break;
        }
    }

}
