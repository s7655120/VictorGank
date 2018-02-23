package com.victor.gank.Code.Main.HomePage;

import com.victor.gank.Code.Base.BasePresenter;
import com.victor.gank.Code.Base.BaseView;
import com.victor.gank.Data.Main.HomePage.GankData;

import java.util.ArrayList;

/**
 * Created by Victor on 2017/8/2.
 */
public interface HomePageContract {
    interface View extends BaseView<Presenter> {
        void loadDataComplete();
        void showGankDataList(ArrayList<GankData> GankDataList);
    }
    interface Presenter extends BasePresenter {
        void getGankDataListData();
    }
}
