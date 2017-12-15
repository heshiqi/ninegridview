package com.heshiqi.widget.ninegridview.adapter.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by heshiqi on 17/8/8.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    protected Context context;

    public BaseViewHolder(Context context, View itemView) {
        super(itemView);
        this.context = context;
    }

    public void render(T t){}

}
