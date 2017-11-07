package com.lsw.rx2retrofit.network.api;

import com.lsw.rx2retrofit.model.GirlBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Luosiwei on 2017/11/6.
 */

public interface GetGirlMapApi {
//    @GET("data/福利/{number}/{page}")
//    Observable<GirlBean> getGirl(@Path("number") int number, @Path("page") int page);
    @GET("data/福利/{number}/{page}")
    Observable<GirlBean> getGirl(@Path("number") int number, @Path("page") int page);
}
