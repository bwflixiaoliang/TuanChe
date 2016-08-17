package com.bwf.tuanche.Activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.tuanche.CarContentFragment.HotLogeFragment01;
import com.bwf.tuanche.R;

public class CarContentActivity extends BaseActivity {
    private ImageView content_back,content_search;
    private Button Loge_car,Tiaojian_car;
    private HotLogeFragment01 fragment01;

    @Override
    public int getContentViewId() {
        return R.layout.activity_car_content;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        content_back = findViewByIdNoCast(R.id.content_back);
        Loge_car = findViewByIdNoCast(R.id.Loge_car);
        Tiaojian_car = findViewByIdNoCast(R.id.Tiaojian_car);
        content_search = findViewByIdNoCast(R.id.content_search);
        fragment01 = (HotLogeFragment01) getSupportFragmentManager().findFragmentById(R.id.car_content_frag);
    }

    @Override
    public void initData() {
        setOnClick(R.id.content_back,R.id.Loge_car,R.id.Tiaojian_car,R.id.content_search);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.content_back:

                break;
            case R.id.Loge_car:
                Loge_car.setBackgroundResource(R.mipmap.round_red_left);
                Loge_car.setTextColor(getResources().getColor(R.color.white));
                Tiaojian_car.setBackgroundResource(R.mipmap.round_white_right);
                Tiaojian_car.setTextColor(getResources().getColor(R.color.read));
                break;
            case R.id.Tiaojian_car:
                Loge_car.setBackgroundResource(R.mipmap.round_white_left);
                Loge_car.setTextColor(getResources().getColor(R.color.read));
                Tiaojian_car.setBackgroundResource(R.mipmap.round_red_right);
                Tiaojian_car.setTextColor(getResources().getColor(R.color.white));
                break;
            case R.id.content_search:


                break;
        }
    }
}
