package com.bwf.tuanche.fragment.DetailFramgent;

import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.tuanche.R;
import com.bwf.tuanche.eneity.detail.DetailResult;
import com.bwf.tuanche.eneity.detail.Xiangqing;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by fengchao on 2016/8/20.
 * Description：
 */
public class DetailFragment3 extends BaseFragment{
    private WebView image;
    @Override
    protected int getResource() {
        return R.layout.deatil_fragment3;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        image=findViewByIdNoCast(R.id.image);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {

    }
    public void setdata(DetailResult detailResult){
        image.loadUrl("http://123.56.145.151:8080/TuanCheNetWork/bwf_TuanChe_BuyInfoNogroupServlet");
    }

}
