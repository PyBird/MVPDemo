package com.onepeak.mvpdemo.base.mvp;

import com.onepeak.mvpdemo.base.mvp.Callback.ViewCallBack;

/**
 *
 * 提高层级
 * Created by OnePeak on 2018/4/20
 *
 */
public abstract class BaseMVPFragment<PT extends BasePresenter,DT> extends MVPFragment<PT> implements ViewCallBack<DT>{

    @Override
    public void onResume() {
        super.onResume();
        presenter.add((ViewCallBack) this);
    }

    @Override
    public void refreshView(int code, DT data) {

    }
}
