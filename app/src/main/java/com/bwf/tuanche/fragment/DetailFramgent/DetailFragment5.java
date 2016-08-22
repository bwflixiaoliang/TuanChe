package com.bwf.tuanche.fragment.DetailFramgent;

import android.view.View;
import android.webkit.WebView;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.tuanche.R;
import com.bwf.tuanche.eneity.detail.DetailResult;
import com.bwf.tuanche.eneity.detail.DetailResultBean;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by fengchao on 2016/8/20.
 * Description：
 */
public class DetailFragment5 extends BaseFragment{
    private WebView frag5_sim;
    @Override
    protected int getResource() {
        return R.layout.deatil_fragment5;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        frag5_sim=findViewByIdNoCast(R.id.frag5_web);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {

    }

    public void setdata(DetailResult detailResult){
        frag5_sim.loadUrl("http://123.56.145.151:8080/TuanCheNetWork/bwf_TuanChe_BuyInfoQuestionServlet");
    }
}
