package com.bwf.tuanche.Activity;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.tuanche.Adatper.CarScreenAdapter;
import com.bwf.tuanche.R;
import com.bwf.tuanche.View.CarScreenListView;

public class CarScreenActivity extends BaseActivity {

    private ImageView shaixuan_back;
    private Button shaixuan_hotcar_but, shaixuan_picecar_but;
    private View hot_car_view, pice_car_view;
    private CarScreenListView screenListView;
    private CarScreenAdapter screenAdapter;

    @Override
    public int getContentViewId() {
        return R.layout.activity_car_screen;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        shaixuan_back = findViewByIdNoCast(R.id.shaixuan_back);
        shaixuan_hotcar_but = findViewByIdNoCast(R.id.shaixuan_hotcar_but);
        shaixuan_picecar_but = findViewByIdNoCast(R.id.shaixuan_picecar_but);
        hot_car_view = findViewByIdNoCast(R.id.hot_car_view);
        pice_car_view = findViewByIdNoCast(R.id.pice_car_view);
        screenListView = findViewByIdNoCast(R.id.car_screen_listview);
        setOnClick(R.id.shaixuan_back, R.id.shaixuan_hotcar_but, R.id.shaixuan_picecar_but);
    }

    @Override
    public void initData() {
        shaixuan_hotcar_but.setTextColor(Color.RED);
        hot_car_view.setBackgroundColor(Color.RED);
        screenAdapter = new CarScreenAdapter(CarScreenActivity.this);
        screenListView.setAdapter(screenAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.shaixuan_back:
                IntentUtils.openActivity(this, CarContentActivity.class);
                break;
            case R.id.shaixuan_hotcar_but:
                shaixuan_hotcar_but.setTextColor(Color.RED);
                hot_car_view.setBackgroundColor(Color.RED);
                shaixuan_picecar_but.setTextColor(Color.BLACK);
                pice_car_view.setBackgroundColor(Color.WHITE);
                break;
            case R.id.shaixuan_picecar_but:
                shaixuan_picecar_but.setTextColor(Color.RED);
                pice_car_view.setBackgroundColor(Color.RED);
                shaixuan_hotcar_but.setTextColor(Color.BLACK);
                hot_car_view.setBackgroundColor(Color.WHITE);
                break;
        }
    }
}
