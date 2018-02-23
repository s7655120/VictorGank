package com.victor.gank.Code.Welfare.WelfareList;

import com.victor.gank.Code.Base.ServerApiCall;
import com.victor.gank.Data.Common.Configs;
import com.victor.gank.Data.Welfare.Welfare;
import com.victor.gank.Data.Welfare.WelfareList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Victor on 2017/7/31.
 */
public class WelfareListPresenter implements WelfareListContract.Presenter {

    private WelfareListContract.View mWelfareListView;
    private Retrofit mRetrofit;
    private ServerApiCall mApiCall;
    private int mWelfareListPage = 0;                                     // 福利列表界面

    public WelfareListPresenter(WelfareListContract.View view) {
        mWelfareListView = view;
        getRetrofit();
    }

    private Retrofit getRetrofit() {
        mRetrofit = new Retrofit.Builder().baseUrl(Configs.API_HOST)
                .addConverterFactory(GsonConverterFactory.create()).build();
        mApiCall = mRetrofit.create(ServerApiCall.class);
        return mRetrofit;
    }

    @Override
    public void start() {
        mWelfareListView.initViews();
        mWelfareListView.initListeners();
        mWelfareListView.initData();
    }

    @Override
    public void initDataState() {

    }

    @Override
    public void getWelfareListData() {
        Call<WelfareList> call = mApiCall.getWelfareList(Configs.COMMON_PAGE_SIZE, mWelfareListPage);
        call.enqueue(new Callback<WelfareList>() {
            @Override
            public void onResponse(Call<WelfareList> call, Response<WelfareList> response) {
                ArrayList<Welfare> welfares = response.body().getResults();
                mWelfareListView.showWelfareList(welfares);
                mWelfareListView.loadDataComplete();
            }

            @Override
            public void onFailure(Call<WelfareList> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public void loadWelfareListData() {

    }

    @Override
    public void end() {

    }
}
