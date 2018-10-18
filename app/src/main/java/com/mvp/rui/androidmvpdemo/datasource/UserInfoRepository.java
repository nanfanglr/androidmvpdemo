package com.mvp.rui.androidmvpdemo.datasource;


import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;

import com.mvp.rui.androidmvpdemo.model.UserInfo;
import com.mvp.rui.androidmvpdemo.netservice.UserExampleService;
import com.mvp.rui.androidmvpdemo.ui.LoginActivity;
import com.rui.mvp.network.basemodel.ResultModel;

import org.reactivestreams.Publisher;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import timber.log.Timber;

/**
 * 统一管理登录及用户信息的类（可以理解为保存登录状态和用户信息数据源），全局单例
 * 这个类存储用户信息，以及是否登录状态判断
 * Created by 0200030 on 2018/1/27.
 */
public class UserInfoRepository {
    /**
     * 接口
     */
    private UserExampleService userExampleService;
    /**
     * 用户信息
     *
     */
    private UserInfo userInfo;
    /**
     * 更新用户信息的数据源
     * 在需要更新用户新的页面，注入UserInfoRepository，获取到该对象后即可更新数据
     */
    private Subject<UserInfo> subject;
    /**
     * 用于处理点击对话框取消的标识符，以便阻止订阅发生的后续事件。
     * 如果不需要对话框,这个完全可以不用定义
     */
    private boolean cancelSubscribe;

    /**
     * user数据源的构造函数
     *
     * @param userExampleService
     */
    public UserInfoRepository(UserExampleService userExampleService) {
        this.userExampleService = userExampleService;
        subject = PublishSubject.create();
        Timber.d("------------->mainService=" + userExampleService);
    }


    /**
     * 登录及更新用户信息
     *
     * @param phone
     * @return
     */
    public Flowable<ResultModel<UserInfo>> loginOB(String phone) {
        //这是写的测试数据
//        return Flowable.create((FlowableOnSubscribe<ResultModel<UserInfo>>)
//                emitter -> {
//                    UserInfo userInfo = new UserInfo();
//                    userInfo.setMobileNum(phone);
//                    userInfo.setUserId(1);
//                    userInfo.setAccountId(23);
//                    userInfo.setToken("jklasjdflajsdlfajsdfasd");
//                    userInfo.setUserName("Jay");
//                    userInfo.setUserCode("Jay-2222");
//                    ResultModel<UserInfo> resultModel = new ResultModel<>();
//                    resultModel.setData(userInfo);
//                    resultModel.setCode(1);
//                    emitter.onNext(resultModel);
//                    emitter.onComplete();
//                }, BackpressureStrategy.LATEST)
//                .doOnNext(resultModel -> {
//                    if (resultModel.isSuccess()) {
//                        updateUserInfo(resultModel.getData());
//                    }
//                });
        //这是接口返回的数据
        return userExampleService.login(phone)
                .doOnNext(userInfoResultModel -> {
                    if (userInfoResultModel.isSuccess()) {
                        updateUserInfo(userInfoResultModel.getData());
                    }
                });
    }

    /**
     * 更新用户信息
     *
     * @param user
     */
    private void updateUserInfo(UserInfo user) {
        userInfo = user;
        subject.onNext(user);
    }

    /**
     * 修改用户信息（模拟方法，这里功能未实现）
     *
     * @param phone
     * @return
     */
    public Flowable<ResultModel<UserInfo>> updateUserInfoOB(String phone) {
        return Flowable.create((FlowableOnSubscribe<ResultModel<UserInfo>>) emitter -> {
            //模拟修改用户信息之后的操作
            UserInfo userInfo = new UserInfo();
            ResultModel<UserInfo> resultModel = new ResultModel<>();
            resultModel.setData(userInfo);
            emitter.onNext(resultModel);
            emitter.onComplete();
        }, BackpressureStrategy.LATEST)
                .doOnNext(resultModel -> {
                    //这里处理更新个人信息，两种情况
                    // 1-调取个人信息的接口重新返回数据
                    // 2-直接更新userinfo中的值
                    if (resultModel.isSuccess()) {
                        updateUserInfo(resultModel.getData());
                    }
                });

    }

    /**
     * 这个方法专门用来处理需要登录状态的业务
     * 如果没有登录，则先弹出对话框，
     * 点击确定去登录页面
     * 点击取消不做任何操作
     *
     * @param context
     * @return
     */
    public Flowable<UserInfo> checkLoginOB(Context context) {
        cancelSubscribe = false;
        return Flowable
                .create((FlowableOnSubscribe<Boolean>) emitter -> {
                    emitter.onNext(userInfo == null);
                    emitter.onComplete();
                }, BackpressureStrategy.LATEST)
                .flatMap((Function<Boolean, Publisher<UserInfo>>) aBoolean -> {
                    Timber.d("------------->1111aBoolean=" + aBoolean);
                    if (aBoolean) {
                        new AlertDialog.Builder(context)
                                .setTitle("当前操作需要登录app")
                                .setMessage("请先登录app")
                                .setNegativeButton("取消", (dialog, which) -> {
                                    cancelSubscribe = true;
                                })
                                .setPositiveButton("确定", (dialog, which) -> {
                                    context.startActivity(new Intent(context, LoginActivity.class));
                                })
                                .create()
                                .show();
                        return getUpdateOB();
                    } else {
                        return getUserInfoOB();
                    }
                });
    }

    /**
     * 更新用户信息的数据源
     * 在需要更新用户新的页面，
     * 注入UserInfoRepository，
     * 获取到该对象后即可实时更新数据
     */
    public Flowable<UserInfo> getUpdateOB() {
        return subject.toFlowable(BackpressureStrategy.LATEST);
    }

    /**
     * 获取当前登录的用户信息
     *
     * @return
     */
    public Flowable<UserInfo> getUserInfoOB() {
        return Flowable.just(userInfo);
    }


    public boolean isCancelSubscribe() {
        return cancelSubscribe;
    }

}
