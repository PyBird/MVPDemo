package com.onepeak.mvpdemo.base.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

public class Presenter {
    /**
     * activity 第一次create直到到主动退出Activity之前都不会调用。
     */
    protected void onCreate(Bundle savedState) {
    }
    /**
     * presenter销毁时的回调。代表着activity正式退出
     */
    protected void onDestroy() {
    }

    /**
     * activity$OnCreate的回调,但执行延迟到OnCreate之后。
     */
    protected void onCreateView(View view) {
        this.view = view;
    }
    /**
     * activity$OnDestory的回调
     */
    protected void onDestroyView() {
    }

    protected void onStart() {
    }

    protected void onResume() {
    }
    protected void onPause() {
    }
    protected void onStop() {
    }
    protected void onBackPressed() {
    }

    protected void onSaveInstanceState(Bundle state) {
    }
    protected void onNewIntent(Intent intent) {
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    View view;
    @NonNull
    public final View getView() {
        return view;
    }
}
