package com.mvp.rui.androidmvpdemo.common.dagger.modules;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.mvp.rui.androidmvpdemo.common.dagger.scopes.ActivityScope;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Provides base activity dependencies. This must be included in all activity modules, which must
 * provide a concrete implementation of {@link Activity}.
 */
@Module
public abstract class BaseActivityModule {

    public static final String ACTIVITY_FRAGMENT_MANAGER = "BaseActivityModule.activityFragmentManager";

    @Binds
    @ActivityScope
    /*
     * PerActivity annotation isn't necessary since Activity instance is unique but is here for
     * convention. In general, providing Application, Activity, Fragment, BroadcastReceiver,
     * etc does not require scoped annotations since they are the components being injected and
     * their instance is unique.
     *
     * However, having a scope annotation makes the module easier to read. We wouldn't have to look
     * at what is being provided in order to understand its scope.
     */
    abstract Context activityContext(FragmentActivity activity);

    @Provides
    @Named(ACTIVITY_FRAGMENT_MANAGER)
    @ActivityScope
    static FragmentManager activityFragmentManager(FragmentActivity activity) {
        return activity.getSupportFragmentManager();
    }
}
