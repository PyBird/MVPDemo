package com.onepeak.mvpdemo.base.mvp2;


import android.app.Activity;


/**
 *
 * Created by OnePeak on 2018/4/19
 *
 */
public abstract class BasePresenter<V extends BaseView> extends Presenter {

    protected Activity mActivity;

    protected BaseModel mBaseModel;
    protected V mBaseView;

    private BasePresenter(){

    }

    public BasePresenter(Activity activity, V baseView) {
        mActivity = activity;
        mBaseView = baseView;
    }

    /**
     * presenter销毁时的回调。代表着activity正式退出
     */
    protected void onDestroy() {
        super.onDestroy();
        mBaseView = null;
        if(null != mBaseModel){
            mBaseModel.onDestroy();
            mBaseModel=null;
        }
    }

}
