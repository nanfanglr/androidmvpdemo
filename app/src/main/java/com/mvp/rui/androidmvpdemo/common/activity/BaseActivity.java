package com.mvp.rui.androidmvpdemo.common.activity;

import android.os.Bundle;
import android.view.View;

import com.hannesdorfmann.mosby3.mvp.MvpActivity;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.hannesdorfmann.mosby3.mvp.delegate.ActivityMvpDelegate;
import com.hannesdorfmann.mosby3.mvp.delegate.ActivityMvpDelegateImpl;
import com.hannesdorfmann.mosby3.mvp.delegate.MvpDelegateCallback;
import com.hannesdorfmann.mosby3.mvp.viewstate.MvpViewStateActivity;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Created by rui on 2018/4/3.
 */
public abstract class BaseActivity<
        VIEW extends MvpView,
        PRESENTER extends MvpPresenter<VIEW>>
        extends BaseAppCompatActivity
        implements
        MvpDelegateCallback<VIEW, PRESENTER> {

    /**
     * Can't inject directly, as the presenter instantiation needs to happen by mosby in {@link this#createPresenter()}.
     */
    @Inject
    Provider<PRESENTER> presenterProvider;
    private PRESENTER presenter;


    /**
     * Instead of extending {@link MvpActivity} or {@link MvpViewStateActivity} we are using a mosby's delegate. To do that we need to
     * propagate certain activity lifecycle methods to the delegate.
     */
    @Nullable
    protected ActivityMvpDelegate mvpDelegate;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMvpDelegate().onCreate(savedInstanceState);
    }

    // Delegate propagation ****************************************************************************************************************

    private ActivityMvpDelegate<VIEW, PRESENTER> getMvpDelegate() {
        if (mvpDelegate == null) {
            mvpDelegate = new ActivityMvpDelegateImpl<>(this, this, true);
        }
        return mvpDelegate;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getMvpDelegate().onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getMvpDelegate().onSaveInstanceState(outState);
    }

    @Override
    protected void onPause() {
        super.onPause();
        getMvpDelegate().onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getMvpDelegate().onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        getMvpDelegate().onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        getMvpDelegate().onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        getMvpDelegate().onRestart();
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        getMvpDelegate().onContentChanged();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        getMvpDelegate().onPostCreate(savedInstanceState);
    }

    // MVP related *************************************************************************************************************************

    @Override
    @SuppressWarnings("unchecked")
    public VIEW getMvpView() {
        return (VIEW) this;
    }

    @Override
    public PRESENTER createPresenter() {
        return presenterProvider.get();
    }

    @Override
    public PRESENTER getPresenter() {
        return presenter;
    }

    @Override
    public void setPresenter(PRESENTER presenter) {
        this.presenter = presenter;
    }
    

    public void backClick(View v) {
        finish();
    }

}
