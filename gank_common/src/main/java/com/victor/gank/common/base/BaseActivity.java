package com.victor.gank.common.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * BaseActivity
 * Activity的基类
 * Created by Victor on 2018/2/22.
 */
public abstract class BaseActivity<V, T extends BasePresenter<V>> extends AppCompatActivity implements View.OnClickListener {

    protected T mPresenter;
    public Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActivityView(savedInstanceState);
        mContext = BaseActivity.this;
        //创建presenter
        mPresenter = createPresenter();

        // presenter与view绑定
        if (null != mPresenter) {
            mPresenter.attachView((V) this);
        }

        initView();
        initListener();
        initData();
    }

    /**
     * 关于Activity的界面填充的抽象方法，需要子类必须实现
     */
    protected abstract void initActivityView(Bundle savedInstanceState);

    /**
     * 创建Presenter 对象
     * @return
     */
    protected abstract T createPresenter();

    protected abstract void initView();

    protected abstract void initListener();

    protected abstract void initData();

    @Override
    public void onClick(View v) {

    }
    @Override
    protected void onDestroy() {
        if (null != mPresenter) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }

}
