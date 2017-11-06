package com.lsw.rx2retrofit.module;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Toast;

import com.lsw.rx2retrofit.BaseFragment;
import com.lsw.rx2retrofit.R;
import com.lsw.rx2retrofit.adapter.ImageAdapter;
import com.lsw.rx2retrofit.model.ImageBean;
import com.lsw.rx2retrofit.network.Network;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Luosiwei on 2017/10/27.
 */

public class ElementaryFragment extends BaseFragment {
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.gridRv)
    RecyclerView gridRv;
    ImageAdapter imageAdapter;
    private List<ImageBean> imageBeanList = new ArrayList<>();

    @Override
    protected int getDialogRes() {
        return R.layout.fragment_elementary;
    }

    @Override
    protected int getTitleRes() {
        return R.string.title_elementary;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_elementary, container, false);
        ButterKnife.bind(this, view);
        imageAdapter = new ImageAdapter(imageBeanList, getContext());
        gridRv.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        gridRv.setAdapter(imageAdapter);
        swipeRefreshLayout.setRefreshing(false);
        return view;
    }

    @OnCheckedChanged({R.id.searchRb1, R.id.searchRb2, R.id.searchRb3, R.id.searchRb4})
    void onTagChecked(RadioButton searchRb, boolean checked) {
        if (checked) {
            // ???
            unSubscribe();
            swipeRefreshLayout.setRefreshing(true);
            search(searchRb.getText().toString());
        }
    }

    /**
     * 搜索RaidoButton对应的图片
     *
     * @param key
     */
    public void search(String key) {
        disposable = Network.getImageApi()
                .search(key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<ImageBean>>() {
                    @Override
                    public void accept(@NonNull List<ImageBean> imageBeen) throws Exception {
                        swipeRefreshLayout.setRefreshing(false);
                        imageBeanList.clear();
                        for (ImageBean imageBeans : imageBeen) {
                            imageBeanList.add(imageBeans);
                        }
                        imageAdapter.notifyDataSetChanged();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        swipeRefreshLayout.setRefreshing(false);
                        Toast.makeText(getContext(), "加载数据异常", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
