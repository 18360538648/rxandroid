package com.lsw.rx2retrofit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lsw.rx2retrofit.R;
import com.lsw.rx2retrofit.model.ImageBean;

import java.util.List;

/**
 * 图片显示适配器
 * Created by Luosiwei on 2017/11/6.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    private List<ImageBean> mImageBeanList;
    private Context mContext;

    public ImageAdapter(List<ImageBean> imageBeanList, Context context) {
        this.mImageBeanList = imageBeanList;
        this.mContext = context;
    }


    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        ImageBean imageBean = mImageBeanList.get(position);
        holder.descriptionTv.setText(imageBean.getDesc());
        Glide.with(mContext).load(imageBean.getImageUrl()).into(holder.imageIv);
    }


    @Override
    public int getItemCount() {
        return mImageBeanList.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        // 图片描述
        public TextView descriptionTv;
        // 图片显示
        public ImageView imageIv;

        public ImageViewHolder(View itemView) {
            super(itemView);
            descriptionTv = itemView.findViewById(R.id.descriptionTv);
            imageIv = itemView.findViewById(R.id.imageIv);
        }
    }

}
