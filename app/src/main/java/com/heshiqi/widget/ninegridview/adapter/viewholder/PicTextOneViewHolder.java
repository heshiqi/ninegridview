package com.heshiqi.widget.ninegridview.adapter.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;

import com.heshiqi.widget.ninegrid.AspectRatioImageView;
import com.heshiqi.widget.ninegrid.ImageEntity;
import com.heshiqi.widget.ninegrid.OnNineGridViewItemClickListener;
import com.heshiqi.widget.ninegridview.R;
import com.heshiqi.widget.ninegridview.entity.MainEntity;
import com.heshiqi.widget.ninegridview.utils.ImageOptionsFactory;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;


/**
 * Created by heshiqi on 17/9/13.
 */

public class PicTextOneViewHolder extends BasePicTextViewHolder {
    private AspectRatioImageView imageView;

    public PicTextOneViewHolder(Context context, View itmeView) {
        super(context, itmeView);
        imageView = (AspectRatioImageView) itmeView.findViewById(R.id.item_pic_text_pic);
    }

    public void render(MainEntity entity, final OnNineGridViewItemClickListener nineGridViewItemClickListener) {
        super.render(entity,nineGridViewItemClickListener);
        List<ImageEntity> picModels = entity.getAttachments();
        if (picModels.isEmpty()) {
            imageView.setVisibility(View.GONE);
        } else {
            imageView.setVisibility(View.VISIBLE);
            ImageEntity picModel = picModels.get(0);
            ImageLoader.getInstance().displayImage(picModel.getThumbnail_pic_url(), imageView, ImageOptionsFactory.getDisplayImageOptions(new ColorDrawable(Color.TRANSPARENT)));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (nineGridViewItemClickListener != null) {
                        nineGridViewItemClickListener.onItemClicked(v, getAdapterPosition(), 0);
                    }
                }
            });
        }
    }
}
