package com.lsw.rx2retrofit;

import android.app.Application;

/**
 * Created by Luosiwei on 2017/10/27.
 */

public class MyApplication extends Application {
    private static MyApplication myApplication;

    public static MyApplication getInstance() {
        return myApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
    }
}
