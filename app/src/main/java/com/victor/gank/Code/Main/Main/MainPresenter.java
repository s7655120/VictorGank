package com.victor.gank.Code.Main.Main;

/**
 * Created by Victor on 2017/8/2.
 */
public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mMainView;

    public MainPresenter(MainContract.View view) {
        this.mMainView = view;
    }

    @Override
    public void start() {
        mMainView.initViews();
        mMainView.initListeners();
        mMainView.initData();
    }

    @Override
    public void end() {

    }
}
