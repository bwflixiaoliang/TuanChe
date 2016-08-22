package com.bwf.tuanche.View;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.DisplayUtil;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.Adatper.CarListPopAdapter;
import com.bwf.tuanche.R;
import com.bwf.tuanche.eneity.carlsitpopwindow.CarListBean;
import com.bwf.tuanche.eneity.carlsitpopwindow.CarListResult;
import com.bwf.tuanche.eneity.hotlogo.HotLogo;
import com.bwf.tuanche.eneity.logocarlist.LogoCarListBean;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by lixiaoliang on 2016/8/16.
 * Description:
 */
public class MyPopWindow extends PopupWindow implements View.OnClickListener {
    private Context context;
    private LogoCarListBean carListBean;
    private HotLogo hotLogo;
    private View myview;

    private String cityId;
    private String type;
    private ListView list_car_list;

    private Button hot_car_list, pice_car_list;
    private View pop_left_null, hot_car_down, pice_car_down;
    private CarListPopAdapter popAdapter;

    //点击品牌列表的实例构造方法
    public MyPopWindow(Context context, LogoCarListBean carListBean, String cityId) {
        this.context = context;
        this.carListBean = carListBean;
        this.cityId = cityId;
        type = "0";
        initView();
    }

    //点击热门品牌的实例构造方法
    public MyPopWindow(Context context, HotLogo hotLogo, String cityId) {
        this.context = context;
        this.hotLogo = hotLogo;
        this.cityId = cityId;
        type = "0";
        initView();
    }

    private void initView() {
        myview = View.inflate(context, R.layout.item_carlsit_pop, null);
        //popWindow的相关设置
        this.setContentView(myview);//加载一个布局
        this.setWidth(DisplayUtil.getDensity_Width(context));
        this.setHeight(DisplayUtil.getDensity_Height(context));
        this.setBackgroundDrawable(new BitmapDrawable());
        this.setFocusable(true);
        //实例化一个ColorDrawable颜色为半透明
//        ColorDrawable dw = new ColorDrawable(0xb0000000);
//        this.setBackgroundDrawable(dw);
        this.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);//??????
        this.setAnimationStyle(R.style.PopupAnimationShowCarList);

        //设置热门与价格的点击监听
        hot_car_list = (Button) myview.findViewById(R.id.hot_car_list);
        pice_car_list = (Button) myview.findViewById(R.id.pice_car_list);
        pop_left_null = myview.findViewById(R.id.pop_left_null);
        hot_car_down = myview.findViewById(R.id.hot_car_down);
        pice_car_down = myview.findViewById(R.id.pice_car_down);
        hot_car_list.setTextColor(Color.RED);
        hot_car_down.setBackgroundColor(Color.RED);
        hot_car_list.setOnClickListener(this);
        pice_car_list.setOnClickListener(this);
        pop_left_null.setOnClickListener(this);
        list_car_list = (ListView) myview.findViewById(R.id.list_car_list);
        //判断点击对象来自哪里，再请求相应的数据
        if (carListBean != null) {
            getDataHot();
        } else if (hotLogo != null) {
            getDataSelectHot();
        }
        //数据ListView的点击监听
        list_car_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //传递城市ID和车辆品牌ID
                ToastUtil.showToast(cityId);
                CarListBean carListBean = (CarListBean) adapterView.getItemAtPosition(i);
                ToastUtil.showToast("" + carListBean.id);
                ToastUtil.showToast("跳转到相应的页面！");
            }
        });

        //popWindow的滑动监听
//        myview.setOnTouchListener(new OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                switch (motionEvent.getAction()){
//                    case MotionEvent.ACTION_UP:
//                        ToastUtil.showToast("commming");
//                    break;
//                }
//                return false;
//            }
//        });
    }

    //点击列表的数据请求
    private void getDataHot() {
        HttpHelper.getDataCarByBrand(type, cityId, carListBean.id, new HttpCallBack<CarListResult>() {
            @Override
            public void onSuccess(CarListResult resultAll) {
                List<CarListBean> carListBeen = new ArrayList<>();
                if (resultAll != null) {
                    for (int i = 0; i < resultAll.result.size(); i++)
                        carListBeen.addAll(resultAll.result.get(i).styleList);
                    popAdapter = new CarListPopAdapter(carListBeen, context);
                    list_car_list.setAdapter(popAdapter);
                }
            }

            @Override
            public void onFail(String errMsg) {
            }
        });
    }

    //    点击热门品牌的数据请求
    private void getDataSelectHot() {
        HttpHelper.getDataCarByBrand(type, cityId, hotLogo.id, new HttpCallBack<CarListResult>() {
            @Override
            public void onSuccess(CarListResult resultAll) {
                List<CarListBean> carListBeen = new ArrayList<>();
                if (resultAll != null) {
                    for (int i = 0; i < resultAll.result.size(); i++)
                        carListBeen.addAll(resultAll.result.get(i).styleList);
                    popAdapter = new CarListPopAdapter(carListBeen, context);
                    list_car_list.setAdapter(popAdapter);
                }
            }

            @Override
            public void onFail(String errMsg) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.hot_car_list:
                type = "0";
                hot_car_list.setTextColor(Color.RED);
                hot_car_down.setBackgroundColor(Color.RED);
                pice_car_list.setTextColor(Color.BLACK);
                pice_car_down.setBackgroundColor(Color.WHITE);
                if (carListBean != null) {
                    getDataHot();
                } else if (hotLogo != null) {
                    getDataSelectHot();
                }
                break;
            case R.id.pice_car_list:
                type = "1";
                hot_car_list.setTextColor(Color.BLACK);
                hot_car_down.setBackgroundColor(Color.WHITE);
                pice_car_list.setTextColor(Color.RED);
                pice_car_down.setBackgroundColor(Color.RED);
                if (carListBean != null) {
                    getDataHot();
                } else if (hotLogo != null) {
                    getDataSelectHot();
                }
                break;
            case R.id.pop_left_null:
                MyPopWindow.this.dismiss();
                break;
        }
    }

    //显示PopWindow的方法
    //PopWindow与DiaLog不同的地方是，它可以显示在指定的位置
    public void showPopWindow(View view) {
        if (!isShowing()) {
            this.showAsDropDown(view, view.getWidth(), 0);//显示在view 的下方
        }
    }

}
