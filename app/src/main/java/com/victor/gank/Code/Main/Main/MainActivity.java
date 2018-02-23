package com.victor.gank.Code.Main.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.victor.gank.Code.Base.BaseActivity;
import com.victor.gank.Code.Main.HomePage.HomePageFragment;
import com.victor.gank.Code.Welfare.WelfareList.WelfareListActivity;
import com.victor.gank.Data.Welfare.Welfare;
import com.victor.gank.Data.Welfare.WelfareList;
import com.victor.gank.R;

public class MainActivity extends BaseActivity implements MainContract.View {

    private MainPresenter mMainPresenter;
    private FragmentTransaction mFragmentTransaction;
    private HomePageFragment mHomePageFragment;
    private HomePageFragment mMyInfoFragment;

    private TextView mTvHomePage;
    private TextView mTvFreeReading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMainPresenter = new MainPresenter(this);
        mMainPresenter.start();
    }

    @Override
    public void initViews() {
        mTvHomePage = (TextView) findViewById(R.id.tv_home_page);
        mTvFreeReading = (TextView) findViewById(R.id.tv_free_reading);

        mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        mHomePageFragment = new HomePageFragment();
//        mMyInfoFragment = new HomePageFragment();
        mFragmentTransaction.add(R.id.ll_content, mHomePageFragment);
//        mFragmentTransaction.add(R.id.ll_content, mMyInfoFragment);
//        mFragmentTransaction.show(mHomePageFragment);
        mFragmentTransaction.commit();
    }

    @Override
    public void initListeners() {
        mTvHomePage.setOnClickListener(this);
        mTvFreeReading.setOnClickListener(this);
    }

    @Override
    public void initData() {
        mFragmentTransaction = getSupportFragmentManager().beginTransaction();
//        mFragmentTransaction.hide(mHomePageFragment);
//        mFragmentTransaction.hide(mMyInfoFragment);
        mFragmentTransaction.show(mHomePageFragment);
        mFragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {
        if(v == mTvHomePage){
        } else if (v == mTvFreeReading){
            Intent intent = new Intent(this, WelfareListActivity.class);
            startActivity(intent);
        } else {
            super.onClick(v);
        }
    }

    @Override
    public void showToast(@StringRes int toastId) {
    }

    @Override
    public void showToast(String content) {
    }
}
