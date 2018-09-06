package com.rui.mvp.dagger.scopes;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * So that we are able to tell apart application contexts from activity ones in the dagger graph.
 */
@Qualifier
@Documented
@Retention(RUNTIME)
public @interface ApplicationContext {

}
