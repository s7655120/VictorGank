package com.victor.gank.Code.Welfare.WelfareList;

import com.victor.gank.Code.Base.BasePresenter;
import com.victor.gank.Code.Base.BaseView;
import com.victor.gank.Data.Welfare.Welfare;

import java.util.ArrayList;

/**
 * Created by Victor on 2017/7/31.
 */
public interface WelfareListContract {
    interface View extends BaseView<WelfareListContract.Presenter> {
        void showWelfareList(ArrayList<Welfare> welfares);
        void loadDataComplete();
    }
    interface Presenter extends BasePresenter {
        void initDataState();
        void getWelfareListData();
        void loadWelfareListData();
    }
}
