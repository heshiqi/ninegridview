package com.heshiqi.widget.ninegrid;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;


import java.util.List;

/**
 * Created by heshiqi on 17/9/13.
 * 9宫格布局
 */

public class NineGridView extends RecyclerView {

    static final int GRID_SPAN_COUNT = 3;

    private NineGridViewAdapter adapter;
    private GridLayoutManager layoutManager;

    public NineGridView(@NonNull Context context) {
        this(context, null);
    }

    public NineGridView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NineGridView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        addItemDecoration(new GridDividerItemDecoration(dp2Px(context, 3), false));
        adapter = new NineGridViewAdapter(context);
        layoutManager = new GridLayoutManager(context, GRID_SPAN_COUNT);
        setLayoutManager(layoutManager);
        setAdapter(adapter);
        setNestedScrollingEnabled(false);
    }

    /**
     * 设置九宫格item点击事件
     *
     * @param onItemClickListener
     */
    public void setOnItemClickListener(NineGridViewAdapter.OnItemClickListener onItemClickListener) {
        if (adapter != null) {
            adapter.setOnItemClickListener(onItemClickListener);
        }
    }

    /**
     * 设置9宫格显示的图片数据
     *
     * @param datas
     */
    public void setDatas(List<ImageEntity> datas) {
        if (datas.size() == 4 || datas.size() == 2) {
            layoutManager.setSpanCount(2);
        } else {
            layoutManager.setSpanCount(3);
        }
        adapter.setDatas(datas);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        final int widthSize = getDefaultSize(0, widthSpec);
        if (layoutManager.getSpanCount() == 2) {
            widthSpec = View.MeasureSpec.makeMeasureSpec(widthSize / 3 * 2, View.MeasureSpec.EXACTLY);
        }
        super.onMeasure(widthSpec, heightSpec);
    }

    public static int dp2Px(Context context, int dp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics) + 0.5f);
    }
}
