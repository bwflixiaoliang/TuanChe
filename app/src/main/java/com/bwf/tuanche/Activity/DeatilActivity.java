package com.bwf.tuanche.Activity;

import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.base.BaseBean;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.R;
import com.bwf.tuanche.View.Popwindow_buycarStyle;
import com.bwf.tuanche.View.SharePopWindow;
import com.bwf.tuanche.View.MyScrollView;
import com.bwf.tuanche.View.Popwindow_samebrand;
import com.bwf.tuanche.eneity.detail.DetailResultBean;
import com.bwf.tuanche.eneity.hotlogo.HotLogo;
import com.bwf.tuanche.eneity.searchonly.ResultBean;
import com.bwf.tuanche.fragment.DetailFramgent.DetailFragment1;
import com.bwf.tuanche.fragment.DetailFramgent.DetailFragment2;
import com.bwf.tuanche.fragment.DetailFramgent.DetailFragment3;
import com.bwf.tuanche.fragment.DetailFramgent.DetailFragment4;
import com.bwf.tuanche.fragment.DetailFramgent.DetailFragment5;
import com.umeng.socialize.UMShareAPI;

public class DeatilActivity extends BaseActivity implements DetailFragment1.ShowPop{

    private MyScrollView scrollView;

    private LinearLayout title;

    private Popwindow_samebrand popwindow_samebrand;

    private ImageView img_back_detail;

    private HotLogo hotLogo;

    private TextView carname;

    private ImageView search_tv;

    private Button tuangou_btt;

    private String cityName,thecarname,brandId,Id,cityid;

    private DetailFragment1 detailFragment1;

    private DetailFragment2 detailFragment2;

    private DetailFragment3 detailFragment3;

    private DetailFragment4 detailFragment4;

    private DetailFragment5 detailFragment5;

    private SharePopWindow sharePopWindow;

    @Override
    public int getContentViewId() {
        return R.layout.activity_deatil;
    }

    @Override
    public void beforeInitView() {
        sharePopWindow = new SharePopWindow(this);
         hotLogo= (HotLogo) getIntent().getExtras().getSerializable("res");
        cityName=getIntent().getStringExtra("cityname");
        thecarname=getIntent().getStringExtra("carname");
        brandId=getIntent().getStringExtra("brandId");
        cityid=getIntent().getStringExtra("cityId")==null?"156":getIntent().getStringExtra("cityId");
        if(brandId==null){
            brandId="31";
        }
        Id=getIntent().getStringExtra("Id");
        if(Id==null){
            Id="166";
        }
    }

    @Override
    public void initView() {
        popwindow_samebrand=new Popwindow_samebrand(this);
        title=findViewByIdNoCast(R.id.title_deatil);
        tuangou_btt=findViewByIdNoCast(R.id.tuangou_btt);
        tuangou_btt.setOnClickListener(this);
        img_back_detail=findViewByIdNoCast(R.id.img_back_detail);
        img_back_detail.setOnClickListener(this);
        carname=findViewByIdNoCast(R.id.carname);
        scrollView=findViewByIdNoCast(R.id.scrollView_detail);
        search_tv = findViewByIdNoCast(R.id.search_tv);
        detailFragment1= (DetailFragment1) getSupportFragmentManager().findFragmentById(R.id.deatil_frag1);
        detailFragment2= (DetailFragment2) getSupportFragmentManager().findFragmentById(R.id.deatil_frag2);
        detailFragment3= (DetailFragment3) getSupportFragmentManager().findFragmentById(R.id.deatil_frag3);
        detailFragment4= (DetailFragment4) getSupportFragmentManager().findFragmentById(R.id.deatil_frag4);
        detailFragment5= (DetailFragment5) getSupportFragmentManager().findFragmentById(R.id.deatil_frag5);
        search_tv.setOnClickListener(this);
    }

    @Override
    public void initData() {
        //回调Popwindow的监听
        detailFragment1.setShowPop(this);
        carname.setText(String.format(carname.getText().toString(),thecarname,cityName+"站"));
        newData();
       scrollView.setOnScrollChanged(new MyScrollView.OnScrollChanged() {
           @Override
           public void onScrollChanged(MyScrollView myScrollView, int l, int t, int oldl, int oldt) {
               if(detailFragment1.getView().getMeasuredHeight()<t){
                   tuangou_btt.setVisibility(View.VISIBLE);
               }else {
                   tuangou_btt.setVisibility(View.GONE);
               }
           }
       });
    }
    private void newData(){
        HttpHelper.getDataCarDetail(Id, brandId, "156", new HttpCallBack<DetailResultBean>() {
            @Override
            public void onSuccess(DetailResultBean result) {
                if(result != null){
                    detailFragment1.getdata(cityName,result.result);
                    detailFragment2.setData(result.result.tcbzDesc);
                    detailFragment3.setdata(result.result);
                    detailFragment4.setdata(result.result,cityid);
                    detailFragment5.setdata(result.result);
                }
                detailFragment1.getdata(cityName,result.result);
                detailFragment2.setData(result.result.tcbzDesc);
                detailFragment3.setdata(result.result);
                detailFragment4.setdata(result.result,cityid);
                detailFragment5.setdata(result.result);
            }

            @Override
            public void onFail(String errMsg) {
            }
        });

        HttpHelper.getDataCarByBrand("0", "156", brandId, new HttpCallBack<ResultBean>() {
            @Override
            public void onSuccess(ResultBean result) {
                popwindow_samebrand.setPopData(result);
            }
            @Override
            public void onFail(String errMsg) {

            }
        });
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_back_detail:
                this.finish();
            break;
            case R.id.search_tv:
                sharePopWindow.showPopWindow();
            break;
            case R.id.tuangou_btt:
                scrollView.scrollTo(0,0);
                tuangou_btt.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void showPopwindow() {

    }
}
