package com.heshiqi.widget.ninegridview.adapter.viewholder;

import android.content.Context;
import android.view.View;


import com.heshiqi.widget.ninegrid.ImageEntity;
import com.heshiqi.widget.ninegrid.NineGridView;
import com.heshiqi.widget.ninegrid.NineGridViewAdapter;
import com.heshiqi.widget.ninegrid.OnNineGridViewItemClickListener;
import com.heshiqi.widget.ninegridview.R;
import com.heshiqi.widget.ninegridview.entity.MainEntity;

import java.util.List;

/**
 * Created by heshiqi on 17/9/13.
 */

public class PicTextNineViewHolder extends BasePicTextViewHolder {
    private NineGridView nineGridView;

    public PicTextNineViewHolder(Context context, View itmeView) {
        super(context, itmeView);
        nineGridView = (NineGridView) itmeView.findViewById(R.id.item_pic_text_ninegrid);
    }

    public void render(MainEntity entity,final OnNineGridViewItemClickListener nineGridViewItemClickListener) {
        super.render(entity, nineGridViewItemClickListener);
        List<ImageEntity> picModels = entity.getAttachments();
        nineGridView.setDatas(picModels);
        nineGridView.setOnItemClickListener(new NineGridViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClicked(View view, int position) {
                if(nineGridViewItemClickListener!=null){
                    nineGridViewItemClickListener.onItemClicked(view,getAdapterPosition(),position);
                }
            }
        });
    }
}
