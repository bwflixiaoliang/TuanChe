package com.bwf.tuanche.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpCallBackArray;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.share.SharePrefreceHelper;
import com.bwf.framwork.tools.RequestAndResultCode;
import com.bwf.framwork.utils.DrawableUtils;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.R;
import com.bwf.tuanche.View.LoadAnimation;
import com.bwf.tuanche.View.LocationCityChangeDialog;
import com.bwf.tuanche.View.ReScrollView;
import com.bwf.tuanche.View.VersionUpdateDialog;
import com.bwf.tuanche.eneity.Banner.BannerResult;
import com.bwf.tuanche.eneity.TuanChe.TuanCheResult;
import com.bwf.tuanche.eneity.hotcartype.HotCarResultBean;
import com.bwf.tuanche.eneity.hotlogo.ResultBean;
import com.bwf.tuanche.eneity.location.LocationBean;
import com.bwf.tuanche.fragment.MainlistFragment.MainListFragment_1;
import com.bwf.tuanche.fragment.MainlistFragment.MainListFragment_2;
import com.bwf.tuanche.fragment.MainlistFragment.MainListFragment_3;
import com.bwf.tuanche.fragment.MainlistFragment.MainListFragment_4;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import java.util.List;

public class MainListActivity extends BaseActivity {
    private MainListFragment_1 mainListFragment_1;
    private MainListFragment_2 mainListFragment_2;
    private MainListFragment_3 mainListFragment_3;
    private MainListFragment_4 mainListFragment_4;
    private LinearLayout ll_con1, ll_con2, ll_con3, title;
    private String cityName, cityId;
    private TextView main_page, main_dingdan, main_kefu, main_wode, content_city,lastCityName;
    private int[] select_ids = new int[]{R.mipmap.nav_icon_home_sel, R.mipmap.nav_icon_order_sel, R.mipmap.nav_icon_server_sel, R.mipmap.nav_icon_my_sel};
    private int[] normal_ids = new int[]{R.mipmap.nav_icon_home_nor, R.mipmap.nav_icon_order_nor, R.mipmap.nav_icon_server_nor, R.mipmap.nav_icon_my_nor};
    private TextView[] textViews;
    private ReScrollView scrollView;
    private EditText ed_search;
    private LocationBean.LocationCity locationCity;
    private boolean page = true, dingdan = false, kefu = false, wode = false,isLocation;

    //跳转低价购车页面
    private ImageView dijia;

    @Override
    public int getContentViewId() {
        return R.layout.activity_main_list;
    }

    @Override
    public void beforeInitView() {
        locationCity = (LocationBean.LocationCity) getIntent().getSerializableExtra("locationCity");
        cityName = getIntent().getStringExtra("cityName");
        cityId = getIntent().getStringExtra("cityId");
        if(locationCity==null||locationCity.name.trim().equals(cityName))isLocation=true;
        else isLocation = false;
    }

    @Override
    public void initView() {
        //跳转低价购车页面
        dijia = findViewByIdNoCast(R.id.dijia);
        setOnClick(dijia);
        ll_con1 = (LinearLayout) findViewById(R.id.ll_con1);
        ll_con2 = (LinearLayout) findViewById(R.id.ll_con2);
        ll_con3 = (LinearLayout) findViewById(R.id.ll_con3);
        title = findViewByIdNoCast(R.id.mainList_title);
        scrollView = (ReScrollView) findViewById(R.id.scrollView);
        scrollView.setContentResource(R.layout.content_test);
        scrollView.setOnPullListenr(pullListenr);
        content_city=findViewByIdNoCast(R.id.content_city);
        lastCityName = findViewByIdNoCast(R.id.mainList_tvlastCity);
        setOnClick(R.id.mainList_Zxing);
        content_city.setOnClickListener(this);
        ed_search = findViewByIdNoCast(R.id.search_ed);
        main_page = findViewByIdNoCast(R.id.main_page);
        main_dingdan = findViewByIdNoCast(R.id.main_dingdan);
        main_kefu = findViewByIdNoCast(R.id.kefu);
        main_wode = findViewByIdNoCast(R.id.wode);
        animation = findViewByIdNoCast(R.id.mainList_loadAnimation);
        mainListFragment_1 = (MainListFragment_1) getSupportFragmentManager().findFragmentById(R.id.main_list_frag1);
        mainListFragment_2 = (MainListFragment_2) getSupportFragmentManager().findFragmentById(R.id.main_list_frag2);
        mainListFragment_3 = (MainListFragment_3) getSupportFragmentManager().findFragmentById(R.id.main_list_frag3);
        mainListFragment_4 = (MainListFragment_4) getSupportFragmentManager().findFragmentById(R.id.main_list_frag4);
        mainListFragment_1.setCityId(cityId);
        textViews = new TextView[]{main_page, main_dingdan, main_kefu, main_wode};
        setOnClick(main_page, main_dingdan, main_kefu, main_wode, ed_search);
    }

