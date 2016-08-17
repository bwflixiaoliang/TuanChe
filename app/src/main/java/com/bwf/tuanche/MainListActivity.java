package com.bwf.tuanche;

import android.view.View;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.tuanche.fragment.MainlistFragment.MainListFragment_1;
import com.bwf.tuanche.fragment.MainlistFragment.MainListFragment_2;

public class MainListActivity extends BaseActivity {

    private MainListFragment_1 mainListFragment_1;

    private MainListFragment_2 mainListFragment_2;

    @Override
    public int getContentViewId() {
        return R.layout.activity_main_list;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        mainListFragment_1= (MainListFragment_1) getSupportFragmentManager().findFragmentById(R.id.main_list_frag1);
        mainListFragment_2= (MainListFragment_2) getSupportFragmentManager().findFragmentById(R.id.main_list_frag2);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {

    }
}
