package com.onepeak.mvpdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.onepeak.mvpdemo.base.mvp.BaseMVPActivity;

/**
 *
 * Created by OnePeak on 2018/4/19
 *
 */
public class MainActivity extends BaseMVPActivity<MainPresenter,String> {

    private TextView tv_hello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        tv_hello = (TextView)findViewById(R.id.tv_hello);
    }

    @Override
    protected void initListener() {

        tv_hello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onTvClick();
            }
        });
    }

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void refreshView(int code, String data) {
        tv_hello.setText(data);
    }
}
