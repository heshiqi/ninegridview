package com.heshiqi.widget.ninegridview.adapter.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.heshiqi.widget.ninegrid.OnNineGridViewItemClickListener;
import com.heshiqi.widget.ninegridview.R;
import com.heshiqi.widget.ninegridview.entity.MainEntity;
import com.nostra13.universalimageloader.core.ImageLoader;


/**
 * Created by heshiqi on 17/9/13.
 */

public abstract class BasePicTextViewHolder extends BaseViewHolder {

    private ImageView userIcon;
    private TextView userName;
    private TextView publishDate;
    private TextView content;

    public BasePicTextViewHolder(Context context, View itmeView) {
        super(context, itmeView);
        userIcon = (ImageView) itmeView.findViewById(R.id.item_pic_text_user_icon);
        userName = (TextView) itmeView.findViewById(R.id.item_pic_text_username);
        publishDate = (TextView) itmeView.findViewById(R.id.item_pic_text_publish_date);
        content = (TextView) itmeView.findViewById(R.id.item_pic_text_content);
    }


    public void render(MainEntity entity,final OnNineGridViewItemClickListener nineGridViewItemClickListener) {
        //TODO 这里要判断性别
        userName.setText(entity.getAuthor_name());
        publishDate.setText(entity.getPublish_time() + "");
        if (TextUtils.isEmpty(entity.getContent())) {
            content.setVisibility(View.GONE);
        } else {
            content.setText(entity.getContent());
            content.setVisibility(View.VISIBLE);
        }
    }
}
