package com.bwf.tuanche.fragment.CarContentFragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.tuanche.Adatper.CarGuobieRecyclerAdatper;
import com.bwf.tuanche.R;
import com.bwf.tuanche.eneity.TiaojianCar.CarCountry;

import java.util.List;


public class TiaojianFragment02 extends BaseFragment {

    private RecyclerView TJ_guojia_contentRecy;
    private List<CarCountry> series;
    private CarGuobieRecyclerAdatper guobieRecyclerAdatper;

    public void setSeries(List<CarCountry> series) {
        this.series = series;
        showDataCountry();
    }

    @Override
    protected int getResource() {
        return R.layout.fragment_tiaojian_fragment02;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        TJ_guojia_contentRecy = findViewByIdNoCast(R.id.TJ_guojia_contentRecy);

        //RecycleView的属性
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),3);
        TJ_guojia_contentRecy.setLayoutManager(gridLayoutManager);

    }

    @Override
    protected void initData() {

    }

    public void showDataCountry(){
        guobieRecyclerAdatper = new CarGuobieRecyclerAdatper(getContext(),series);
        TJ_guojia_contentRecy.setAdapter(guobieRecyclerAdatper);
    }

    @Override
    public void onClick(View view) {

    }
}
