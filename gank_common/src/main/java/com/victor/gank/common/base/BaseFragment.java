package com.victor.gank.common.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Fragment基类
 * Created by Victor on 2018/2/22.
 */
public abstract class BaseFragment<V, T extends BasePresenter<V>> extends Fragment {

    private static final String STATE_SAVE_IS_HIDDEN = "STATE_SAVE_IS_HIDDEN";
    protected T mPresenter;

    //定义一个View用来保存Fragment创建的时候使用打气筒工具进行的布局获取对象的存储
    protected View mView;

    private long mCurrentTime;


    /**
     * 当Fragment进行创建的时候执行的方法
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = createPresenter();//创建presenter
        if (null != mPresenter) {
            mPresenter.attachView((V) this);
        }

        mCurrentTime = System.currentTimeMillis();
        Log.e("test", " onCreate mCurrentTime = " + mCurrentTime);
    }

//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        outState.putBoolean(STATE_SAVE_IS_HIDDEN, isHidden());
//    }

    /**
     * 这个方法是关于Fragment完成创建的过程中，进行界面填充的方法,该方法返回的是一个view对象
     * 在这个对象中封装的就是Fragment对应的布局
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mView != null && mView.getParent() != null) {
            ((ViewGroup) mView.getParent()).removeView(mView);
        } else {
            mView = initFragmentView(inflater);
        }

        mCurrentTime = System.currentTimeMillis();
        Log.e("test", "onCreateView mCurrentTime = " + mCurrentTime);
        return mView;
    }

    /**
     * 这个方法当onCreateView方法中的view创建完成之后，执行
     * 在inflate完成view的创建之后，可以将对应view中的各个控件进行查找findViewById
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        initFragmentChildView(view);
        initViewListener();

        mCurrentTime = System.currentTimeMillis();
        Log.e("test", "onViewCreated mCurrentTime = " + mCurrentTime);
    }

    /**
     * 这个方法是在Fragment完成创建操作之后，进行数据填充操作的时候执行的方法
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initFragmentData(savedInstanceState);

        mCurrentTime = System.currentTimeMillis();
        Log.e("test", "onActivityCreated mCurrentTime = " + mCurrentTime);
    }

    /**
     * 完成打气筒操作
     */
    protected abstract View initFragmentView(LayoutInflater inflater);


    /**
     * 进行findViewById的操作
     *
     * @param view 打气筒生成的View对象
     */
    protected abstract void initFragmentChildView(View view);

    protected abstract void initViewListener();

    /**
     * 网络数据填充的操作
     *
     * @param savedInstanceState
     */
    protected abstract void initFragmentData(Bundle savedInstanceState);

    /**
     * 创建Presenter对象
     */
    protected abstract T createPresenter();

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (null != mPresenter) {
            mPresenter.detachView();
        }
    }

}
