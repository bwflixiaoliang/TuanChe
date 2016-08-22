package com.bwf.tuanche.Activity;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.map.MapLocation;
import com.bwf.framwork.share.SharePrefreceHelper;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.Adatper.WelcomePagerAdapter;
import com.bwf.tuanche.R;
import com.bwf.tuanche.eneity.location.LocationBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.Map;

public class MainActivity extends BaseActivity implements Handler.Callback,BDLocationListener {
    private SimpleDraweeView startImage;
    private ViewPager guidePager;
    private Handler mHandler;
    private Map<String,String> cityMap;
    private boolean isFirst;
    private LocationBean.LocationCity locationCity;
    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void beforeInitView() {
        isFirst = SharePrefreceHelper.getInstence(this).isFirst();
        cityMap = SharePrefreceHelper.getInstence(this).getLastCity();
        if(!isFirst) new MapLocation().onCreate(getApplicationContext(),this);
    }

    @Override
    public void initView() {
        mHandler = new Handler(this);
        startImage = findViewByIdNoCast(R.id.welcome_startImage);
        guidePager = findViewByIdNoCast(R.id.welcome_guidePager);
        mHandler.sendEmptyMessageDelayed(1,3000);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public boolean handleMessage(Message message) {
        switch (message.what){
            case 1:
                if(isFirst){
                    startImage.setVisibility(View.GONE);
                    guidePager.setVisibility(View.VISIBLE);
                    guidePager.setAdapter(new WelcomePagerAdapter(this));
                }else{
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("locationCity",locationCity);
                    if(cityMap!=null){
                        bundle.putString("cityName",cityMap.get("cityName"));
                        bundle.putString("cityId",cityMap.get("cityId"));
                    }
                    IntentUtils.openActivity(this,MainListActivity.class,bundle);
                    finish();
                }
                break;
        }
        return false;
    }
    @Override
    protected void onDestroy() {
        mHandler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    @Override
    public void onReceiveLocation(BDLocation bdLocation) {
        Log.i("msg","<-------onReceiveLocation------->");
        if(bdLocation==null) return;
        if(bdLocation.getLocType()!=61&&bdLocation.getLocType()!=161) return;
        String  latitude = bdLocation.getLatitude()+"";
        String   longitude = bdLocation.getLongitude()+"";
        Log.i("msg","longitude-->"+longitude);
        HttpHelper.getDataNowCity(longitude,latitude, new HttpCallBack<LocationBean>() {
            @Override
            public void onSuccess(LocationBean result) {
                if(result!=null){
                    locationCity = result.result;
                }
            }
            @Override
            public void onFail(String errMsg) {
                ToastUtil.showToastLong(errMsg);
            }
        },this);
    }
}
