package com.onepeak.mvpdemo.base.mvp;

import com.onepeak.mvpdemo.base.mvp.Callback.ViewCallBack;

import java.util.HashMap;

/**
 *
 * Created by OnePeak on 2018/4/19
 *
 */
public abstract class BasePresenter extends Presenter {

    protected BaseModel mBaseModel;
    protected HashMap<String, String> paramMap = new HashMap<>();
    protected ViewCallBack mViewCallBack;

    private BasePresenter(){

    }

    public BasePresenter(ViewCallBack viewCallBack) {
        mViewCallBack = viewCallBack;
    }


    public void add(ViewCallBack viewCallBack) {
        this.mViewCallBack = viewCallBack;
    }

    public void remove() {
        this.mViewCallBack = null;
    }
}
