package com.victor.gank.Code.About;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.victor.gank.Code.Base.BaseActivity;
import com.victor.gank.R;

/**
 * 关于界面
 * Created by Victor on 2017/7/31.
 */
public class AboutActivity extends BaseActivity implements AboutContract.View{

    private AboutPresenter mAboutPresenter;

    private ImageView mIvLogo;
    private TextView mTvAppVersion;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        mAboutPresenter = new AboutPresenter(this);
        mAboutPresenter.start();
    }

    @Override
    public void initViews() {
        initToolBar(R.string.about_title);
        mIvLogo = (ImageView) findViewById(R.id.iv_app_logo);
        mTvAppVersion = (TextView) findViewById(R.id.tv_app_version);
    }

    @Override
    public void initListeners() {}

    @Override
    public void initData() {
        Glide.with(this).load(R.mipmap.ic_launcher_round).into(mIvLogo);
        mAboutPresenter.getAppVersion(this);
    }

    @Override
    public void showAppVersion(String version) {
        mTvAppVersion.setText(getString(R.string.about_version, version));
    }

    @Override
    public void showToast(@StringRes int toastId) {}

    @Override
    public void showToast(String content) {}


}
