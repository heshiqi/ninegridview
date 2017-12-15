package com.heshiqi.widget.ninegridview.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;


/**
 * Created by hsq on 2016/5/20.
 */
public class ImageOptionsFactory {

    public static final DisplayImageOptions getDisplayImageOptions(int placeholderImage){
        DisplayImageOptions options = getBaseDisplayImageOptionsBuilder()
                .showImageOnFail(placeholderImage)
                .showImageOnLoading(placeholderImage)
                .showImageForEmptyUri(placeholderImage)
                .build();
        return  options;
    }

    public static final DisplayImageOptions getCircleDisplayImageOptions(int placeholderImage){
        DisplayImageOptions options = getBaseDisplayImageOptionsBuilder()
                .showImageOnFail(placeholderImage)
                .showImageOnLoading(placeholderImage)
                .showImageForEmptyUri(placeholderImage)
                .displayer(new RoundedBitmapDisplayer(360))
                .build();
        return  options;
    }


    public static final DisplayImageOptions getCircleDisplayImageOptions(Drawable placeholderImage){
        DisplayImageOptions options = getBaseDisplayImageOptionsBuilder()
                .showImageOnFail(placeholderImage)
                .showImageOnLoading(placeholderImage)
                .showImageForEmptyUri(placeholderImage)
                .displayer(new RoundedBitmapDisplayer(360))
                .build();
        return  options;
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
