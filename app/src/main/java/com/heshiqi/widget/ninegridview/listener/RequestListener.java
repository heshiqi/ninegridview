package com.heshiqi.widget.ninegridview.listener;


import com.heshiqi.widget.ninegridview.exception.AHHttpException;

/**
 * Created by heshiqi on 17/7/28.
 * 网络请求回调
 *
 * @param <T>泛型 返回的实体类
 */
public interface RequestListener<T> {

    /**
     * 网路请求成功
     *
     * @param data       返回的数据实体类
     * @param statusCode 返回码
     * @param tag
     */
    void onSuccess(T data, int statusCode, Object tag);

    /**
     * 网路请求失败
     *
     * @param e   失败的错误码 与信息 {@link AHHttpException#errorCode}我们约定是-1时，未知错误，非-1时，对应的错误消息
     * @param tag
     */
    void onError(AHHttpException e, Object tag);
}
