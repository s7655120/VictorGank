//package com.victor.gank.main.homePage;
//
//import android.os.Bundle;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewStub;
//
//import com.scwang.smartrefresh.layout.api.RefreshLayout;
//import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
//import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
//import com.victor.gank.common.base.BaseFragment;
//import com.victor.gank.data.main.GankData;
//import com.victor.gank.main.R;
//
//import java.util.ArrayList;
//
///**
// * Created by Victor on 2018/2/23.
// */
//
///**
// * 首页Fragment
// * 用于按日期展示列表
// * Created by Victor on 2018/2/22.
// */
//public class HomePageFragment2 extends BaseFragment<HomePageContract.HomePageView, HomePagePresenter>
//        implements HomePageContract.HomePageView, OnRefreshListener, OnLoadMoreListener {
//
//    private RefreshLayout mRefreshLayout;
//    private RecyclerView mRvHomePage;
//    private HomePageAdapter mHomePageAdapter;
//
//    @Override
//    protected HomePagePresenter createPresenter() {
//        return new HomePagePresenter();
//    }
//
//    @Override
//    protected View initFragmentView(LayoutInflater inflater) {
//        return inflater.inflate(R.layout.home_page, null);
//    }
//
//    @Override
//    protected void initFragmentChildView(View view) {
//        ViewStub sampleStub = view.findViewById(R.id.sampleStub);
//        sampleStub.setLayoutResource(R.layout.fragment_home_page);
//        sampleStub.inflate();
//
//        mRefreshLayout = view.findViewById(R.id.refreshLayout);
//        mRvHomePage = view.findViewById(R.id.recyclerview);
//        mRvHomePage.setLayoutManager(new LinearLayoutManager(getActivity()));
//        mHomePageAdapter = new HomePageAdapter();
//        mRvHomePage.setAdapter(mHomePageAdapter);
//    }
//
//    @Override
//    protected void initViewListener() {
//        mRefreshLayout.setOnRefreshListener(this);
//        mRefreshLayout.setOnLoadMoreListener(this);
//    }
//
//    @Override
//    protected void initFragmentData(Bundle savedInstanceState) {
//        mRefreshLayout.autoRefresh();
//    }
//
//    @Override
//    public void onRefresh(RefreshLayout refreshLayout) {
//        mPresenter.getGankDataListData();
//    }
//
//    @Override
//    public void onLoadMore(RefreshLayout refreshLayout) {
//
//    }
//
//    @Override
//    public void showGankData(ArrayList<GankData> gankData) {
//        long mCurrentTime = System.currentTimeMillis();
//        Log.e("test", "1 onViewCreated mCurrentTime = " + mCurrentTime);
//        mHomePageAdapter.addData(gankData);
//    }
//
//    @Override
//    public void loadDataComplete() {
//        mRefreshLayout.finishRefresh();
//        mRefreshLayout.finishLoadMore();
//    }
//}
//
