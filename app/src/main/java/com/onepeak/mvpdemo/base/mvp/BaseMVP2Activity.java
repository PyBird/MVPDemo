package com.onepeak.mvpdemo.base.mvp;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.onepeak.mvpdemo.base.mvp.Callback.ViewCallBack;


/**
 *
 * 基础版
 * Created by OnePeak on 2018/4/19
 *
 */
public abstract class BaseMVP2Activity<PT extends BasePresenter, DT> extends AppCompatActivity implements ViewCallBack<DT> {
    public PT presenter;

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(getLayoutId());
        presenter = initPresenter();
        presenter.onCreate(bundle);
        initViews();
        initListener();
    }

    protected abstract int getLayoutId();

    protected abstract void initViews();

    protected abstract void initListener();//初始化监听事件

    protected abstract PT initPresenter();//初始化Presenter

    @Override
    protected void onStart(){
        super.onStart();

        if (presenter == null){
            presenter = initPresenter();
        }
        presenter.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (presenter == null){
            presenter = initPresenter();
        }
        presenter.add((ViewCallBack) this);
        presenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.onDestroy();
            presenter.remove();
            presenter = null;
        }
    }


}
