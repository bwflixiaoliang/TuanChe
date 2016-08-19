package com.bwf.tuanche.CarContentFragment;

import android.view.View;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.Adatper.CarLogoListAdapter;
import com.bwf.tuanche.R;
import com.bwf.tuanche.View.CarHotListView;
import com.bwf.tuanche.eneity.hotlogo.HotLogo;
import com.bwf.tuanche.eneity.logocarlist.LogoCarListBean;

import java.util.List;


public class LogoCarFragment extends BaseFragment {

    //使用自定义ListView完成品牌列表
    private CarHotListView car_hot_listView;
    private CarLogoListAdapter ListAdapter;
    private List<HotLogo> list;
    private List<LogoCarListBean> result;

    public void setList(List<HotLogo> list) {
        this.list = list;
        showHotLogo();
    }

    public void setResult(List<LogoCarListBean> result) {
        this.result = result;
        showLogoList();
    }

    @Override
    protected int getResource() {
        return R.layout.fragment_loge_car_fragment;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        car_hot_listView = findViewByIdNoCast(R.id.car_hot_listView);
    }

    @Override
    protected void initData() {

    }

    //显示热门品牌
    public void showHotLogo() {
        if (list != null) {
            car_hot_listView.setRecycler(list);
        }
    }

    //显示品牌列表
    public void showLogoList() {
        ListAdapter = new CarLogoListAdapter(result,getContext());
        car_hot_listView.setAdapter(ListAdapter);
    }

    @Override
    public void onClick(View view) {

    }
}
