package com.bwf.tuanche;

import android.content.Intent;
import android.view.View;

import com.bwf.framwork.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void beforeInitView() {
        Intent intent=new Intent(this,MainListActivity.class);
        startActivity(intent);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {

    }
}
