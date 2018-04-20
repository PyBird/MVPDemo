package com.onepeak.mvpdemo.base.mvp;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.onepeak.mvpdemo.base.mvp.Callback.ViewCallBack;


/**
 *
 * 提高层级
 * Created by OnePeak on 2018/4/19
 *
 */
public abstract class BaseMVPActivity<PT extends BasePresenter, DT> extends MVPActivity<PT> implements ViewCallBack<DT> {

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override
    protected void onStart(){
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.add((ViewCallBack) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
