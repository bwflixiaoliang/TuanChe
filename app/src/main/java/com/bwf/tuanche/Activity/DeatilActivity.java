package com.bwf.tuanche.Activity;


import android.app.Notification;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.tuanche.R;
import com.bwf.tuanche.View.Popwindow_buycarStyle;
import com.bwf.tuanche.View.SharePopWindow;
import com.bwf.tuanche.eneity.detail.DetailResultBean;
import com.bwf.tuanche.eneity.hotlogo.HotLogo;
import com.bwf.tuanche.fragment.DetailFramgent.DetailFragment1;
import com.bwf.tuanche.fragment.DetailFramgent.DetailFragment2;
import com.bwf.tuanche.fragment.DetailFramgent.DetailFragment3;
import com.bwf.tuanche.fragment.DetailFramgent.DetailFragment4;
import com.bwf.tuanche.fragment.DetailFramgent.DetailFragment5;

public class DeatilActivity extends BaseActivity {
    private ScrollView scrollView;

    private RelativeLayout main;

    private ImageView img_back_detail;

    private HotLogo hotLogo;

    private TextView carname;

    private ImageView search_tv;

    private String cityName,thecarname;

    private DetailFragment1 detailFragment1;

    private DetailFragment2 detailFragment2;

    private DetailFragment3 detailFragment3;

    private DetailFragment4 detailFragment4;

    private DetailFragment5 detailFragment5;

    @Override
    public int getContentViewId() {
        return R.layout.activity_deatil;
    }

    @Override
    public void beforeInitView() {
         hotLogo= (HotLogo) getIntent().getExtras().getSerializable("res");
        cityName=getIntent().getStringExtra("cityname");
        thecarname=getIntent().getStringExtra("carname");
    }

    @Override
    public void initView() {
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
        carname.setText(String.format(carname.getText().toString(),thecarname,cityName+"站"));
        newData();

    }
    private void newData(){
        HttpHelper.getDataCarDetail("166", "31", "156", new HttpCallBack<DetailResultBean>() {
            @Override
            public void onSuccess(DetailResultBean result) {
                if(result != null){
                    detailFragment1.getdata(hotLogo,result.result);
                    detailFragment2.setData(result.result.tcbzDesc);
                    detailFragment3.setdata(result.result);
                    detailFragment4.setdata(result.result);
                    detailFragment5.setdata(result.result);
                }
            }

            @Override
            public void onFail(String errMsg) {
                LogUtils.e("TTTT"+errMsg);
            }
        });
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_back_detail:
                Intent intent=new Intent(this,MainListActivity.class);
                startActivity(intent);
            break;
            case R.id.search_tv:
                SharePopWindow sharePopWindow = new SharePopWindow(this);
                sharePopWindow.showPopWindow();
            break;
        }
    }


}
