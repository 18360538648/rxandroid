package com.lsw.rx2retrofit.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Luosiwei on 2017/11/6.
 */

public class GirlBean {
    @SerializedName("results")
    public List<GirlBeanResult> imageBeanList;
}
