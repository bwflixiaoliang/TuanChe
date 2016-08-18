package com.bwf.tuanche.CarContentFragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bwf.framwork.base.BaseBean;
import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.Activity.CarScreenActivity;
import com.bwf.tuanche.R;
import com.bwf.tuanche.eneity.TiaojianCar.CarTJResultBean;


public class TiaojianCarFragment extends BaseFragment{

    private TiaojianFragment01 tiaojianFragment01;
    private TiaojianFragment02 tiaojianFragment02;
    private TiaojianFragment03  tiaojianFragment03;
    private Button tiaojian_rester,tiaojian_commit;

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
        tiaojianFragment02 = (TiaojianFragment02) getChildFragmentManager().findFragmentById(R.id.guochan_tiaojianCar);
        tiaojianFragment03 = (TiaojianFragment03) getChildFragmentManager().findFragmentById(R.id.pailiang_tiaojianCar);
        tiaojian_rester = findViewByIdNoCast(R.id.tiaojian_rester);
        tiaojian_commit = findViewByIdNoCast(R.id.tiaojian_commit);
        setOnClick(R.id.tiaojian_commit);
        setOnClick(R.id.tiaojian_rester);
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
                    //传递条件选车级别
                    tiaojianFragment01.setLevle(result.result.bos);
                    //传递条件选车国产等
                    tiaojianFragment02.setSeries(result.result.series);
                    //传递排量参数
                    tiaojianFragment03.setLevle(result.result.levle);
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
        switch (view.getId()){
            case R.id.tiaojian_rester://点击重置

                break;
            case R.id.tiaojian_commit://点击提交
                IntentUtils.openActivity(getContext(), CarScreenActivity.class);
                //传递中的参数传递


                break;
        }
    }
}
