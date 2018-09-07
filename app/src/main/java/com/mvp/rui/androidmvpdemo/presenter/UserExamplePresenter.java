package com.mvp.rui.androidmvpdemo.presenter;


import android.content.Context;

import com.mvp.rui.androidmvpdemo.datasource.UserInfoRepository;
import com.mvp.rui.androidmvpdemo.di.contract.UserExampleActView;
import com.rui.android_mvp_with_componentization.model.UserInfo;
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
     * @param id 用来区分，那个操作的回调
     */
    public void checkLogin(int id) {
        composite.add(userInfoRepository.checkLoginOB(context)
                        .flatMap((Function<UserInfo, Publisher<UserInfo>>) userInfo -> {
                            //这里转换成为需要登录状态之前的操作
                            return Flowable.just(userInfo);
                        })
                        .subscribeOn(AndroidSchedulers.mainThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(userInfo -> {
                            //只关心成功的情况
                            Timber.d("-------->id=" + id);
                            getView().onLogin(id);
//                    getView().updateUserInfo(userInfo.toString());
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
