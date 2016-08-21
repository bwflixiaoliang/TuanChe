package com.bwf.tuanche.fragment.CarContentFragment;

import android.view.View;
import android.widget.AdapterView;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.tuanche.Adatper.CarHotRecyclerAdatper;
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

    //PopWindow的回调
    private CarListCallBack callBack;
    private CarHotRecyclerAdatper.CallRecycleBack recycleBack;


    public void setCallBack(CarListCallBack callBack) {
        this.callBack = callBack;
    }
    public void setRecycleBack(CarHotRecyclerAdatper.CallRecycleBack recycleBack) {
        this.recycleBack = recycleBack;
    }

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
            car_hot_listView.setRecycler(list,recycleBack);
        }
    }

    //显示品牌列表
    public void showLogoList() {
        ListAdapter = new CarLogoListAdapter(result, getContext());
        car_hot_listView.setAdapter(ListAdapter);
        car_hot_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //回调到Activity中，弹出PopWindow
                //1。拿到点击Item的对象
                LogoCarListBean carListBean = (LogoCarListBean) adapterView.getItemAtPosition(position);
                if (callBack != null) {
                    callBack.getPopWindow(carListBean);
                }
            }
        });
    }

    @Override
    public void onClick(View view) {

    }

    //回调到Activity中实现弹出PopWindow
    public interface CarListCallBack {
        void getPopWindow(LogoCarListBean carListBean);
    }

}
