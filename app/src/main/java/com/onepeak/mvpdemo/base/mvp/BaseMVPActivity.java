package com.onepeak.mvpdemo.base.mvp;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.onepeak.mvpdemo.base.mvp.Callback.ViewCallBack;


/**
 *
 * Created by OnePeak on 2018/4/19
 *
 */
public abstract class BaseMVPActivity<T extends BasePresenter, V> extends AppCompatActivity implements ViewCallBack<V> {
    public T presenter;

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(getLayoutId());
        presenter = initPresenter();
        initViews();
        initListener();
    }


    protected abstract int getLayoutId();


    @Override
    protected void onResume() {
        super.onResume();
        if (presenter == null){
            presenter = initPresenter();
        }
        presenter.add((ViewCallBack) this);

    }


    protected abstract void initViews();

    protected abstract void initListener();//初始化监听事件

    protected abstract T initPresenter();//初始化Presenter


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.remove();
            presenter = null;
        }
    }


}
