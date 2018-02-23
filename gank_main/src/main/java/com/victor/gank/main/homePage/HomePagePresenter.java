package com.victor.gank.main.homePage;

import com.victor.gank.common.base.BasePresenter;
import com.victor.gank.data.main.GankData;

import java.util.ArrayList;

/**
 * Created by Victor on 2018/2/22.
 */
public class HomePagePresenter extends BasePresenter<HomePageContract.HomePageView> {

    private HomePageImpl mHomePageImpl;
    private int mGankDataListPage = 0;

    public HomePagePresenter() {
        mHomePageImpl = new HomePageImpl();
    }

    public void initDataState(){
        mGankDataListPage = 0;
    }

    public void getGankDataListData(){
        mHomePageImpl.getGankDataListData(mGankDataListPage, new HomePageContract.HomePageCallBack() {
            @Override
            public void getGankDataSuccess(ArrayList<GankData> gankData) {
                if (mGankDataListPage > 1){
                    getView().addGankData(gankData);
                } else {
                    getView().showGankData(gankData);
                }
            }

            @Override
            public void getGankDataFail() {

            }

            @Override
            public void getGankDataComplete() {
                getView().loadDataComplete();
            }
        });
    }

    public void loadMoreGankDataListData(){
        mGankDataListPage ++;
        getGankDataListData();
    }
}
