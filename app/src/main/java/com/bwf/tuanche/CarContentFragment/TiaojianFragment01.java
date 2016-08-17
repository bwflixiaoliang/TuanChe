package com.bwf.tuanche.CarContentFragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.tuanche.Adatper.CarJibieRecyclerAdatper;
import com.bwf.tuanche.R;
import com.bwf.tuanche.eneity.TiaojianCar.CarRank;

import java.util.List;


public class TiaojianFragment01 extends BaseFragment {

    private RecyclerView TJ_jibie_contentRecy;
    private CarJibieRecyclerAdatper jibieRecyclerAdatper;
    private List<CarRank> bos;

    public void setLevle(List<CarRank> bos) {
        this.bos = bos;
        showData();
    }


    @Override
    protected int getResource() {
        return R.layout.fragment_tiaojian_fragment01;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        TJ_jibie_contentRecy = findViewByIdNoCast(R.id.TJ_jibie_contentRecy);
        //RecycleView的属性
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),3);
        TJ_jibie_contentRecy.setLayoutManager(gridLayoutManager);

    }

    @Override
    protected void initData() {

    }

    public void showData(){
        if(bos != null){
            jibieRecyclerAdatper = new CarJibieRecyclerAdatper(getContext(),bos);
            TJ_jibie_contentRecy.setAdapter(jibieRecyclerAdatper);
        }
    }

    @Override
    public void onClick(View view) {

    }
}
