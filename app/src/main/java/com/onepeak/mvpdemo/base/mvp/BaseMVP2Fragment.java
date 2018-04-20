package com.onepeak.mvpdemo.base.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.onepeak.mvpdemo.base.mvp.Callback.ViewCallBack;

/**
 *
 * 基础版
 * Created by OnePeak on 2018/4/20
 *
 */
public abstract class BaseMVP2Fragment<PT extends BasePresenter,DT> extends Fragment implements ViewCallBack<DT>{

    public PT presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = initPresenter();
        presenter.onCreate(savedInstanceState);
    }

    protected abstract int getLayoutId();

    protected abstract void initViews();

    protected abstract void initListener();//初始化监听事件

    protected abstract PT initPresenter();//初始化Presenter

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(getLayoutId(),container);
        if(presenter != null){
            presenter.onCreateView(view);
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initViews();
        initListener();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(null != presenter) {
            presenter.onDestroyView();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(null != presenter) {
            presenter.onDestroy();
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if(null != presenter) {
            presenter.onSaveInstanceState(outState);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if(null == presenter) {
            presenter = initPresenter();
        }
        presenter.add((ViewCallBack) this);
        presenter.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        if(null != presenter) {
            presenter.onPause();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(null != presenter) {
            presenter.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void refreshView(int code, DT data) {

    }
}
