package com.rui.mvp.fragment;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.delegate.FragmentMvpDelegate;
import com.hannesdorfmann.mosby3.mvp.delegate.FragmentMvpViewStateDelegateImpl;
import com.hannesdorfmann.mosby3.mvp.delegate.MvpViewStateDelegateCallback;
import com.hannesdorfmann.mosby3.mvp.viewstate.ViewState;
import com.rui.mvp.basemvp.LoadMvpView;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Created by 0200030 on 2017/9/2.
 */
public abstract class BaseLazyVSFragment<
        VIEW extends LoadMvpView
        , PRESENTER extends MvpPresenter<VIEW>
        , VIEW_STATE extends ViewState<VIEW>>
        extends BaseLazyFragment<VIEW, PRESENTER>
        implements MvpViewStateDelegateCallback<VIEW, PRESENTER, VIEW_STATE> {

    /**
     * Can't inject directly, as the presenter instantiation needs to happen by mosby in {@link this#createViewState()}.
     */
    @Inject
    Provider<VIEW_STATE> viewStateProvider;
    private VIEW_STATE viewState;


    // Delegate propagation ****************************************************************************************************************


    @Override
    protected FragmentMvpDelegate<VIEW, PRESENTER> getMvpDelegate() {
        if (mvpDelegate == null) {
            mvpDelegate = new FragmentMvpViewStateDelegateImpl<>(this, this
                    , true, true);
        }
        return mvpDelegate;
    }


    // View state related ******************************************************************************************************************

    /**
     * A simple flag that indicates if the restoring ViewState  is in progress right now.
     */
    private boolean restoringViewState = false;


    @Override
    public VIEW_STATE getViewState() {
        return viewState;
    }

    @Override
    public void setViewState(VIEW_STATE viewState) {
        this.viewState = viewState;
    }

    @Override
    public void setRestoringViewState(boolean restoringViewState) {
        this.restoringViewState = restoringViewState;
    }

    @Override
    public boolean isRestoringViewState() {
        return restoringViewState;
    }

    @Override
    public void onViewStateInstanceRestored(boolean instanceStateRetained) {
        // not needed. You could override this is subclasses if needed
    }

    @Override
    public VIEW_STATE createViewState() {
        return viewStateProvider.get();
    }

    @Override
    public void onNewViewStateInstance() {
        lazyFetchDataIfPrepared();
    }

}
