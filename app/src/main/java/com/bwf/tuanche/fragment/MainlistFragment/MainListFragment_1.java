package com.bwf.tuanche.fragment.MainlistFragment;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwf.framwork.base.BaseBean;
import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.DrawableUtils;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.R;
import com.bwf.tuanche.eneity.TuanChe.Nc;
import com.bwf.tuanche.eneity.TuanChe.TuanCheResult;
import com.facebook.drawee.view.DraweeView;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by fengchao on 2016/8/16.
 * Description：
 */
public class MainListFragment_1 extends BaseFragment{
    private TextView main_list_lowprice,main_list_tiemo,main_list_newcartype,main_list_baoxian;

    private SimpleDraweeView f_lowprice,f_tiemo,f_new,f_baoxian,main_list_bigimg;

    private SimpleDraweeView[] draweeViews;

    private TextView[] textViews;
    @Override
    protected int getResource() {
        return R.layout.main_list_fragment1;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        main_list_lowprice=findViewByIdNoCast(R.id.main_list_lowprice);
        main_list_tiemo=findViewByIdNoCast(R.id.main_list_tiemo);
        main_list_newcartype=findViewByIdNoCast(R.id.main_list_newcartype);
        main_list_baoxian=findViewByIdNoCast(R.id.main_list_baoxian);
        main_list_bigimg=findViewByIdNoCast(R.id.main_list_bigimg);
        f_lowprice=findViewByIdNoCast(R.id.f_lowprice);
        f_tiemo=findViewByIdNoCast(R.id.f_tiemo);
        f_new=findViewByIdNoCast(R.id.f_new);
        f_baoxian=findViewByIdNoCast(R.id.f_baoxian);
        draweeViews=new SimpleDraweeView[]{f_lowprice,f_tiemo,f_new,f_baoxian};
        textViews=new TextView[]{main_list_lowprice,main_list_tiemo,main_list_newcartype,main_list_baoxian};
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {

    }
    public void setData(TuanCheResult result){
    if(result.result!=null){
       List<Nc> nc=result.result.nc;
        for(int i=0;i<nc.size();i++){
            textViews[i].setText(nc.get(i).name);
            draweeViews[i].setImageURI(Uri.parse(nc.get(i).pic));
            draweeViews[i].setScaleType(SimpleDraweeView.ScaleType.FIT_CENTER);
        }
    }


    }

    public void getBigBanner(String url){
        main_list_bigimg.setImageURI(url);
    }
}
