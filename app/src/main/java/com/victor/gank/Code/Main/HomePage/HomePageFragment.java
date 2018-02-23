package com.victor.gank.Code.Main.HomePage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.victor.gank.Code.Base.BaseFragment;
import com.victor.gank.Data.Main.HomePage.GankData;
import com.victor.gank.R;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Victor on 2017/8/2.
 */
public class HomePageFragment extends BaseFragment implements HomePageContract.View, OnRefreshListener, OnLoadmoreListener {

    private View mRootView;
    private HomePagePresenter mHomePagePresenter;

    private RefreshLayout mRefreshLayout;
    private RecyclerView mRvHomePage;
    private HomePageAdapter mHomePageAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (mRootView != null && mRootView.getParent() != null) {
            ((ViewGroup) mRootView.getParent()).removeView(mRootView);
        } else {
            mRootView = inflater.inflate(R.layout.fragment_home_page, null);
//            parserArgument();
            mHomePagePresenter = new HomePagePresenter(this);
            mHomePagePresenter.start();
        }
        return mRootView;
    }

    @Override
    public void initViews() {
        mRefreshLayout = (RefreshLayout) mRootView.findViewById(R.id.refreshLayout);
        mRvHomePage = (RecyclerView) mRootView.findViewById(R.id.recyclerview);
        mRvHomePage.setLayoutManager(new LinearLayoutManager(mContext));
        mHomePageAdapter = new HomePageAdapter();
        mRvHomePage.setAdapter(mHomePageAdapter);

//        String str = "<font color=\"\" style=\"padding-left:10px\">【搜图令】这里是一段文本</font></a></h1> ";
//        Pattern p = Pattern.compile(".*<font.*>(.*)</font>.*");
//        String result = "";
//
//        Matcher m = p.matcher(str);
//        if(m.find()) {
//        }
//        System.out.println(result);
//
//        Log.e("test","result = " + result);
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
    public void showToast(@StringRes int toastId) {

    }

    @Override
    public void showToast(String content) {

    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {

    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        mHomePagePresenter.getGankDataListData();
    }

    @Override
    public void loadDataComplete() {
        mRefreshLayout.finishRefresh();
        mRefreshLayout.finishLoadmore();
    }

    @Override
    public void showGankDataList(ArrayList<GankData> GankDataList) {
        mHomePageAdapter.setNewData(GankDataList);
    }
}
