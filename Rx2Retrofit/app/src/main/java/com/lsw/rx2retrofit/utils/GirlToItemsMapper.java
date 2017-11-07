package com.lsw.rx2retrofit.utils;

import com.lsw.rx2retrofit.model.GirlBean;
import com.lsw.rx2retrofit.model.GirlBeanResult;
import com.lsw.rx2retrofit.model.Item;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Map工具类 将获取到的结果类型转为另外一种数据类型
 * Created by Luosiwei on 2017/11/7.
 */

public class GirlToItemsMapper implements Function<GirlBean, List<Item>> {
    private static GirlToItemsMapper INSTANCE = new GirlToItemsMapper();

    public static GirlToItemsMapper getInstance() {
        return INSTANCE;
    }

    @Override
    public List<Item> apply(@NonNull GirlBean girlBean) throws Exception {
        List<GirlBeanResult> imageBeanList = girlBean.imageBeanList;
        List<Item> itemList = new ArrayList<>(imageBeanList.size());
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SS'Z'");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
        for (GirlBeanResult girlBeanResult : imageBeanList) {
            Item item = new Item();
            try {
                Date date = inputFormat.parse(girlBeanResult.createdAt);
                item.description = outputFormat.format(date);
            } catch (ParseException e) {
                e.printStackTrace();
                item.description = "unknown date";
            }
            itemList.add(item);
        }
        return itemList;
    }
}
