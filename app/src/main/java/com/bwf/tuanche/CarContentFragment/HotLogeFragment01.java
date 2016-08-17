package com.bwf.tuanche.CarContentFragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bwf.framwork.base.BaseBean;
import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.tuanche.Adatper.CarHotRecyclerAdatper;
import com.bwf.tuanche.R;


public class HotLogeFragment01 extends BaseFragment {
    private RecyclerView car_contentRecy;
    private CarHotRecyclerAdatper hotRecyclerAdatper;
    @Override
    protected int getResource() {
        return R.layout.fragment_hot_loge_fragment01;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
//        car_contentRecy = findViewByIdNoCast(R.id.car_contentRecy);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),4);
//        car_contentRecy.setLayoutManager(gridLayoutManager);
    }

    @Override
    protected void initData() {
        //加载热门品牌数据，热门品牌数据请求方法 ?isBuy=2&cityId=156
//        HttpHelper.getDataHotLogo("2", "156", new HttpCallBack<>() {
//            @Override
//            public void onSuccess(BaseBean result) {
//                LogUtils.e("请求返回的集合是：",result.toString());
//            }
//
//            @Override
//            public void onFail(String errMsg) {
//                LogUtils.e("0000000000000000：",errMsg.toString());
//            }
//        });
    }



    @Override
    public void onClick(View view) {

    }
}
