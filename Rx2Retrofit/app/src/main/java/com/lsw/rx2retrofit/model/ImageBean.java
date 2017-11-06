package com.lsw.rx2retrofit.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Luosiwei on 2017/11/6.
 */

public class ImageBean {
    // 图片描述
    @SerializedName("description")
    private String desc;
    // 图片地址
    @SerializedName("image_url")
    private String imageUrl;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
