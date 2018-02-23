package com.victor.gank.main.homePage;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.victor.gank.common.base.BaseFragment;
import com.victor.gank.data.main.GankData;
import com.victor.gank.main.R;

import java.util.ArrayList;

/**
 * 首页Fragment
 * 用于按日期展示列表
 * Created by Victor on 2018/2/22.
 */
public class HomePageFragment extends BaseFragment<HomePageContract.HomePageView, HomePagePresenter>
        implements HomePageContract.HomePageView, OnRefreshListener, OnLoadMoreListener {

    private RefreshLayout mRefreshLayout;
    private RecyclerView mRvHomePage;
    private HomePageAdapter mHomePageAdapter;

    @Override
    protected HomePagePresenter createPresenter() {
        return new HomePagePresenter();
    }

    @Override
    protected View initFragmentView(LayoutInflater inflater) {
        return inflater.inflate(R.layout.fragment_home_page, null);
    }

    @Override
    protected void initFragmentChildView(View view) {
        mRefreshLayout = view.findViewById(R.id.refreshLayout);
        mRvHomePage = view.findViewById(R.id.recyclerview);
        mRvHomePage.setLayoutManager(new LinearLayoutManager(getActivity()));
        mHomePageAdapter = new HomePageAdapter();
        mRvHomePage.setAdapter(mHomePageAdapter);
    }
    @Override
    protected void initViewListener() {
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.setOnLoadMoreListener(this);
        mRvHomePage.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
    }

    @Override
    protected void initFragmentData(Bundle savedInstanceState) {
        mRefreshLayout.autoRefresh();
    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        mPresenter.initDataState();
        mPresenter.getGankDataListData();
    }

    @Override
    public void onLoadMore(RefreshLayout refreshLayout) {
        mPresenter.loadMoreGankDataListData();
    }

    @Override
    public void showGankData(ArrayList<GankData> gankData) {
        mHomePageAdapter.setNewData(gankData);
    }

    @Override
    public void addGankData(ArrayList<GankData> gankData) {
        mHomePageAdapter.addData(gankData);
    }

    @Override
    public void loadDataComplete() {
        mRefreshLayout.finishRefresh();
        mRefreshLayout.finishLoadMore();
    }
}
