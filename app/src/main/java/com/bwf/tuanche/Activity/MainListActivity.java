package com.bwf.tuanche.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpCallBackArray;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.DrawableUtils;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.R;
import com.bwf.tuanche.eneity.Banner.BannerResult;
import com.bwf.tuanche.eneity.TuanChe.TuanCheResult;
import com.bwf.tuanche.eneity.hotcartype.HotCarResultBean;
import com.bwf.tuanche.eneity.hotlogo.Result;
import com.bwf.tuanche.fragment.MainlistFragment.MainListFragment_1;
import com.bwf.tuanche.fragment.MainlistFragment.MainListFragment_2;
import com.bwf.tuanche.fragment.MainlistFragment.MainListFragment_3;
import com.bwf.tuanche.fragment.MainlistFragment.MainListFragment_4;

import java.util.List;

public class MainListActivity extends BaseActivity {

    private MainListFragment_1 mainListFragment_1;

    private MainListFragment_2 mainListFragment_2;

    private MainListFragment_3 mainListFragment_3;

    private MainListFragment_4 mainListFragment_4;

    private LinearLayout ll_con1,ll_con2,ll_con3;

    private String cityName,cityId;

    private TextView main_page,main_dingdan,main_kefu,main_wode,content_city;

    private int[] select_ids=new int[]{R.mipmap.nav_icon_home_sel,R.mipmap.nav_icon_order_sel,R.mipmap.nav_icon_server_sel,R.mipmap.nav_icon_my_sel};

    private int[] normal_ids=new int[]{R.mipmap.nav_icon_home_nor,R.mipmap.nav_icon_order_nor,R.mipmap.nav_icon_server_nor,R.mipmap.nav_icon_my_nor};

    private TextView[] textViews;

    private EditText ed_search;

    private boolean page=true,dingdan=false,kefu=false,wode=false;

    @Override
    public int getContentViewId() {
        return R.layout.activity_main_list;
    }

    @Override
    public void beforeInitView() {
        cityName = getIntent().getStringExtra("cityName");
        cityId = getIntent().getStringExtra("cityId");
        cityName = cityName==null?"北京":cityName;
        cityId =cityId ==null?"156":cityId;
    }

    @Override
    public void initView() {
        mainListFragment_1= (MainListFragment_1) getSupportFragmentManager().findFragmentById(R.id.main_list_frag1);
        mainListFragment_2= (MainListFragment_2) getSupportFragmentManager().findFragmentById(R.id.main_list_frag2);
        mainListFragment_3= (MainListFragment_3) getSupportFragmentManager().findFragmentById(R.id.main_list_frag3);
        mainListFragment_4= (MainListFragment_4) getSupportFragmentManager().findFragmentById(R.id.main_list_frag4);
        ll_con1= (LinearLayout) findViewById(R.id.ll_con1);
        ll_con2= (LinearLayout) findViewById(R.id.ll_con2);
        ll_con3= (LinearLayout) findViewById(R.id.ll_con3);
        content_city=findViewByIdNoCast(R.id.content_city);
        ed_search=findViewByIdNoCast(R.id.search_ed);
        main_page=findViewByIdNoCast(R.id.main_page);
        main_dingdan=findViewByIdNoCast(R.id.main_dingdan);
        main_kefu=findViewByIdNoCast(R.id.main_kefu);
        main_wode=findViewByIdNoCast(R.id.main_wode);
        textViews=new TextView[]{main_page,main_dingdan,main_kefu,main_wode};
        setOnClick(main_page,main_dingdan,main_kefu,main_wode,ed_search);
    }

