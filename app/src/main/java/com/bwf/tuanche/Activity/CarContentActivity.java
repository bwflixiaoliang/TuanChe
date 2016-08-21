package com.bwf.tuanche.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.Adatper.CarHotRecyclerAdatper;
import com.bwf.tuanche.Adatper.CarViewPragerAdapter;
import com.bwf.tuanche.fragment.CarContentFragment.LogoCarFragment;
import com.bwf.tuanche.fragment.CarContentFragment.TiaojianCarFragment;
import com.bwf.tuanche.R;
import com.bwf.tuanche.View.MyPopWindow;
import com.bwf.tuanche.eneity.hotlogo.HotLogo;
import com.bwf.tuanche.eneity.hotlogo.ResultBean;
import com.bwf.tuanche.eneity.logocarlist.LogoCarListBean;
import com.bwf.tuanche.eneity.logocarlist.LogoCarListResult;

import java.util.ArrayList;
import java.util.List;

public class CarContentActivity extends BaseActivity{

    private ImageView content_back,content_search;
    private Button Loge_car,Tiaojian_car;
    private LinearLayout car_content_tietle;

    private ViewPager logo_tiaojian_car;
    private List<Fragment> fargments;
    private CarViewPragerAdapter pragerAdapter;
    private String isBuy;
    private String cityId;

    //Fragment对象
    private LogoCarFragment logoCarFragment;
    private TiaojianCarFragment tiaojianCarFragment;

    @Override
    public int getContentViewId() {
        return R.layout.activity_car_content;
    }

    @Override
    public void beforeInitView() {
        isBuy = "2";
        cityId = "156";
        fargments = new ArrayList<>();
    }

    @Override
    public void initView() {
        car_content_tietle = findViewByIdNoCast(R.id.car_content_tietle);
        content_back = findViewByIdNoCast(R.id.content_back);
        Loge_car = findViewByIdNoCast(R.id.Loge_car);
        Tiaojian_car = findViewByIdNoCast(R.id.Tiaojian_car);
        content_search = findViewByIdNoCast(R.id.content_search);
        logo_tiaojian_car = findViewByIdNoCast(R.id.logo_tiaojian_car);
    }

    @Override
    public void initData() {
        setOnClick(R.id.content_back,R.id.Loge_car,R.id.Tiaojian_car,R.id.content_search);
        logoCarFragment=  new LogoCarFragment();
        tiaojianCarFragment = new TiaojianCarFragment();
        fargments.add(logoCarFragment);
        fargments.add(tiaojianCarFragment);
        pragerAdapter = new CarViewPragerAdapter(getSupportFragmentManager(),fargments);
        logo_tiaojian_car.setAdapter(pragerAdapter);
        logo_tiaojian_car.setCurrentItem(0);

        //ViewParger的滑动监听
        logo_tiaojian_car.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                if(position == 0){
                    Loge_car.setBackgroundResource(R.mipmap.round_red_left);
                    Loge_car.setTextColor(getResources().getColor(R.color.white));
                    Tiaojian_car.setBackgroundResource(R.mipmap.round_white_right);
                    Tiaojian_car.setTextColor(getResources().getColor(R.color.read));
                }else if(position == 1 ){
                    Loge_car.setBackgroundResource(R.mipmap.round_white_left);
                    Loge_car.setTextColor(getResources().getColor(R.color.read));
                    Tiaojian_car.setBackgroundResource(R.mipmap.round_red_right);
                    Tiaojian_car.setTextColor(getResources().getColor(R.color.white));
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //请求数据
        getHotLogo();
        getLogoCar();

        //点击品牌列表弹出PopWindow
        logoCarFragment.setCallBack(new LogoCarFragment.CarListCallBack() {
            @Override
            public void getPopWindow(LogoCarListBean carListBean) {
                if(carListBean != null){
                    MyPopWindow myPopWindow = new MyPopWindow(CarContentActivity.this,carListBean,cityId);
                    myPopWindow.showPopWindow(car_content_tietle);
                }
            }
        });

        //点击热门品牌弹出PopWindow
        logoCarFragment.setRecycleBack(new CarHotRecyclerAdatper.CallRecycleBack() {
            @Override
            public void callRecyclePop(HotLogo hotLogo) {
                if(hotLogo != null){
                    MyPopWindow myPopWindow02 = new MyPopWindow(CarContentActivity.this,hotLogo,cityId);
                    myPopWindow02.showPopWindow(car_content_tietle);
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.content_back://点击返回
                IntentUtils.openActivity(this,MainActivity.class);
                break;
            case R.id.Loge_car://品牌选车
                Loge_car.setBackgroundResource(R.mipmap.round_red_left);
                Loge_car.setTextColor(getResources().getColor(R.color.white));
                Tiaojian_car.setBackgroundResource(R.mipmap.round_white_right);
                Tiaojian_car.setTextColor(getResources().getColor(R.color.read));
                logo_tiaojian_car.setCurrentItem(0);
                break;
            case R.id.Tiaojian_car://条件选车
                Loge_car.setBackgroundResource(R.mipmap.round_white_left);
                Loge_car.setTextColor(getResources().getColor(R.color.read));
                Tiaojian_car.setBackgroundResource(R.mipmap.round_red_right);
                Tiaojian_car.setTextColor(getResources().getColor(R.color.white));
                logo_tiaojian_car.setCurrentItem(1);
                break;
            case R.id.content_search://点击搜索
                IntentUtils.openActivity(this,CarSearchActivity.class);
                break;
        }
    }


    /**
     * 请求热门品牌参数
     */
    public void getHotLogo(){
        //加载热门品牌数据，热门品牌数据请求方法 ?isBuy=2&cityId=156
        HttpHelper.getDataHotLogo(isBuy, cityId, new HttpCallBack<ResultBean>() {
            @Override
            public void onSuccess(ResultBean resultBean) {
                if(resultBean != null ){
                    logoCarFragment.setList(resultBean.result.list);
                }
            }
            @Override
            public void onFail(String errMsg) {
                ToastUtil.showToast(errMsg);
            }
        });
    }

    /**
     * 请求品牌列表参数
     */
    public void getLogoCar(){
        HttpHelper.getDataCarList(cityId, new HttpCallBack<LogoCarListResult>() {
            @Override
            public void onSuccess(LogoCarListResult result) {
                if(result != null){
                    logoCarFragment.setResult(result.result);
                }
            }
            @Override
            public void onFail(String errMsg) {

            }
        });
    }

}
