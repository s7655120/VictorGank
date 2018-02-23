package com.victor.gank.Code.Welfare.WelfareList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.victor.gank.Code.Base.BaseActivity;
import com.victor.gank.Data.Welfare.Welfare;
import com.victor.gank.R;

import java.util.ArrayList;

/**
 * 福利列表界面
 * Created by Victor on 2017/7/31.
 */
public class WelfareListActivity extends BaseActivity implements WelfareListContract.View, OnRefreshListener, OnLoadmoreListener {

    private WelfareListPresenter mWelfareListPresenter;
    private RefreshLayout mRefreshLayout;
    private RecyclerView mRvWelfareList;
    private WelfareListAdapter mWelfareListAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welfare_list);
        mWelfareListPresenter = new WelfareListPresenter(this);
        mWelfareListPresenter.start();
    }

    @Override
    public void initViews() {
        mRefreshLayout = (RefreshLayout) findViewById(R.id.refreshLayout);
        mRvWelfareList = (RecyclerView) findViewById(R.id.recyclerview);
        mRvWelfareList.setLayoutManager(new LinearLayoutManager(this));
        mWelfareListAdapter = new WelfareListAdapter();
        mRvWelfareList.setAdapter(mWelfareListAdapter);
    }

    @Override
    public void initListeners() {
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.setOnLoadmoreListener(this);
    }

    @Override
    public void initData() {
        mRefreshLayout.autoRefresh();
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
//        refreshlayout.finishRefresh(2000);
        mWelfareListPresenter.initDataState();
        mWelfareListPresenter.getWelfareListData();
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
//        refreshlayout.finishLoadmore(2000);
    }

    @Override
    public void showWelfareList(ArrayList<Welfare> welfares) {
        mWelfareListAdapter.setNewData(welfares);
    }

    @Override
    public void loadDataComplete() {
        mRefreshLayout.finishRefresh();
        mRefreshLayout.finishLoadmore();
    }

    @Override
    public void showToast(@StringRes int toastId) {
    }

    @Override
    public void showToast(String content) {
    }


}
