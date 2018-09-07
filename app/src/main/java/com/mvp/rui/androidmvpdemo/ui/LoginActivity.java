package com.mvp.rui.androidmvpdemo.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mvp.rui.androidmvpdemo.R;
import com.mvp.rui.androidmvpdemo.di.contract.LoginActView;
import com.mvp.rui.androidmvpdemo.di.presenter.LoginActPresenter;
import com.mvp.rui.androidmvpdemo.example.TestModel;
import com.rui.mvp.activity.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import timber.log.Timber;

/**
 * 示范的登录界面
 */
public class LoginActivity extends BaseActivity<
        LoginActView
        , LoginActPresenter>
        implements
        LoginActView {

    @Inject
    TestModel testModel;
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
                if (!TextUtils.isEmpty(phone)) {
                    getPresenter().login(phone);
                } else {
                    Toast.makeText(this, "请输入手机号码", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.tv_login:
                break;
        }
    }

}
