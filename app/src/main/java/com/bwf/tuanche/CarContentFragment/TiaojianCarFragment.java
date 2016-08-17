package com.bwf.tuanche.CarContentFragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwf.framwork.base.BaseBean;
import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.R;
import com.bwf.tuanche.eneity.TiaojianCar.CarTJResultBean;


public class TiaojianCarFragment extends BaseFragment {

    private TiaojianFragment01 tiaojianFragment01;
    @Override
    protected int getResource() {
        return R.layout.fragment_tiaojian_car;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        tiaojianFragment01 = (TiaojianFragment01) getChildFragmentManager().findFragmentById(R.id.jibie_tiaojianCar);
    }

    @Override
    protected void initData() {
        getCarParms();
    }

    /**
     * 请求选车级别、国产、排量等数据
     */
    public void getCarParms(){
        HttpHelper.getDataSelectCarByParams(new HttpCallBack<CarTJResultBean>() {
            @Override
            public void onSuccess(CarTJResultBean result) {
                if(result != null){
                    tiaojianFragment01.setLevle(result.result.bos);
                }
            }

            @Override
            public void onFail(String errMsg) {
                ToastUtil.showToast(errMsg);
            }
        });
    }


    @Override
    public void onClick(View view) {

    }
}
