package com.mvp.rui.androidmvpdemo.di.presenter;

import android.content.Context;

import com.mvp.rui.androidmvpdemo.datasource.UserInfoRepository;
import com.mvp.rui.androidmvpdemo.di.contract.UserExampleActView;
import com.mvp.rui.androidmvpdemo.model.UserInfo;
import com.rui.mvp.basemvp.BaseLoadPresenter;

import org.reactivestreams.Publisher;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import timber.log.Timber;

/**
 * Created by rui on 2018/3/9.
 */
public class UserExamplePresenter extends BaseLoadPresenter<UserExampleActView> {

    private final UserInfoRepository userInfoRepository;
    private Context context;

    @Inject
    public UserExamplePresenter(UserInfoRepository userInfoRepository, Context context) {
        this.userInfoRepository = userInfoRepository;
        this.context = context;
    }

    /**
     * 检查登录状态，并做下一次操作
     */
    public void checkLogin() {
        composite.add(userInfoRepository.checkLoginOB(context)
                .flatMap((Function<UserInfo, Publisher<UserInfo>>) userInfo -> {
                    //这里转换成为需要登录状态之前的操作
                    // 如果取消了发出一个空的数据，避免触发下一个操作
                    //另外可以在点击去登录的时候去取消订阅，这样可以彻底解除订阅关系
                    return !userInfoRepository.isCancelSubscribe() ?
                            Flowable.just(userInfo) : Flowable.empty();
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userInfo -> {
                    Timber.d("------------>checkLogin");
                    //只关心成功的情况
                    getView().onLogin();
                })
        );
    }

    /**
     * 将user的数据源获取到当前页面
     */
    public void updateUserInfo() {
        composite.add(userInfoRepository.getUpdateOB()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userInfo -> {
                    //只关心成功的情况
                    getView().updateUserInfo(userInfo.toString());
                })
        );
    }


}
