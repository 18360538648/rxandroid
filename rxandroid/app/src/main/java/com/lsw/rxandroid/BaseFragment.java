package com.lsw.rxandroid;

import android.support.v4.app.Fragment;

import rx.Subscription;

/**
 * Created by Luosiwei on 2017/8/18.
 */

public class BaseFragment extends Fragment {
    private Subscription subscription;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (null != subscription && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
