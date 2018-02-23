package com.victor.gank.Utils;

import com.victor.gank.Code.Base.ServerApiCall;
import com.victor.gank.Data.Common.Configs;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Victor on 2017/8/2.
 */
public class HttpUtils {

    private static Retrofit sRetrofit;
    private static ServerApiCall sApiCall;

    public static Retrofit getRetrofit() {
        sRetrofit = new Retrofit.Builder().baseUrl(Configs.API_HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        sApiCall = mRetrofit.create(ServerApiCall.class);
        return mRetrofit;
    }

    public static ServerApiCall getApiCall() {
        mApiCall = mRetrofit.create(ServerApiCall.class);
        return mApiCall;
    }
}
