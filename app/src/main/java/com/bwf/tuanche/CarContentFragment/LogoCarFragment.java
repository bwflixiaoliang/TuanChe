package com.bwf.tuanche.CarContentFragment;

import android.view.View;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.R;
import com.bwf.tuanche.eneity.hotlogo.ResultBean;


public class LogoCarFragment extends BaseFragment {
    //这里是主页传来的isBuy,cityId
    private String isBuy;
    private String cityId;

    private LogoFragment01 fragment01;

    @Override
    protected int getResource() {
        return R.layout.fragment_loge_car_fragment;
    }

    @Override
    protected void beforeInitView() {
        //需要传来的参数
//        isBuy = getIntent().getStringExtra("isBuy");
//        cityId = getIntent().getStringExtra("cityId");
        isBuy = "2";
        cityId = "156";
    }

    @Override
    protected void initView(View rootView) {
        fragment01 = (LogoFragment01) getChildFragmentManager().findFragmentById(R.id.fragment01);
        getHotLogo();
    }

    @Override
    protected void initData() {

    }

    /**
     * 请求热门品牌参数
     */
    public void getHotLogo(){
        //加载热门品牌数据，热门品牌数据请求方法 ?isBuy=2&cityId=156
        HttpHelper.getDataHotLogo(isBuy, cityId, new HttpCallBack<ResultBean>() {
            @Override
            public void onSuccess(ResultBean resultBean) {
                //将解析地数据传递给Fragment
                if(resultBean != null && fragment01 != null){
                    fragment01.setResultBean(resultBean);
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
