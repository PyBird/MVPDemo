package com.onepeak.mvpdemo.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.readystatesoftware.systembartint.SystemBarTintManager;

public class BarUtils {

    @SuppressWarnings("ResourceType")
    public static void initSystemBarColor(Activity activity) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            setTranslucentStatus(activity, true);
//            SystemBarTintManager tintManager = new SystemBarTintManager(activity);
//            tintManager.setStatusBarTintEnabled(true);
//            TypedArray a = activity.obtainStyledAttributes(new int[]{
//                    R.attr.status_system_bg_color, R.attr.status_bg_color});
//            int setColor = a.getColor(0, -1);
//            int statusBgColor = a.getColor(1, -1);
//            //通知栏所需颜色
//            if (setColor != -1) {
//                tintManager.setStatusBarTintColor(setColor);
//            } else if (statusBgColor != -1) {
//                tintManager.setStatusBarTintColor(statusBgColor);
//            }
//
//            a.recycle();
//            ((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0).setFitsSystemWindows(true);//不设置全屏
//        }
    }

    public static void initSystemBarColor(Activity activity, int color) {
        if (activity == null) return;
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = activity.getWindow();
            //取消设置透明状态栏,使 ContentView 内容不再覆盖状态栏
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //设置状态栏颜色
            window.setStatusBarColor(color);
            ViewGroup mContentView = (ViewGroup) activity.findViewById(Window.ID_ANDROID_CONTENT);
            View mChildView = mContentView.getChildAt(0);
            if (mChildView != null) {
                mChildView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
                //注意不是设置 ContentView 的 FitsSystemWindows, 而是设置 ContentView 的第一个子 View . 预留出系统 View 的空间.
                ViewCompat.setFitsSystemWindows(mChildView, true);
            }
        } else if (Build.VERSION.SDK_INT >= 19) {
            Window window = activity.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            SystemBarTintManager tintManager = new SystemBarTintManager(activity);
            tintManager.setStatusBarTintColor(color);
            tintManager.setStatusBarTintEnabled(true);
        }
    }

    public static void initSystemBarColor(Activity activity, String color, boolean isFits) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(activity, true);
            SystemBarTintManager tintManager = new SystemBarTintManager(activity);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintColor(Color.parseColor(color));//通知栏所需颜色
            if (isFits)
                ((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0).setFitsSystemWindows(true);//不设置全屏
        }
    }

    @TargetApi(19)
    protected static void setTranslucentStatus(Activity activity, boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    public static int getColor(Context context, int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return context.getColor(color);
        } else {
            return context.getResources().getColor(color);
        }
    }
}
