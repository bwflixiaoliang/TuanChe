package com.bwf.tuanche.View;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bwf.framwork.utils.DisplayUtil;
import com.bwf.framwork.utils.ListViewUtils;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.Adatper.PopwindowbuycarAdapter;
import com.bwf.tuanche.Adatper.PopwindowsamecarbrandAdapter;
import com.bwf.tuanche.R;
import com.bwf.tuanche.eneity.searchonly.ResultBean;
import com.bwf.tuanche.eneity.searchonly.SearchResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengchao on 2016/8/22.
 * Description：
 */
public class Popwindow_samebrand extends PopupWindow{
    private List<SearchResult> searchResult;

    private ListView buycarstyle_list;

    private LinearLayout ll_carsanmebrand;

    private  TextView titlename;

    private float down;

    private float move;

    private float up;

    private Context context;

    private PopwindowsamecarbrandAdapter popwindowsamecarbrandAdapter;

    public Popwindow_samebrand(Context context) {
        this(context,null,0);
    }

    public Popwindow_samebrand(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Popwindow_samebrand(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
        this.context=context;
    }

    public void setPopData(ResultBean result){
        if(result.result!=null&&result.result.size()!=0){
             searchResult=result.result;
            titlename.setText(searchResult.get(0).brandName);
            popwindowsamecarbrandAdapter.setAdapterdata(searchResult);
            popwindowsamecarbrandAdapter.notifyDataSetChanged();
        }
    }

    public void initView(Context context){
        View view=View.inflate(context, R.layout.carsamebrand_pop,null);
        this.setContentView(view);
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setWidth((int)(DisplayUtil.getDensity_Width(context)*0.7));
        final ColorDrawable dw = new ColorDrawable(000000);
        this.setBackgroundDrawable(dw);
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        this.setAnimationStyle(R.style.Pop_Animationsamecarbrand);
         buycarstyle_list= (ListView) view.findViewById(R.id.list_car_list);
         titlename= (TextView) view.findViewById(R.id.title_name);
        popwindowsamecarbrandAdapter=new PopwindowsamecarbrandAdapter(context);
        buycarstyle_list.setAdapter(popwindowsamecarbrandAdapter);
        ll_carsanmebrand= (LinearLayout) view.findViewById(R.id.ll_carsanmebrand);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch(motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        down=motionEvent.getRawX();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if(motionEvent.getRawX()>0){
                            view.scrollTo(-(int)(motionEvent.getRawX()),0);
                        }else {
                            view.scrollTo((int)(motionEvent.getRawX()),0);
                        }

                        break;
                }
                return false;
            }
        });
    }
    public void showPop(View view){
        if(!isShowing()){
            this.showAsDropDown(view,((int)(DisplayUtil.getDensity_Width(context)*0.3)),0);
        }else {
            this.dismiss();
        }
    }

}
