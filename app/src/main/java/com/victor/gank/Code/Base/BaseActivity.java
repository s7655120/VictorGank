package com.victor.gank.Code.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.victor.gank.R;

/**
 * Created by Victor on 2017/7/31.
 */
public class BaseActivity extends AppCompatActivity implements View.OnClickListener{

    private Toolbar mToolBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    protected void initToolBar(@StringRes int titleId){
        mToolBar = (Toolbar)findViewById(R.id.toolbar);
        mToolBar.setTitle("");
        showCenterTitle(titleId);
        setSupportActionBar(mToolBar);
    }

    protected void showCenterTitle(@StringRes int titleId){
        TextView tvCenterTitle = (TextView) findViewById(R.id.tv_center_title);
        tvCenterTitle.setVisibility(View.VISIBLE);
        tvCenterTitle.setText(titleId);
        tvCenterTitle.setText(titleId);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (android.R.id.home == item.getItemId()) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {}
}
