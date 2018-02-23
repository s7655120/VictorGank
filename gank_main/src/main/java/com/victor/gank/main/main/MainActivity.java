package com.victor.gank.main.main;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.victor.gank.common.base.BaseActivity;
import com.victor.gank.main.R;
import com.victor.gank.main.homePage.HomePageFragment;

/**
 * Created by Victor on 2018/2/22.
 */

public class MainActivity extends BaseActivity<MainContract.MainView, MainPresenter>  {

    private FragmentTransaction mFragmentTransaction;
    private HomePageFragment mHomePageFragment;
//    private HomePageFragment mMyInfoFragment;
    private TextView mTvHomePage;
    private TextView mTvFreeReading;

    @Override
    protected void initActivityView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initView() {
        mTvHomePage = findViewById(R.id.tv_home_page);
        mTvFreeReading = findViewById(R.id.tv_free_reading);
        mHomePageFragment = new HomePageFragment();
        mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        mFragmentTransaction.add(R.id.ll_content, mHomePageFragment);
        mFragmentTransaction.commit();
    }

    @Override
    protected void initListener() {
        mTvHomePage.setOnClickListener(this);
        mTvFreeReading.setOnClickListener(this);
    }

    @Override
    protected void initData() {
    }

    @Override
    public void onClick(View v) {
        if(v == mTvHomePage){
        } else if (v == mTvFreeReading){
//            Intent intent = new Intent(this, WelfareListActivity.class);
//            startActivity(intent);
        } else {
            super.onClick(v);
        }
    }
}
