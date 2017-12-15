package com.heshiqi.widget.ninegrid;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by heshiqi on 17/12/15.
 */

public class ImageEntity implements Parcelable{

    private String pic_url;
    private int width;
    private int height;
    private int order_num;
    private String thumbnail_pic_url;

    public ImageEntity(){}

    public ImageEntity(Parcel in) {
        pic_url = in.readString();
        width = in.readInt();
        height = in.readInt();
        order_num = in.readInt();
        thumbnail_pic_url = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(pic_url);
        dest.writeInt(width);
        dest.writeInt(height);
        dest.writeInt(order_num);
        dest.writeString(thumbnail_pic_url);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ImageEntity> CREATOR = new Creator<ImageEntity>() {
        @Override
        public ImageEntity createFromParcel(Parcel in) {
            return new ImageEntity(in);
        }

        @Override
        public ImageEntity[] newArray(int size) {
            return new ImageEntity[size];
        }
    };

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getOrder_num() {
        return order_num;
    }

    public void setOrder_num(int order_num) {
        this.order_num = order_num;
    }

    public String getThumbnail_pic_url() {
        return thumbnail_pic_url;
    }

    public void setThumbnail_pic_url(String thumbnail_pic_url) {
        this.thumbnail_pic_url = thumbnail_pic_url;
    }
}
