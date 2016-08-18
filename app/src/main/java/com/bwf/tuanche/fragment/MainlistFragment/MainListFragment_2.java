package com.bwf.tuanche.fragment.MainlistFragment;

import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.utils.ListViewUtils;
import com.bwf.tuanche.Adatper.gridviewAdapter;
import com.bwf.tuanche.R;
import com.bwf.tuanche.eneity.hotlogo.HotLogo;
import com.bwf.tuanche.eneity.hotlogo.Result;

import java.util.List;

/**
 * Created by fengchao on 2016/8/16.
 * Description：
 */
public class MainListFragment_2 extends BaseFragment{
    private GridView gridView;

    private LinearLayout linearLayout;

    @Override
    protected int getResource() {
        return R.layout.main_list_fragment2;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        gridView=findViewByIdNoCast(R.id.GridView);
        linearLayout=findViewByIdNoCast(R.id.more);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {

    }

    public void getData(Result result){
        List<HotLogo> newdata=result.result.list;
        HotLogo hotLogo=new HotLogo();
        hotLogo.name="更多";
        newdata.add(hotLogo);
        gridviewAdapter gridviewAdapter=new gridviewAdapter(newdata,getContext());
        gridView.setAdapter(gridviewAdapter);
        ListViewUtils.calGridViewWidthAndHeigh(3,gridView);
        gridviewAdapter.notifyDataSetChanged();

    }
}
