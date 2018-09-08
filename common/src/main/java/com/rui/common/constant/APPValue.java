package com.rui.common.constant;//package com.mvp.rui.androidmvpdemo.common.constants;

/**
 * 这里主要定义APP用的常量
 * Created by rui on 2018/3/9.
 */
public interface APPValue {
    String FRAGMENT_HOME = "home";
    String FRAGMENT_OFFER = "offer";
    //    String FRAGMENT_INDEX = "index";
    String FRAGMENT_Mall = "mall";
    String FRAGMENT_CONNECTIONS = "connections";
    String FRAGMENT_LEFT = "left_info";
    int PAGE_LIMIT = 20;

    /**
     * 我的栏目
     */
    String CATEGORY_MY = "MY";

    /**
     * 默认栏目
     */
    String CATEGORY_DEFUALT = "DF";

    /**
     * 第一次加载数据
     */
    int LOAD_FIRST = 0;
    /**
     * 下拉刷新数据
     */
    int LOAD_REFRESH = 1;
    /**
     * 上拉加载更多
     */
    int LOAD_MORE = 2;
}
