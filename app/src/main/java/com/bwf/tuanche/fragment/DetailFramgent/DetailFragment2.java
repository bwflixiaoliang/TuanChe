package com.bwf.tuanche.fragment.DetailFramgent;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.Adatper.RecycleViewAdapter_detail;
import com.bwf.tuanche.R;
import com.bwf.tuanche.eneity.detail.Bigxiang;
import com.bwf.tuanche.eneity.detail.Xiangqing;

/**
 * Created by fengchao on 2016/8/20.
 * Description：
 */
public class DetailFragment2 extends BaseFragment{
    private Bigxiang bigxiang;

    private RecyclerView recyclerView;

    private  RecycleViewAdapter_detail recycleViewAdapter_detail;

    @Override
    protected int getResource() {
        return R.layout.deatil_fragment2;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        recyclerView=findViewByIdNoCast(R.id.deatil_recylerview);
         recycleViewAdapter_detail=new RecycleViewAdapter_detail(getContext());
    }

    @Override
    protected void initData() {
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(recycleViewAdapter_detail);

    }
    public  void setData(String tv){
        if(tv!=null){
            LogUtils.e("UUUU"+tv);
            String newtv="{ result:"+tv+"}";
            bigxiang=new Bigxiang();
            bigxiang= JSON.parseObject(newtv, Bigxiang.class);
            recycleViewAdapter_detail.setAdapterData(bigxiang.result);
            recycleViewAdapter_detail.notifyDataSetChanged();
        }

    }
    @Override
    public void onClick(View view) {

    }
}
