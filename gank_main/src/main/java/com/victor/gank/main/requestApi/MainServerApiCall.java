package com.victor.gank.main.requestApi;

import com.victor.gank.data.main.GankDataList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Victor on 2018/2/23.
 */
public interface MainServerApiCall {

    @GET("history/content/{count}/{page}")
    Observable<GankDataList> getGankDataList(@Path("count") int count, @Path("page") int page);
}
