package com.mvp.rui.androidmvpdemo.di.presenter;


import android.content.Context;

import com.mvp.rui.androidmvpdemo.datasource.UserInfoRepository;
import com.mvp.rui.androidmvpdemo.di.contract.LoginActView;
import com.mvp.rui.androidmvpdemo.model.UserInfo;
import com.mvp.rui.androidmvpdemo.netservice.UserExampleService;
import com.rui.mvp.basemvp.BaseLoadPresenter;
import com.rui.mvp.network.ApiErro.ExceptionConsumer;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Created by rui on 2018/3/9.
 */
public class LoginActPresenter extends BaseLoadPresenter<LoginActView> {

    private final UserExampleService userExampleService;
    private final UserInfoRepository userInfoRepository;
    private Context context;

    @Inject
    public LoginActPresenter(UserExampleService userExampleService, Context context, UserInfoRepository userInfoRepository) {
        this.userExampleService = userExampleService;
        this.userInfoRepository = userInfoRepository;
        this.context = context;
        Timber.d("------------->mainService=" + userExampleService);
    }

    /**
     * 添加统一api_erroer处理的写法一
     *
     * @param phone
     */
    public void login(String phone) {
        composite.add(userInfoRepository.loginOB(phone)
                        .compose(flowableTransformer())
                        .subscribe(userInfo -> {
                            if (userInfo.isSuccess()) {
                                UserInfo info = userInfo.getData();
                                getView().onLogin(info.toString());
                            } else {
                                getView().onLogin("登陆失败");
                            }
                        }, new ExceptionConsumer(context))
        );
    }

//    /**
//     * 添加统一api_erroer处理的写法二
//     *
//     * @param phone
//     */
//    public void loginA(String phone) {
//        mainService.login(phone)
//                .compose(singleTransformer())
//                .subscribe(new MySingleObserver<ResultModel<UserInfo>>(context) {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        composite.add(d);
//                    }
//
//                    @Override
//                    public void onSuccess(ResultModel<UserInfo> userInfo) {
//                        if (userInfo != null) {
//                            getView().onLogin(userInfo.toString());
//                        } else {
//                            getView().onLogin("登陆失败");
//                        }
//                    }
//                });
//    }
}
