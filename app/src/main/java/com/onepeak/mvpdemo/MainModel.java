package com.onepeak.mvpdemo;

import com.onepeak.mvpdemo.base.mvp.BaseModel;
import com.onepeak.mvpdemo.base.mvp.Callback.ViewCallBack;

/**
 * Created by OnePeak on 2018/4/19
 */

public class MainModel extends BaseModel {

    public MainModel(ViewCallBack modelCallBack) {
        super(modelCallBack);
    }

    private int sum=0;
    @Override
    public void getData() {
        sum++;
        mViewCallBack.refreshView(1,sum+"");
    }
}
