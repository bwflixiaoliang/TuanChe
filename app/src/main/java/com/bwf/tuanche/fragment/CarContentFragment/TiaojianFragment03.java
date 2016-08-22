package com.bwf.tuanche.fragment.CarContentFragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.tuanche.Adatper.CarPailiangRecyclerAdatper;
import com.bwf.tuanche.R;
import com.bwf.tuanche.eneity.TiaojianCar.CarLevle;

import java.util.List;


public class TiaojianFragment03 extends BaseFragment {
    private RecyclerView TJ_pailiang_contentRecy;
    private List<CarLevle> levle;
    private CarPailiangRecyclerAdatper recyclerAdatper;

    public void setLevle(List<CarLevle> levle) {
        this.levle = levle;
        showDataPailiang();
    }

    @Override
    protected int getResource() {
        return R.layout.fragment_tiaojian_fragment03;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        TJ_pailiang_contentRecy = findViewByIdNoCast(R.id.TJ_pailiang_contentRecy);

        //RecycleView的属性
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        TJ_pailiang_contentRecy.setLayoutManager(gridLayoutManager);
    }

    @Override
    protected void initData() {

    }

    public void showDataPailiang() {
        if (levle != null) {
            recyclerAdatper = new CarPailiangRecyclerAdatper(getContext(), levle);
            TJ_pailiang_contentRecy.setAdapter(recyclerAdatper);
        }
    }


    @Override
    public void onClick(View view) {

    }
}
