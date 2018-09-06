package com.rui.mvp.basemvp;

import com.rui.mvp.network.ApiErro.ApiErrorCode;
import com.rui.mvp.network.ApiErro.ApiException;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.Single;
import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by rui on 2018/3/9.
 */
public class BaseLoadPresenter<T extends LoadMvpView> extends BasePresenter<T> {

    protected <T> SingleTransformer<T, T> singleTransformer() {
        return apiResultObservable -> {
            if (getView().isNetworkAvailable()) {
                return apiResultObservable
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable -> getView().showLoadingBar())
                        .doAfterTerminate(() -> getView().dismissLoadingBar());
            } else {
                return Single.error(new ApiException(ApiErrorCode.ERROR_NO_INTERNET, "网络不可用"));
            }
        };
    }

    protected <T> ObservableTransformer<T, T> observableTransformer() {
        return apiResultObservable -> {
            if (getView().isNetworkAvailable()) {
                return apiResultObservable
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable -> getView().showLoadingBar())
                        .doAfterTerminate(() -> getView().dismissLoadingBar());
            } else {
                return Observable.error(new ApiException(ApiErrorCode.ERROR_NO_INTERNET, "网络不可用"));
            }
        };
    }

    protected <T> FlowableTransformer<T, T> flowableTransformer() {
        return apiResultObservable -> {
            if (getView().isNetworkAvailable()) {
                return apiResultObservable
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable -> getView().showLoadingBar())
                        .doAfterTerminate(() -> getView().dismissLoadingBar());
            } else {
                return Flowable.error(new ApiException(ApiErrorCode.ERROR_NO_INTERNET, "网络不可用"));
            }
        };
    }

}
