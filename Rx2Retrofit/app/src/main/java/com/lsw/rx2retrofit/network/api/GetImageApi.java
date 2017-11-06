package com.lsw.rx2retrofit.network.api;

import com.lsw.rx2retrofit.model.ImageBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Luosiwei on 2017/11/6.
 */

public interface GetImageApi {
    @GET("search")
    Observable<List<ImageBean>> search(@Query("q") String query);
}
