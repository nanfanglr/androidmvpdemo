package com.mvp.rui.androidmvpdemo.common.basemvp;

import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby3.mvp.MvpNullObjectBasePresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by rui on 2018/3/9.
 */

public class BasePresenter<T extends MvpView> extends MvpNullObjectBasePresenter<T> {

    protected CompositeDisposable composite;

    @Override
    public void attachView(@NonNull T view) {
        super.attachView(view);
        this.composite = new CompositeDisposable();
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        if (!retainInstance && composite != null && !composite.isDisposed()) {
            composite.dispose();
        }
    }
}
