package com.victor.gank.main.homePage;

import com.victor.gank.data.main.GankData;

import java.util.ArrayList;

/**
 * Created by Victor on 2018/2/22.
 */

public interface HomePageContract {

    interface HomePageView{
        void showGankData(ArrayList<GankData> gankData);
        void addGankData(ArrayList<GankData> gankData);
        void loadDataComplete();
    }

    interface HomePageModel{
        void getGankDataListData(int page, HomePageCallBack callBack);
    }


    interface HomePageCallBack{
        void getGankDataSuccess(ArrayList<GankData> gankData);
        void getGankDataFail();
        void getGankDataComplete();
    }
}
