package com.mvp.rui.androidmvpdemo.common.activity;

import android.os.Bundle;

import com.hannesdorfmann.mosby3.mvp.MvpActivity;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.hannesdorfmann.mosby3.mvp.delegate.ActivityMvpDelegate;
import com.hannesdorfmann.mosby3.mvp.delegate.ActivityMvpViewStateDelegateImpl;
import com.hannesdorfmann.mosby3.mvp.delegate.MvpViewStateDelegateCallback;
import com.hannesdorfmann.mosby3.mvp.viewstate.MvpViewStateActivity;
import com.hannesdorfmann.mosby3.mvp.viewstate.ViewState;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Created by rui on 2018/3/9.
 */
public abstract class BaseVSActivity<
        VIEW extends MvpView,
        PRESENTER extends MvpPresenter<VIEW>,
        VIEW_STATE extends ViewState<VIEW>>
        extends BaseActivity<VIEW, PRESENTER>
        implements
        MvpViewStateDelegateCallback<VIEW, PRESENTER, VIEW_STATE> {

    /**
     * Can't inject directly, as the presenter instantiation needs to happen by mosby in {@link this#createViewState()}.
     */
    @Inject
    Provider<VIEW_STATE> viewStateProvider;
    private VIEW_STATE viewState;

    /**
     * Instead of extending {@link MvpActivity} or {@link MvpViewStateActivity} we are using a mosby's delegate. To do that we need to
     * propagate certain activity lifecycle methods to the delegate.
     */
    @Nullable
    protected ActivityMvpDelegate mvpDelegate;

    private boolean viewStateRestoreInProgress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMvpDelegate().onCreate(savedInstanceState);
    }

    // Delegate propagation ****************************************************************************************************************
    @Override
    protected ActivityMvpDelegate<VIEW, PRESENTER> getMvpDelegate() {
        if (mvpDelegate == null) {
            mvpDelegate = new ActivityMvpViewStateDelegateImpl<>(this, this, true);
        }
        return mvpDelegate;
    }

    // View state related ******************************************************************************************************************

    @Override
    public void setViewState(VIEW_STATE viewState) {
        this.viewState = viewState;
    }

    @Override
    public VIEW_STATE getViewState() {
        return viewState;
    }

    @Override
    public VIEW_STATE createViewState() {
        return viewStateProvider.get();
    }

    @Override
    public void setRestoringViewState(boolean restoringViewState) {
        this.viewStateRestoreInProgress = restoringViewState;
    }

    @Override
    public boolean isRestoringViewState() {
        return viewStateRestoreInProgress;
    }

    /**
     * Called right after the state of the view has been restored from the {@link VIEW_STATE}.
     */
    @Override
    public void onViewStateInstanceRestored(boolean instanceStateRetained) {
        // Default not doing anything. Override when required.
    }

    @Override
    public void onNewViewStateInstance() {
        onFirstCreate();
    }

    /**
     * Default implementation not doing anything. Override when required to perform long running tasks only once, then save their state in
     * the {@link VIEW_STATE}
     */
    protected void onFirstCreate() {
        // Default implementation not doing anything. Override when required.
    }

}
