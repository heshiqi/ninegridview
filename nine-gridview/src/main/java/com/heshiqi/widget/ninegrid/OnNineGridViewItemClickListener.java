package com.heshiqi.widget.ninegrid;

import android.view.View;

/**
 * Created by heshiqi on 17/9/18.
 * 九宫格item点击事件
 */

public interface OnNineGridViewItemClickListener {

    void onItemClicked(View view, int parentPosition, int position);

}
