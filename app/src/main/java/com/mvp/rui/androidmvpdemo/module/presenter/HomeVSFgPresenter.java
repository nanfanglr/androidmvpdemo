package com.mvp.rui.androidmvpdemo.module.presenter;

import com.mvp.rui.androidmvpdemo.common.basemvp.BasePresenter;
import com.mvp.rui.androidmvpdemo.module.di.contract.HomeFgView;
import com.mvp.rui.androidmvpdemo.module.mapper.HomeVSMapper;
import com.mvp.rui.androidmvpdemo.module.networkservice.HomeService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by rui on 2018/3/9.
 */
public class HomeVSFgPresenter extends BasePresenter<HomeFgView> {

    private HomeService homeService;
    private HomeVSMapper homeVSMapper;

    @Inject
    public HomeVSFgPresenter(HomeService homeService, HomeVSMapper homeVSMapper) {
        this.homeService = homeService;
        this.homeVSMapper = homeVSMapper;
    }

    public void getCategory(String token) {
        composite.add(homeService.getCategorys(token)
                .flatMapObservable(listResultModel ->
                        Observable.fromIterable(listResultModel.getData()))
                .map(infoCategory -> {
                    //infoCategory处理一些事物
                    return infoCategory;
                })
                .toSortedList((o1, o2) -> {
                    //排序后重新变成list
                    double dis = o1.getSeqNum() - o2.getSeqNum();
                    return dis > 0 ? 1 : dis < 0 ? -1 : 0;
                })
                .map(infoCategorys -> homeVSMapper.map(infoCategorys))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(model -> {
                    getView().onCategoryLoad(model);
                }, throwable -> {
                    throwable.printStackTrace();
                })
        );
    }

}
