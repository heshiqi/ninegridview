package com.heshiqi.widget.ninegrid;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;


/**
 * Created by heshiqi on 17/9/13.
 * <p>
 * 设置宽度与高度的纵横比ImageView
 */

public class AspectRatioImageView extends android.support.v7.widget.AppCompatImageView {

    //以下这些属性要与AspectRatioImageView attributes attrs.xml中保持一致
    public static final int MEASUREMENT_WIDTH = 0;
    public static final int MEASUREMENT_HEIGHT = 1;

    private static final float DEFAULT_ASPECT_RATIO = 1f;
    private static final boolean DEFAULT_ASPECT_RATIO_ENABLED = false;
    private static final int DEFAULT_DOMINANT_MEASUREMENT = MEASUREMENT_WIDTH;

    private float aspectRatio;
    private boolean aspectRatioEnabled;
    private int dominantMeasurement;

    public AspectRatioImageView(Context context) {
        this(context, null);
    }

    public AspectRatioImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AspectRatioImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AspectRatioImageView);
        aspectRatio = a.getFloat(R.styleable.AspectRatioImageView_aspectRatio, DEFAULT_ASPECT_RATIO);
        aspectRatioEnabled = a.getBoolean(R.styleable.AspectRatioImageView_aspectRatioEnabled,
                DEFAULT_ASPECT_RATIO_ENABLED);
        dominantMeasurement = a.getInt(R.styleable.AspectRatioImageView_dominantMeasurement,
                DEFAULT_DOMINANT_MEASUREMENT);
        a.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (!aspectRatioEnabled) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        final int widthSize = getDefaultSize(0,widthMeasureSpec);
        final int heightSize = getDefaultSize(0,heightMeasureSpec);
        int newWidth = 0;
        int newHeight = 0;
        switch (dominantMeasurement) {
            case MEASUREMENT_WIDTH:
                newWidth = widthSize;
                newHeight = (int) (newWidth * aspectRatio);
                break;

            case MEASUREMENT_HEIGHT:
                newHeight = heightSize;
                newWidth = (int) (newHeight * aspectRatio);
                break;
        }
        int widthSpec = MeasureSpec.makeMeasureSpec(newWidth, MeasureSpec.EXACTLY);
        int heightSpec = MeasureSpec.makeMeasureSpec(newHeight, MeasureSpec.EXACTLY);
        super.onMeasure(widthSpec, heightSpec);
    }

    /**
     * 获取控件的显示比例
     *
     * @return
     */
    public float getAspectRatio() {
        return aspectRatio;
    }

    /**
     * 设置控件的显示比例值
     *
     * @param aspectRatio
     */
    public void setAspectRatio(float aspectRatio) {
        this.aspectRatio = aspectRatio;
        if (aspectRatioEnabled) {
            requestLayout();
        }
    }

    /**
     * 获取控件是否支持比例显示
     *
     * @return
     */
    public boolean getAspectRatioEnabled() {
        return aspectRatioEnabled;
    }

    /**
     * 设置控件是否支持比例显示
     *
     * @param aspectRatioEnabled
     */
    public void setAspectRatioEnabled(boolean aspectRatioEnabled) {
        this.aspectRatioEnabled = aspectRatioEnabled;
        requestLayout();
    }

    /**
     * 获取控件在进行纵横比测量时的参考类型
     * {@link #MEASUREMENT_WIDTH} 以控件宽度为基准点
     * or
     * {@link #MEASUREMENT_HEIGHT} 以控件高度为基准点
     *
     * @return
     */
    public int getDominantMeasurement() {
        return dominantMeasurement;
    }

    /**
     * 设置控件在进行纵横比测量时的基准点值
     *
     * @see #MEASUREMENT_WIDTH
     * @see #MEASUREMENT_HEIGHT
     */
    public void setDominantMeasurement(int dominantMeasurement) {
        if (dominantMeasurement != MEASUREMENT_HEIGHT && dominantMeasurement != MEASUREMENT_WIDTH) {
            throw new IllegalArgumentException("未知参数  请选择 AspectRatioImageView#MEASUREMENT_HEIGHT 或者 AspectRatioImageView#MEASUREMENT_WIDTH");
        }
        this.dominantMeasurement = dominantMeasurement;
        requestLayout();
    }
}
