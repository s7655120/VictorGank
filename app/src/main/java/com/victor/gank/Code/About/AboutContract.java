package com.victor.gank.Code.About;

import android.content.Context;

import com.victor.gank.Code.Base.BasePresenter;
import com.victor.gank.Code.Base.BaseView;

/**
 * Created by Victor on 2017/7/31.
 */
public interface AboutContract {
    interface View extends BaseView<Presenter> {
        void showAppVersion(String version);
    }
    interface Presenter extends BasePresenter{
        void getAppVersion(Context context);
    }
}
