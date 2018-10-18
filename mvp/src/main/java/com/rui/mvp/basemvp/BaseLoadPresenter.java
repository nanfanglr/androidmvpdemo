package com.rui.mvp.basemvp;

import io.reactivex.FlowableTransformer;
import io.reactivex.ObservableTransformer;
import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by rui on 2018/3/9.
 */
public class BaseLoadPresenter<T extends LoadMvpView> extends BasePresenter<T> {

    protected <T> SingleTransformer<T, T> singleTransformer() {
        return apiResultObservable -> {
            return apiResultObservable
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe(disposable -> getView().showLoadingBar())
                    .doAfterTerminate(() -> getView().dismissLoadingBar());

        };
    }

    protected <T> ObservableTransformer<T, T> observableTransformer() {
        return apiResultObservable -> {
            return apiResultObservable
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe(disposable -> getView().showLoadingBar())
                    .doAfterTerminate(() -> getView().dismissLoadingBar());

        };
    }

    protected <T> FlowableTransformer<T, T> flowableTransformer() {
        return apiResultObservable -> {
            return apiResultObservable
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe(disposable -> getView().showLoadingBar())
                    .doAfterTerminate(() -> getView().dismissLoadingBar());

        };
    }

}
