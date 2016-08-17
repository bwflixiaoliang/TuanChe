package com.bwf.tuanche.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.tuanche.Adatper.CarViewPragerAdapter;
import com.bwf.tuanche.CarContentFragment.LogoCarFragment;
import com.bwf.tuanche.CarContentFragment.TiaojianCarFragment;
import com.bwf.tuanche.R;

import java.util.ArrayList;
import java.util.List;

public class CarContentActivity extends BaseActivity {

    private ImageView content_back,content_search;
    private Button Loge_car,Tiaojian_car;

    private ViewPager logo_tiaojian_car;
    private List<Fragment> fargments;
    private CarViewPragerAdapter pragerAdapter;

    @Override
    public int getContentViewId() {
        return R.layout.activity_car_content;
    }

    @Override
    public void beforeInitView() {
        fargments = new ArrayList<>();
    }

    @Override
    public void initView() {
        content_back = findViewByIdNoCast(R.id.content_back);
        Loge_car = findViewByIdNoCast(R.id.Loge_car);
        Tiaojian_car = findViewByIdNoCast(R.id.Tiaojian_car);
        content_search = findViewByIdNoCast(R.id.content_search);
        logo_tiaojian_car = findViewByIdNoCast(R.id.logo_tiaojian_car);
    }

    @Override
    public void initData() {
        setOnClick(R.id.content_back,R.id.Loge_car,R.id.Tiaojian_car,R.id.content_search);
        fargments.add(new LogoCarFragment());
        fargments.add(new TiaojianCarFragment());
        pragerAdapter = new CarViewPragerAdapter(getSupportFragmentManager(),fargments);
        logo_tiaojian_car.setAdapter(pragerAdapter);
        logo_tiaojian_car.setCurrentItem(0);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.content_back://点击返回
                IntentUtils.openActivity(this,MainActivity.class);
                break;
            case R.id.Loge_car:
                Loge_car.setBackgroundResource(R.mipmap.round_red_left);
                Loge_car.setTextColor(getResources().getColor(R.color.white));
                Tiaojian_car.setBackgroundResource(R.mipmap.round_white_right);
                Tiaojian_car.setTextColor(getResources().getColor(R.color.read));
                logo_tiaojian_car.setCurrentItem(0);
                break;
            case R.id.Tiaojian_car:
                Loge_car.setBackgroundResource(R.mipmap.round_white_left);
                Loge_car.setTextColor(getResources().getColor(R.color.read));
                Tiaojian_car.setBackgroundResource(R.mipmap.round_red_right);
                Tiaojian_car.setTextColor(getResources().getColor(R.color.white));
                logo_tiaojian_car.setCurrentItem(1);
                break;
            case R.id.content_search://点击搜索


                break;
        }
    }

}
