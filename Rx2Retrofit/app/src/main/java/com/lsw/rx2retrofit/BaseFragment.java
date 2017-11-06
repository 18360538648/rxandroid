package com.lsw.rx2retrofit;

import android.app.AlertDialog;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.OnClick;
import io.reactivex.disposables.Disposable;

/**
 * Created by Luosiwei on 2017/10/27.
 */

public abstract class BaseFragment extends Fragment {
    protected Disposable disposable;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick(R.id.tipBt)
    void tip() {
        new AlertDialog.Builder(getActivity())
                .setTitle(getTitleRes())
                .setView(getActivity().getLayoutInflater().inflate(getDialogRes(), null))
                .show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unSubscribe();
    }

    /**
     * 注销Disposable
     */
    protected void unSubscribe() {
        if (null != disposable && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    protected abstract int getDialogRes();

    protected abstract int getTitleRes();
}
