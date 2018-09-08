package com.rui.common.basepage;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.delegate.MvpDelegateCallback;
import com.rui.common.R;
import com.rui.common.constant.APPValue;
import com.rui.mvp.activity.BaseActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/**
 * 这是一个给列表封装的BaseActivity,封转列表的初始化，emptyView，上拉加载下拉刷新框架
 * 根据项目需求修改页面相关的逻辑
 * Created by rui on 2018/7/28.
 */
public abstract class BaseListActivity<
        VIEW extends LoadPageView,
        PRESENTER extends MvpPresenter<VIEW>,
        ADAPTER extends BaseQuickAdapter,
        LAYOUTMANAGER extends RecyclerView.LayoutManager
        >
        extends BaseActivity<VIEW, PRESENTER>
        implements
        MvpDelegateCallback<VIEW, PRESENTER>
        , LoadPageView {
    /**
     * 空的布局
     */
    protected View emptyView;
    /**
     * 空的布局提示文案
     */
    protected TextView tvEmpty;
    /**
     * 列表适配器
     */
    protected ADAPTER adapter;
    /**
     * 列表布局管理器
     */
    protected LAYOUTMANAGER layoutmanager;
    @Inject
    Provider<ADAPTER> adapterProvider;
    @Inject
    Provider<LAYOUTMANAGER> layoutmanagerProvider;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initRefreshLayout();
        initRv();
        initEmptyView();
    }

    protected void initRefreshLayout() {
        if (getRefreshLayout() == null) return;
        ClassicsHeader classicsHeader = new ClassicsHeader(this);
        classicsHeader.setTextSizeTitle(14);
        classicsHeader.setTextSizeTime(10);
        getRefreshLayout().setRefreshHeader(classicsHeader);
        ClassicsFooter classicsFooter = new ClassicsFooter(this);
        classicsFooter.setTextSizeTitle(14);
        getRefreshLayout().setRefreshFooter(classicsFooter);
        getRefreshLayout().setHeaderHeight(46);
        getRefreshLayout().setFooterHeight(46);
        getRefreshLayout().setOnRefreshListener(refreshlayout -> {
            getData(APPValue.LOAD_REFRESH);
        });
        getRefreshLayout().setOnLoadMoreListener(refreshlayout -> {
            getData(APPValue.LOAD_MORE);
        });
    }

    /**
     * 获取数据的方法
     *
     * @param type
     */
    protected abstract void getData(int type);

    /**
     * 子类必须实现此方法，这样才能做列表的初始化
     *
     * @return
     */
    protected abstract SmartRefreshLayout getRefreshLayout();

    /**
     * 初始化emptyview
     */
    protected void initEmptyView() {
        emptyView = getLayoutInflater().inflate(R.layout.empty_view,
                (ViewGroup) getRV().getParent(), false);
        tvEmpty = emptyView.findViewById(R.id.tv_no_data);
    }

    /**
     * 初始化列表相关的view及适配器
     */
    protected void initRv() {
        if (getRV() == null) return;
        adapter = createAdapter();
        layoutmanager = createLayoutmanager();
        getRV().setAdapter(adapter);
        getRV().setLayoutManager(layoutmanager);
    }

    /**
     * 创建列表适配器，可以在module中provides，也可以通过构造加@inject
     *
     * @return
     */
    private ADAPTER createAdapter() {
        return adapterProvider.get();
    }

    /**
     * 创建布局管理器，在module中provides
     *
     * @return
     */
    private LAYOUTMANAGER createLayoutmanager() {
        return layoutmanagerProvider.get();
    }

    /**
     * 子类必须实现此方法，这样才能做列表的初始化
     *
     * @return
     */
    protected abstract RecyclerView getRV();

    @Override
    public void finishRefreshOrLoadMore(int type) {
        if (getRefreshLayout() == null) return;
        if (type == APPValue.LOAD_REFRESH) {
            getRefreshLayout().finishRefresh(/*2000/*,false*/);
        } else if (type == APPValue.LOAD_MORE) {
            getRefreshLayout().finishLoadMore(200);
        }
    }

    @Override
    public void finishLoadMoreWithNoMoreData() {
        if (getRefreshLayout() == null) return;
        getRefreshLayout().finishLoadMoreWithNoMoreData();
    }

    /**
     * 设置空布局的文案
     *
     * @param str
     */
    protected void setEmptyViewText(String str) {
        if (tvEmpty != null) tvEmpty.setText(str);
    }

    /**
     * 设置空布局显示的方法
     */
    protected void setEmptyView() {
        if (adapter.getItemCount() == 0) {
            adapter.setEmptyView(emptyView);
        }
    }
}
