package com.mvp.rui.androidmvpdemo.presenter;


import android.content.Context;

import com.rui.android_mvp_with_componentization.datasource.UserInfoRepository;
import com.rui.android_mvp_with_componentization.di.contract.LoginActView;
import com.rui.android_mvp_with_componentization.model.UserInfo;
import com.rui.android_mvp_with_componentization.netservice.UserExampleService;
import com.rui.mvp.basemvp.BaseLoadPresenter;
import com.rui.mvp.network.ApiErro.MyConsumer;

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
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(userInfo -> {
                            if (userInfo.isSuccess()) {
                                UserInfo info = userInfo.getData();
//                                userInfoRepository.updateUserInfo(info);
                                getView().onLogin(info.toString());
                            } else {
                                getView().onLogin("登陆失败");
                            }
                        }, new MyConsumer(context))
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
