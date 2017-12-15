package com.heshiqi.widget.ninegridview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.heshiqi.widget.ninegrid.OnNineGridViewItemClickListener;
import com.heshiqi.widget.ninegridview.R;
import com.heshiqi.widget.ninegridview.adapter.viewholder.BasePicTextViewHolder;
import com.heshiqi.widget.ninegridview.adapter.viewholder.BaseViewHolder;
import com.heshiqi.widget.ninegridview.adapter.viewholder.PicTextNineViewHolder;
import com.heshiqi.widget.ninegridview.adapter.viewholder.PicTextOneViewHolder;
import com.heshiqi.widget.ninegridview.core.contract.MainContract;
import com.heshiqi.widget.ninegridview.entity.MainEntity;
import com.heshiqi.widget.ninegridview.utils.ScreenUtil;

/**
 * Created by heshiqi on 17/5/3.
 */
public class NinePicAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    static final int TYPE_PIC_ONE = 0;//一张图类型
    static final int TYPE_PIC_NINE = 1;//9张图类型
    static final int TYPE_VIEW_COUNT = 2;//view 的类型总数

    private static final String TAG = "LiveListAdapter";
    private Context context;
    private LayoutInflater inflater;
    private MainContract.Presenter presenter;
    private OnNineGridViewItemClickListener nineGridViewItemClickListener;

    private int screenWidth;

    public NinePicAdapter(Context context, MainContract.Presenter presenter, OnNineGridViewItemClickListener nineGridViewItemClickListener) {
        this.context = context;
        this.presenter = presenter;
        inflater = LayoutInflater.from(context);
        this.nineGridViewItemClickListener = nineGridViewItemClickListener;
        screenWidth = context.getResources().getDisplayMetrics().widthPixels;

    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BasePicTextViewHolder baseViewHolder = null;
        switch (viewType) {
            case TYPE_PIC_ONE:
                View viewOne = inflater.inflate(R.layout.item_pic_text_one, parent, false);
//                viewOne.setBackgroundResource(R.drawable.live_list_item_selector);
                View imageView = viewOne.findViewById(R.id.item_pic_text_pic);
                imageView.getLayoutParams().width = (screenWidth - ScreenUtil.dp2Px(context, 30)) * 2 / 3;
                baseViewHolder = new PicTextOneViewHolder(context, viewOne);
                break;
            case TYPE_PIC_NINE:
            default:
                View viewNine = inflater.inflate(R.layout.item_pic_text_nine, parent, false);
//                viewNine.setBackgroundResource(R.drawable.live_list_item_selector);
                baseViewHolder = new PicTextNineViewHolder(context, viewNine);
                break;
        }
        return baseViewHolder;
    }


    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        MainEntity entity = getItem(position);
        if (entity != null) {
            ((BasePicTextViewHolder) holder).render(entity, nineGridViewItemClickListener);
        }
    }

    @Override
    public int getItemViewType(int position) {
        MainEntity entity = getItem(position);
        int picSize = entity.getAttachments().size();
        if (picSize == 0 || picSize == 1) {
            return TYPE_PIC_ONE;
        } else {
            return TYPE_PIC_NINE;
        }
    }

    @Override
    public int getItemCount() {
        return presenter.getDatas().size();
    }

    public MainEntity getItem(int position) {
        return presenter.getItem(position);
    }

}
