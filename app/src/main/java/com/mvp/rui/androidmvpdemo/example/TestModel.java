package com.rui.android_mvp_with_componentization.example;

import android.content.Context;

/**
 * Created by rui on 2018/3/10.
 */
public class TestModel {

    Context context;


    public TestModel(Context context) {
        this.context = context;
    }
    /*用构造函数inject时，这个是对构造参数进行限制，而使用module提供时则此注解无效*/
//    @Inject
//    public TestModel( @ApplicationContext Context context) {
//        this.context = context;
//    }

    public Context getContext() {
        return context;
    }
}
