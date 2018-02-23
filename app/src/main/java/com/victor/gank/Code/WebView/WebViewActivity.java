package com.victor.gank.Code.WebView;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.victor.gank.Code.Base.BaseActivity;
import com.victor.gank.R;

/**
 * Created by Victor on 2017/6/15.
 */
public class WebViewActivity extends BaseActivity {

    private WVFragment mWVFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        initFragment();
    }


    private void initFragment(){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        mWVFragment = new WVFragment();
        transaction.add(R.id.ll_web_view, mWVFragment);
        transaction.commit();


//        mWVFragment.initView();
    }

    @Override
    public void onBackPressed() {
        mWVFragment.initView();
    }
}
