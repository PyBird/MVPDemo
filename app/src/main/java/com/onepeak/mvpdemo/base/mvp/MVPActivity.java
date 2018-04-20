package com.onepeak.mvpdemo.base.mvp;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

/**
 *
 * Created by OnePeak on 2018/4/20
 *
 */
public abstract class MVPActivity<PT extends BasePresenter> extends AppCompatActivity {

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


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        if (presenter != null) {
            presenter.onSaveInstanceState(outState);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (presenter != null) {
            presenter.onPause();
        }
    }

    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (presenter != null) {
            presenter.onNewIntent(intent);
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (presenter != null) {
            presenter.onBackPressed();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (presenter != null) {
            presenter.onStop();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (presenter != null) {
            presenter.onActivityResult(requestCode,resultCode,data);
        }
    }

}
