package com.victor.gank.Code.Base;

import com.victor.gank.Data.Main.HomePage.GankDataList;
import com.victor.gank.Data.Welfare.WelfareList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Victor on 2017/7/31.
 */
public interface ServerApiCall {

    @GET("data/福利/{count}/{page}")
    Call<WelfareList> getWelfareList(@Path("count") int count, @Path("page") int page);


    @GET("history/content/{count}/{page}")
    Call<GankDataList> getGankDataList(@Path("count") int count, @Path("page") int page);
}
