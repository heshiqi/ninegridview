package com.heshiqi.widget.ninegrid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by heshiqi on 17/9/13.
 */
public class NineGridViewAdapter extends RecyclerView.Adapter<NineGridViewAdapter.NineGridViewHolder> {

    private static final String TAG="NineGridViewAdapter";

    private Context context;
    private LayoutInflater inflater;
    private List<ImageEntity> datas = new ArrayList<>();

    public NineGridViewAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClicked(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setDatas(List<ImageEntity> datas) {
        this.datas.clear();
        this.datas.addAll(datas);
    }

    @Override
    public NineGridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_nine_grid_pic, parent, false);
        return new NineGridViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final NineGridViewHolder holder, int position) {
        ImageEntity picModel = getItem(position);
        if (picModel == null) {
            return;
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClicked(holder.itemView, holder.getAdapterPosition());
                }
            }
        });
        holder.render(picModel);
    }

    public ImageEntity getItem(int position) {
        int size = datas.size();
        if (size == 0 || position < 0 || position >= size) {
            return null;
        }
        return datas.get(position);
    }


    @Override
    public int getItemCount() {
        return datas.size();
    }

    public static class NineGridViewHolder extends RecyclerView.ViewHolder {

        private AspectRatioImageView imageView;

        public NineGridViewHolder(View itemView) {
            super(itemView);
            imageView = (AspectRatioImageView) itemView.findViewById(R.id.nine_gird_image);
        }

        public void render(ImageEntity picModel) {
            ImageLoader.getInstance().displayImage(picModel.getThumbnail_pic_url(), imageView, getDisplayImageOptions(new ColorDrawable(Color.parseColor("#88cccccc"))));
        }
    }

    public static final DisplayImageOptions getDisplayImageOptions(Drawable placeholderImage){
        DisplayImageOptions options = getBaseDisplayImageOptionsBuilder()
                .showImageOnFail(placeholderImage)
                .showImageOnLoading(placeholderImage)
                .showImageForEmptyUri(placeholderImage)
                .build();
        return  options;
    }

    private static final DisplayImageOptions.Builder getBaseDisplayImageOptionsBuilder(){
        DisplayImageOptions.Builder builder= new DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .considerExifParams(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .imageScaleType(ImageScaleType.IN_SAMPLE_INT);
        return builder;
    }
}
