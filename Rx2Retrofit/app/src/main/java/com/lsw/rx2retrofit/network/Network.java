package com.lsw.rx2retrofit.network;

import com.lsw.rx2retrofit.network.api.GetGirlMapApi;
import com.lsw.rx2retrofit.network.api.GetImageApi;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Luosiwei on 2017/11/6.
 */

public class Network {
    private static GetImageApi getImageApi;
    private static GetGirlMapApi getGirlMapApi;
    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static Converter.Factory gsonConvertFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaFactory = RxJava2CallAdapterFactory.create();

    public static GetImageApi getImageApi() {
        if (getImageApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://www.zhuangbi.info/")
                    .addConverterFactory(gsonConvertFactory)
                    .addCallAdapterFactory(rxJavaFactory)
                    .client(okHttpClient)
                    .build();
            getImageApi = retrofit.create(GetImageApi.class);
        }
        return getImageApi;
    }

    public static GetGirlMapApi getGirlMapApi() {
        if (getGirlMapApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://gank.io/api/")
                    .client(okHttpClient)
                    .addCallAdapterFactory(rxJavaFactory)
                    .addConverterFactory(gsonConvertFactory)
                    .build();
            getGirlMapApi = retrofit.create(GetGirlMapApi.class);
        }
        return getGirlMapApi;
    }
}