    @Override
    public void initData() {
        content_city.setText(cityName);
        lastCityName.setText(cityName);
        startLoadAnimation();
        getData();
        if(!isLocation)new LocationCityChangeDialog(MainListActivity.this,locationCity.name,changeCityListener).show();
        new VersionUpdateDialog(this);
    }
    //带结果跳转
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        LogUtils.i("msg", "onActivityResult--->resultCode:" + resultCode);
        if (requestCode == RequestAndResultCode.MainListrequestCode) {
            switch (resultCode) {
                case RequestAndResultCode.CityListResultCode:
                    if (data != null) {
                        cityName = data.getStringExtra("cityName");
                        cityId = data.getStringExtra("cityId");
                        if (cityId != null) {
                            LogUtils.i("msg", "onActivityResult--->+cityName:" + cityId);
                            content_city.setText(cityName);
                            lastCityName.setText(cityName);
                            mainListFragment_1.setCityId(cityId);
                            startLoadAnimation();
                            getData();
                        }
                    }
                    break;
                case RESULT_OK:
                    break;
            }
        }
    }


    @Override
    protected void onDestroy() {
        mHandler.removeCallbacksAndMessages(null);
        animation.release();
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("currentCity", cityName);
        bundle.putString("cityId", cityId);
        switch (view.getId()) {
            case R.id.main_page:
                if (page == true) {
                    return;
                } else {
                    page = true;
                    dingdan = false;
                    kefu = false;
                    wode = false;
                    if (!isComplete)
                        title.setVisibility(View.VISIBLE);
                    else
                        ll_con1.setVisibility(View.VISIBLE);
                    ll_con2.setVisibility(View.GONE);
                    ll_con3.setVisibility(View.GONE);
                    setSelect(0);
                }
                break;
            case R.id.main_dingdan:
                if (dingdan == true) {
                    return;
                } else {
                    page = false;
                    dingdan = true;
                    kefu = false;
                    wode = false;
                    if (!isComplete)
                        title.setVisibility(View.GONE);
                    else
                        ll_con1.setVisibility(View.GONE);
                    ll_con2.setVisibility(View.GONE);
                    ll_con3.setVisibility(View.GONE);
                    setSelect(1);
                }
                break;
            case R.id.kefu:
                if (kefu == true) {
                    return;
                } else {
                    page = false;
                    dingdan = false;
                    kefu = true;
                    wode = false;
                    if (!isComplete)
                        title.setVisibility(View.GONE);
                    else
                        ll_con1.setVisibility(View.GONE);
                    ll_con2.setVisibility(View.VISIBLE);
                    ll_con3.setVisibility(View.GONE);
                    setSelect(2);
                }
                break;
            case R.id.wode:
                if (wode == true) {
                    return;
                } else {
                    page = false;
                    dingdan = false;
                    kefu = false;
                    wode = true;
                    if (!isComplete)
                        title.setVisibility(View.GONE);
                    else
                        ll_con1.setVisibility(View.GONE);
                    ll_con2.setVisibility(View.GONE);
                    ll_con3.setVisibility(View.VISIBLE);
                    setSelect(3);
                }
                break;
            case R.id.mainList_Zxing:
                IntentUtils.openActivityWithResult(this,CaptureActivity.class, RequestAndResultCode.MainListrequestCode,null);
                break;
            case R.id.search_ed:
                IntentUtils.openActivityWithResult(this, HotSearch_Activity.class, RequestAndResultCode.MainListrequestCode, bundle);
                break;
            case R.id.content_city:
                IntentUtils.openActivityWithResult(this, CityListActivity.class, RequestAndResultCode.MainListrequestCode, bundle);
                break;
            case R.id.dijia://跳转低价购车页面
                IntentUtils.openActivity(this, CarContentActivity.class, bundle);
                break;

        }
    }

    public void getData() {
        count = 0;
        isComplete = false;
        /**
         * 底价购车
         */
        HttpHelper.getDataAtCity(cityId, new HttpCallBack<TuanCheResult>() {
            @Override
            public void onSuccess(TuanCheResult result) {
                if (result.result != null) {
                    mainListFragment_1.setData(result);
                    mHandler.sendEmptyMessage(1);
                } else mHandler.sendEmptyMessage(2);
            }

            @Override
            public void onFail(String errMsg) {
                mHandler.sendEmptyMessage(2);
            }
        });

        /**
         * 热门品牌l
         */
        HttpHelper.getDataHotLogo("2", cityId, new HttpCallBack<ResultBean>() {
            @Override
            public void onSuccess(ResultBean result) {
                if (result != null) {
                    mHandler.sendEmptyMessage(1);
                    mainListFragment_2.getData(result,cityName,cityId);
                }
                else mHandler.sendEmptyMessage(2);;
                if(result!=null)
                mainListFragment_2.getData(result,cityName,cityId);
                else LogUtils.e("onSuccess__"+ "为空");
            }

            @Override
            public void onFail(String errMsg) {
                mHandler.sendEmptyMessage(2);
                ;
            }
        });

        /**
         * 首页品牌
         */
        HttpHelper.getDataHomePageBanner(cityId, new HttpCallBack<BannerResult>() {
            @Override
            public void onSuccess(BannerResult result) {
                if (result.result != null) {
                    mainListFragment_1.getBigBanner(result.result.header_banner.get(0).adImgUrl);
                    mainListFragment_3.setData(result.result.center_banner, result.result.position_banner);
                    mHandler.sendEmptyMessage(1);
                } else mHandler.sendEmptyMessage(2);
            }

            @Override
            public void onFail(String errMsg) {
                mHandler.sendEmptyMessage(2);
            }
        });
        /**
         *
         */
        HttpHelper.getDataHotCarType("20", "10", cityId, new HttpCallBackArray<HotCarResultBean>() {
            @Override
            public void onSuccess(List<HotCarResultBean> result) {
                if(result!=null){
                    mainListFragment_4.setData(result,cityName,cityId);
                    mHandler.sendEmptyMessage(1);
                }else mHandler.sendEmptyMessage(2);
                if(result!=null)
                mainListFragment_4.setData(result,cityName,cityId);
            }

            @Override
            public void onFail(String errMsg) {
                mHandler.sendEmptyMessage(2);
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

    //数据加载动画
    private LoadAnimation animation;
    private LoadAnimation.LoadListener loadListener;
    private int count = 0;
    private boolean isComplete = false;
    private void startLoadAnimation() {
        if (animation == null) return;
        title.setVisibility(View.VISIBLE);
        ll_con1.setVisibility(View.GONE);
        if (loadListener == null) {
            loadListener = new LoadAnimation.LoadListener() {
                @Override
                public void reLoad() {
                    startLoadAnimation();
                    getData();
                }
            };
            animation.setListener(loadListener);
        } else animation.startLoadAnimation();
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    if (!isComplete) {
                        animation.successLoad();
                        title.setVisibility(View.GONE);
                        ll_con1.setVisibility(View.VISIBLE);
                        isComplete = true;
                        scrollView.refreshComplete();
                    }
                    break;
                case 2:
                    count++;
                    if (count == 4) {
                        title.setVisibility(View.VISIBLE);
                        ll_con1.setVisibility(View.GONE);
                        animation.failLoadNoNetWork(loadListener);
                        scrollView.refreshComplete();
                    }
                    break;
                case 3:
                    isExit = false;
                    break;
            }
            super.handleMessage(msg);
        }
    };
    //下拉刷新监听
    private ReScrollView.PullListenr pullListenr = new ReScrollView.PullListenr() {
        @Override
        public void refresh() {
            getData();
        }
    };
   //改变城市监听
    private LocationCityChangeDialog.DialogOnClickListener changeCityListener = new LocationCityChangeDialog.DialogOnClickListener() {
       @Override
       public void changeCity() {
           ToastUtil.showToast("改变城市");
           if(locationCity==null)return;
            cityName = locationCity.name;
            cityId = locationCity.id;
            content_city.setText(cityName);
            lastCityName.setText(cityName);
            getData();
       }
   };
    //再按一下退出；
    private boolean isExit;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_BACK) {
            if (!isExit) {
                mHandler.sendEmptyMessageDelayed(3, 2000);
                ToastUtil.showToast("再按一次退出");
                isExit = true;
            } else {
                SharePrefreceHelper.getInstence(this).setLastCity(cityName, cityId);
                System.exit(1);
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
