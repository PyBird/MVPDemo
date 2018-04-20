package com.onepeak.mvpdemo.base;

import android.support.v4.app.Fragment;

import com.onepeak.mvpdemo.utils.ToastUtil;


/**
 *
 * Created by OnePeak on 2018/4/20
 *
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public void showToast(int resId) {
        ToastUtil.showToast(getActivity(), resId);
    }

    public void showToast(String tip) {
        ToastUtil.showToast(getActivity(), tip);
    }

    public void showLoading(int resId) {
    }

    public void showLoading() {
    }

    public void hideLoading() {
    }

    public void finishActivity() {
        getActivity().finish();
    }
}
