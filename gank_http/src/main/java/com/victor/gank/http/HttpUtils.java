package com.victor.gank.http;

import com.victor.gank.data.common.Configs;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Victor on 2017/8/2.
 */
public class HttpUtils {

    private static Retrofit sRetrofit;

    public static Retrofit getRetrofit() {
        sRetrofit = new Retrofit.Builder().baseUrl(Configs.API_HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return sRetrofit;
    }
}
