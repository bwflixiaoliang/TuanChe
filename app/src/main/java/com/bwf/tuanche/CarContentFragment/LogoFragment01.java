package com.bwf.tuanche.CarContentFragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.tuanche.Adatper.CarHotRecyclerAdatper;
import com.bwf.tuanche.R;
import com.bwf.tuanche.eneity.hotlogo.ResultBean;

public class LogoFragment01 extends BaseFragment {

    private RecyclerView car_contentRecy;

    private CarHotRecyclerAdatper hotRecyclerAdatper;

    private ResultBean resultBean;

    public void setResultBean(ResultBean resultBean) {
        this.resultBean = resultBean;
        showDataOnView();
    }


    @Override
    protected int getResource() {
        return R.layout.fragment_logo_fragment01;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        //RcycleView的属性
        car_contentRecy = findViewByIdNoCast(R.id.car_contentRecy);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),4);
        car_contentRecy.setLayoutManager(gridLayoutManager);
    }

    //显示数据
    private void showDataOnView(){
        if(resultBean != null){
            hotRecyclerAdatper = new CarHotRecyclerAdatper(getContext(),resultBean.result.list);
            car_contentRecy.setAdapter(hotRecyclerAdatper);
        }
    }
    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {

    }
}
