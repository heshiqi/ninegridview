package com.heshiqi.widget.ninegridview.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/**
 * 屏幕分辨率转换工具
 *
 * @author heshiqi
 */
public class ScreenUtil {

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px
     */
    public static int dp2Px(Context context, int dp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics) + 0.5f);
    }

}
