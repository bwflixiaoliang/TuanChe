package com.bwf.tuanche.CarContentFragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.tuanche.R;


public class HotLogeFragment01 extends BaseFragment {
    private RecyclerView car_contentRecy;
    @Override
    protected int getResource() {
        return R.layout.fragment_hot_loge_fragment01;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        car_contentRecy = findViewByIdNoCast(R.id.car_contentRecy);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),4);
        car_contentRecy.setLayoutManager(gridLayoutManager);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {

    }
}