    @Override
    public void initData() {
        content_city.setText(cityName);
        getData();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.main_page:
                if(page==true){
                    return;
                }else {
                    page=true;
                    dingdan=false;
                    kefu=false;
                    wode=false;
                    ll_con1.setVisibility(View.VISIBLE);
                    ll_con2.setVisibility(View.GONE);
                    ll_con3.setVisibility(View.GONE);
                    setSelect(0);
                }
                 break;
            case R.id.main_dingdan:
                if(dingdan==true){
                    return;
                }else {
                    page=false;
                    dingdan=true;
                    kefu=false;
                    wode=false;
                    ll_con1.setVisibility(View.GONE);
                    ll_con2.setVisibility(View.GONE);
                    ll_con3.setVisibility(View.GONE);
                    setSelect(1);
                }
                 break;
            case R.id.main_kefu:
                if(kefu==true){
                    return;
                }else {
                    page=false;
                    dingdan=false;
                    kefu=true;
                    wode=false;
                    ll_con1.setVisibility(View.GONE);
                    ll_con2.setVisibility(View.VISIBLE);
                    ll_con3.setVisibility(View.GONE);
                    setSelect(2);
                }
                 break;
            case R.id.main_wode:
                if(wode==true){
                    return;
                }else {
                    page=false;
                    dingdan=false;
                    kefu=false;
                    wode=true;
                    ll_con1.setVisibility(View.GONE);
                    ll_con2.setVisibility(View.GONE);
                    ll_con3.setVisibility(View.VISIBLE);
                    setSelect(3);
                }
                 break;
            case R.id.search_ed:
                Intent intent=new Intent(this,HotSearch_Activity.class);
                startActivity(intent);
                break;

        }
    }
    public void getData(){
        /**
         * 底价购车
         */
        HttpHelper.getDataAtCity(cityId, new HttpCallBack<TuanCheResult>() {
            @Override
            public void onSuccess(TuanCheResult result) {
                if(result.result!=null)
                mainListFragment_1.setData(result);
                else LogUtils.e("onSuccess__"+ "为空");
            }
            @Override
            public void onFail(String errMsg) {
                ToastUtil.showToast("失败");
            }
        });

        /**
         * 热门品牌l
         */
        HttpHelper.getDataHotLogo("2", cityId, new HttpCallBack<Result>() {
            @Override
            public void onSuccess(Result result) {
                if(result!=null)
                mainListFragment_2.getData(result);
                else LogUtils.e("onSuccess__"+ "为空");
            }

            @Override
            public void onFail(String errMsg) {

            }
        });

        /**
         * 首页品牌
         */
        HttpHelper.getDataHomePageBanner(cityId, new HttpCallBack<BannerResult>() {
            @Override
            public void onSuccess(BannerResult result) {
                if(result.result!=null){
                    mainListFragment_1.getBigBanner(result.result.header_banner.get(0).adImgUrl);
                    mainListFragment_3.setData(result.result.center_banner,result.result.position_banner);
                }
            }

            @Override
            public void onFail(String errMsg) {

            }
        });
        /**
         *
         */
        HttpHelper.getDataHotCarType("20", "10", cityId, new HttpCallBackArray<HotCarResultBean>() {
            @Override
            public void onSuccess(List<HotCarResultBean> result) {
                if(result!=null)
                mainListFragment_4.setData(result);
            }

            @Override
            public void onFail(String errMsg) {
                LogUtils.e(errMsg+"TTTTTTTTTT");
            }
        });
    }
    public void setSelect(int postion) {
        for (int i = 0; i < textViews.length; i++) {
            if (i == postion) {
                textViews[i].setTextColor(Color.parseColor("#D02B14"));
//                Drawable drawable = ContextCompat.getDrawable(MainActivity.this, select_ids[i]);
//                drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
//                textViews[i].setCompoundDrawables(drawable,null,null,null);
                DrawableUtils.drawableTop(MainListActivity.this, textViews[i], select_ids[i]);
            } else {
                textViews[i].setTextColor(Color.parseColor("#939393"));
                DrawableUtils.drawableTop(MainListActivity.this, textViews[i], normal_ids[i]);
            }
        }

    }
}
