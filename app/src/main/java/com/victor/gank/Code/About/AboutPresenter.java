package com.victor.gank.Code.About;

import android.content.Context;

import com.victor.gank.Utils.AppInfoUtils;

/**
 * Created by Victor on 2017/7/31.
 */

public class AboutPresenter implements AboutContract.Presenter {

    private AboutContract.View mAboutView;

    public AboutPresenter(AboutContract.View view) {
        this.mAboutView = view;
    }

    @Override
    public void start() {
        mAboutView.initViews();
        mAboutView.initListeners();
        mAboutView.initData();
    }

    @Override
    public void getAppVersion(Context context) {
        String version = AppInfoUtils.getAppVersionName(context);
        mAboutView.showAppVersion(version);
    }

    @Override
    public void end() {

    }
}
