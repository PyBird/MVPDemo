package com.onepeak.mvpdemo.base.mvp.Callback;

/**
 *
 * Created by OnePeak on 2018/4/19
 *
 * @param <V> 数据类型
 */
public interface ViewCallBack<V> {

    /**
     * @param code code:0:有数据，1：数据为空,2:加载失败
     * @param data 定义好的数据类型
     */
    void refreshView(int code, V data);
}