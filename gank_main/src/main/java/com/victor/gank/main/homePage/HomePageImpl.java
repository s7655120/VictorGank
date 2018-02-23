package com.victor.gank.main.homePage;

import android.util.Log;

import com.victor.gank.data.common.Configs;
import com.victor.gank.data.main.GankData;
import com.victor.gank.data.main.GankDataList;
import com.victor.gank.http.HttpUtils;
import com.victor.gank.main.requestApi.MainServerApiCall;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Victor on 2018/2/22.
 */
public class HomePageImpl implements HomePageContract.HomePageModel {

    private Retrofit mRetrofit;
    private MainServerApiCall mApiCall;
    private int mGankDataListPage = 0;                                     // 福利列表界面

    public HomePageImpl() {
        mRetrofit = HttpUtils.getRetrofit();
        mApiCall = mRetrofit.create(MainServerApiCall.class);
    }


    @Override
    public void getGankDataListData(int page, final HomePageContract.HomePageCallBack callBack) {
        Log.e("test", "getGankDataListData : d = " );
        mApiCall.getGankDataList(Configs.COMMON_PAGE_SIZE, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GankDataList>(){

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("test", "onSubscribe : d = " + d);
                    }

                    @Override
                    public void onNext(GankDataList gankDataList) {
                        ArrayList<GankData> gankData = gankDataList.getResults();
                        if (gankData != null && gankData.size() > 0){
                            callBack.getGankDataSuccess(gankData);
                        } else {
                            callBack.getGankDataFail();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("test", "onError : d = " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        callBack.getGankDataComplete();
                    }
                });


//        observable.enqueue(new SortedList.Callback<GankDataList>() {
//            @Override
//            public void onResponse(Call<GankDataList> call, Response<GankDataList> response) {
//                ArrayList<GankData> gankData = response.body().getResults();
//                mHomePageView.showGankDataList(gankData);
//                mHomePageView.loadDataComplete();
//            }
//
//            @Override
//            public void onFailure(Call<GankDataList> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });
    }
}
