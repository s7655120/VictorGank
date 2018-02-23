package com.victor.gank.Code.Main.Main;

import com.victor.gank.Code.Base.BasePresenter;
import com.victor.gank.Code.Base.BaseView;
import com.victor.gank.Code.Main.HomePage.HomePageContract;

/**
 * Created by Victor on 2017/8/2.
 */
public interface MainContract {
    interface View extends BaseView<HomePageContract.Presenter> {
    }
    interface Presenter extends BasePresenter {
    }
}
