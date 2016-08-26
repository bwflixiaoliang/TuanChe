package com.bwf.tuanche.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.base.BaseBean;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.Adatper.MyMarriageListAdapter;
import com.bwf.tuanche.R;
import com.bwf.tuanche.View.PullToReflushListView;
import com.bwf.tuanche.eneity.mymarriagecar.CarStyleResult;

public class MarriageCarActivity extends BaseActivity{

    private PullToReflushListView reflushListView;
    private MyMarriageListAdapter listAdapter;

    @Override
    public int getContentViewId() {
        return R.layout.activity_marriage_car;
    }

    @Override
    public void beforeInitView() {
        listAdapter = new MyMarriageListAdapter(this);
    }

    @Override
    public void initView() {
        reflushListView = findViewByIdNoCast(R.id.marriage_listview001);
        reflushListView.setAdapter(listAdapter);
    }

    @Override
    public void initData() {
        getMarriageCar();
        reflushListView.setOnReflushListener(new PullToReflushListView.OnReflushListener() {
            @Override
            public void onReflush() {
                getMarriageCar();
                reflushListView.reflushComplete();
            }
        });
    }

    @Override
    public void onClick(View view) {

    }

    //请求婚姻座驾的数据
    private void getMarriageCar(){
        HttpHelper.getMarriageData(new HttpCallBack<CarStyleResult>() {
            @Override
            public void onSuccess(CarStyleResult MarrResult) {
                if(MarrResult != null){
                    listAdapter.settList(MarrResult.result.carstyleList);
                    listAdapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onFail(String errMsg) {

            }
        });
    }
}
