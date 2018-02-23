package com.victor.gank.startover.welcome;

import android.os.Bundle;

import com.victor.gank.common.base.BaseActivity;

/**
 * Created by Victor on 2018/2/22.
 */

public class WelcomeActivity extends BaseActivity<WelcomeContract.WelcomeView, WelcomePresenter>
        implements WelcomeContract.WelcomeView {

    @Override
    protected void initActivityView(Bundle savedInstanceState) {

    }

    @Override
    protected WelcomePresenter createPresenter() {
        return new WelcomePresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}
