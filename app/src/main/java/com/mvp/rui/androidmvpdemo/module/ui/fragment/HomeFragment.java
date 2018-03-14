package com.mvp.rui.androidmvpdemo.module.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mvp.rui.androidmvpdemo.R;
import com.mvp.rui.androidmvpdemo.common.fragment.BaseLazyFragment;
import com.mvp.rui.androidmvpdemo.module.di.contract.HomeFgView;
import com.mvp.rui.androidmvpdemo.module.model.InfoCategory;
import com.mvp.rui.androidmvpdemo.module.model.InfomationVModel;
import com.mvp.rui.androidmvpdemo.module.presenter.HomeFgPresenter;
import com.mvp.rui.androidmvpdemo.module.ui.adapter.FgPagerAdapter;
import com.mvp.rui.androidmvpdemo.module.viewstate.HomeFgViewState;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by rui on 2018/3/12.
 */
public class HomeFragment extends BaseLazyFragment<
        HomeFgView,
        HomeFgPresenter,
        HomeFgViewState
        > implements
        HomeFgView {

    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.vp_container)
    ViewPager vpContainer;
    @BindView(R.id.tl_info)
    TabLayout tlInfo;
    @BindView(R.id.iv_add)
    ImageView ivAdd;
    @BindView(R.id.ll_head)
    LinearLayout llHead;

    private List<Fragment> fragmentList;
    private Fragment currentFragment;
    private FgPagerAdapter fgPagerAdapter;
    private boolean isCategorychange;
    //    public List<String> selectedDatas;
//    private String[] titles = {"推荐", "图片", "报价", "科技", "体育", "热点", "两会", "中国"};

    public List<InfoCategory> selectedDatas;
    public List<InfoCategory> unSelectedDatas;
    public List<InfoCategory> allDatas;

    public static HomeFragment newInstance(Context context) {
        Bundle bundle = new Bundle();
        return (HomeFragment) Fragment.instantiate(context, HomeFragment.class.getName(), bundle);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void lazyFetchData() {
        getPresenter().getCategory(null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    private void initViews() {
        fragmentList = new ArrayList<>();
        selectedDatas = new ArrayList<>();
        unSelectedDatas = new ArrayList<>();
        allDatas = new ArrayList<>();

        fgPagerAdapter = new FgPagerAdapter(childFragmentManager, fragmentList, selectedDatas);
        vpContainer.setAdapter(fgPagerAdapter);

        tlInfo.setupWithViewPager(vpContainer);

    }

    @Override
    public void onCategoryLoad(InfomationVModel model) {
        fragmentList.clear();
        selectedDatas.clear();
        unSelectedDatas.clear();

        fragmentList.addAll(model.getFragmentList());
        selectedDatas.addAll(model.getSelectedDatas());
        unSelectedDatas.addAll(model.getUnSelectedDatas());

        allDatas.addAll(selectedDatas);
        allDatas.addAll(unSelectedDatas);
        fgPagerAdapter.notifyDataSetChanged();
        vpContainer.setOffscreenPageLimit(selectedDatas.size());
        vpContainer.setCurrentItem(0);
        tlInfo.post(() -> {
            ViewGroup slidingTabStrip = (ViewGroup) tlInfo.getChildAt(0); //设置最小宽度，使其可以在滑动一部分距离
            if (true) {
                slidingTabStrip.setMinimumWidth(slidingTabStrip.getMeasuredWidth() + ivAdd.getMeasuredWidth());
            } else {
                //注意：因为最开始设置了最小宽度，所以重新测量宽度的时候一定要先将最小宽度设置为0
                slidingTabStrip.setMinimumWidth(0);
                slidingTabStrip.measure(0, 0);
                slidingTabStrip.setMinimumWidth(slidingTabStrip.getMeasuredWidth() + ivAdd.getMeasuredWidth());
            }
        });
    }

    @Override
    public void showLoadingBar() {

    }

    @Override
    public void dismissLoadingBar() {

    }

    @Override
    public void showLoadingFailureError() {

    }
}
