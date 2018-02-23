package com.victor.gank.Code.Main.HomePage;

import com.victor.gank.Code.Base.ServerApiCall;
import com.victor.gank.Data.Common.Configs;
import com.victor.gank.Data.Main.HomePage.GankData;
import com.victor.gank.Data.Main.HomePage.GankDataList;
import com.victor.gank.Data.Welfare.Welfare;
import com.victor.gank.Data.Welfare.WelfareList;
import com.victor.gank.Utils.HttpUtils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Victor on 2017/8/2.
 */

public class HomePagePresenter implements HomePageContract.Presenter {

    private HomePageContract.View mHomePageView;
    private Retrofit mRetrofit;
    private ServerApiCall mApiCall;
    private int mWelfareListPage = 0;                                     // 福利列表界面

    public HomePagePresenter(HomePageContract.View view) {
        this.mHomePageView = view;
        mRetrofit = HttpUtils.getRetrofit();
        mApiCall = HttpUtils.getApiCall();
    }

    @Override
    public void start() {
        mHomePageView.initViews();
        mHomePageView.initListeners();
        mHomePageView.initData();
    }

    @Override
    public void getGankDataListData() {
        Call<GankDataList> call = mApiCall.getGankDataList(Configs.COMMON_PAGE_SIZE, mWelfareListPage);
        call.enqueue(new Callback<GankDataList>() {
            @Override
            public void onResponse(Call<GankDataList> call, Response<GankDataList> response) {
                ArrayList<GankData> gankData = response.body().getResults();
                mHomePageView.showGankDataList(gankData);
                mHomePageView.loadDataComplete();
            }

            @Override
            public void onFailure(Call<GankDataList> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }


    @Override
    public void end() {

    }
}
