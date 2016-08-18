package com.bwf.tuanche.fragment.MainlistFragment;

import android.view.View;
import android.widget.GridView;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.utils.ListViewUtils;
import com.bwf.tuanche.Adatper.farg4_gridviewAdapter;
import com.bwf.tuanche.R;
import com.bwf.tuanche.eneity.hotcartype.HotCarResultBean;

import java.util.List;

/**
 * Created by fengchao on 2016/8/16.
 * Description：
 */
public class MainListFragment_4 extends BaseFragment{
    private GridView gridView;
    private farg4_gridviewAdapter farg4GridviewAdapter;
    @Override
    protected int getResource() {
        return R.layout.main_list_fragment4;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {

    }
    public void setData(List<HotCarResultBean> result){
        gridView=findViewByIdNoCast(R.id.frag4_gridview);
        farg4GridviewAdapter=new farg4_gridviewAdapter(result,getContext());
        gridView.setAdapter(farg4GridviewAdapter);
        ListViewUtils.calGridViewWidthAndHeigh(2,gridView);
        farg4GridviewAdapter.notifyDataSetChanged();
    }
}
