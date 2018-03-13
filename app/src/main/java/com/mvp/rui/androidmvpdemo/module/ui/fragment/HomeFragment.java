package com.mvp.rui.androidmvpdemo.module.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mvp.rui.androidmvpdemo.R;
import com.mvp.rui.androidmvpdemo.common.fragment.BaseLazyFragment;
import com.mvp.rui.androidmvpdemo.module.di.contract.HomeFgView;
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

    private List<Fragment> mList;
    private Fragment currentFragment;
    private FgPagerAdapter fgPagerAdapter;
    private boolean isCategorychange;
    public List<String> mSelectedDatas;
    private String[] titles = {"推荐", "图片", "报价", "科技", "体育"};

//    public List<InfoCategory> mSelectedDatas;
//    public List<InfoCategory> mUnSelectedDatas;
//    public List<InfoCategory> allDatas;

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

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    private void initViews() {
        mList = new ArrayList<>();
        mSelectedDatas = new ArrayList<>();
        for (String str : titles) {
            mSelectedDatas.add(str);
            mList.add(HomeChildFragment.newInstance(getActivity(), 0, str));
        }
//        mUnSelectedDatas = new ArrayList<>();
//        allDatas = new ArrayList<>();

        fgPagerAdapter = new FgPagerAdapter(childFragmentManager, mList, mSelectedDatas);
        vpContainer.setAdapter(fgPagerAdapter);

        tlInfo.setupWithViewPager(vpContainer);
//        tlInfo.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                if (tab.getText() != null) {
//                    //选中TAB字体加粗
//                    String str = tab.getText().toString();
//                    CharSequence items = Html.fromHtml("<b>" + str + "</b>");//加粗
//                    //CharSequence items = Html.fromHtml("<big>" + str + "</big>");//变大
//                    tab.setText(items);
//                }
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//                if (tab.getText() != null) {
//                    //非选中TAB字体恢复原样
//                    String str = tab.getText().toString();
//                    CharSequence items = Html.fromHtml("<font color=\"#989898\">" + str + "</font>");
//                    tab.setText(items);
//                }
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//            }
//        });
//
//        vpContainer.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                JZVideoPlayer.releaseAllVideos();//停止列表视频播放
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//
//        headBar.SetIvRightOnclickerListener(v -> {
//            // TODO: 2017/9/13 搜索相关页面
//            IDataViewService serviceInterface = new DataViewProxy().getServiceInterface();
//            if (serviceInterface != null) {
//                serviceInterface.startSearchIndexActivity(mContext);
//            }
//        });
//        headBar.SetBtnLeftOnclickerListener(v -> EventBus.getDefault().post(new BaseEvents.LeftMineShowEvent()));
//
//        //tvTitle在一个视图树中的焦点状态发生改变时，注册回调接口来获取标题栏的高度
//        ViewTreeObserver vto = llHead.getViewTreeObserver();
//        vto.addOnGlobalLayoutListener(this);
    }

}
