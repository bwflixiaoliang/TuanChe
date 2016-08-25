package com.bwf.tuanche.fragment.MainlistFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.utils.ListViewUtils;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.tuanche.Activity.DeatilActivity;
import com.bwf.tuanche.Adatper.gridviewAdapter;
import com.bwf.tuanche.R;
import com.bwf.tuanche.eneity.hotlogo.HotLogo;
import com.bwf.tuanche.eneity.hotlogo.ResultBean;

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

    public void getData(final ResultBean result, final String cityName){
        if(result.result!=null){
        List<HotLogo> newdata=result.result.list;
        HotLogo hotLogo=new HotLogo();
        hotLogo.name="更多";
        newdata.add(hotLogo);
        gridviewAdapter gridviewAdapter=new gridviewAdapter(newdata,getContext());
        gridView.setAdapter(gridviewAdapter);
        ListViewUtils.calGridViewWidthAndHeigh(3,gridView);
            gridviewAdapter.notifyDataSetChanged();
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent=new Intent(getActivity(), DeatilActivity.class);
                    Bundle bundle=new Bundle();
                    bundle.putSerializable("res",result.result.list.get(i));
                    intent.putExtras(bundle);
                    intent.putExtra("carname",result.result.list.get(i).name);
                    intent.putExtra("cityname",cityName);
                    startActivity(intent);
                }
            });

    }}
}
