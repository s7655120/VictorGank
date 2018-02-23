package com.victor.gank.Code.Base;

import android.support.annotation.StringRes;

/**
 * View接口基类
 * Created by Victor on 2017/7/31.
 */
public interface BaseView<T> {
    void initViews();
    void initListeners();
    void initData();
    void showToast(@StringRes int toastId);
    void showToast(String content);
}
