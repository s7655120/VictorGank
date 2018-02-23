package com.victor.gank.Code.Base;

import android.support.v4.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

/**
 * Fragment基类
 * Created by Victor on 2017/8/1.
 */
public class BaseFragment extends Fragment implements View.OnClickListener {

    public Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }


    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
