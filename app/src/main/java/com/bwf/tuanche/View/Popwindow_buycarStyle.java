package com.bwf.tuanche.View;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.bwf.framwork.utils.DisplayUtil;
import com.bwf.framwork.utils.ListViewUtils;
import com.bwf.tuanche.Adatper.PopwindowbuycarAdapter;
import com.bwf.tuanche.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengchao on 2016/8/22.
 * Description：
 */
public class Popwindow_buycarStyle extends PopupWindow{
    PopwindowbuycarAdapter popwindwobuycarAdapter;

    public Popwindow_buycarStyle(Context context) {
        this(context,null,0);
    }

    public Popwindow_buycarStyle(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Popwindow_buycarStyle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public void initView(Context context){
        View view=View.inflate(context, R.layout.item_popwindow_buycar,null);
        this.setContentView(view);
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setWidth(DisplayUtil.getDensity_Width(context));
        ColorDrawable dw = new ColorDrawable(0000000000);
        this.setBackgroundDrawable(dw);
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        this.setAnimationStyle(R.style.Pop_Animationbuycar);
        ListView buycarstyle_list= (ListView) view.findViewById(R.id.buycarstyle_list);
        popwindwobuycarAdapter=new PopwindowbuycarAdapter(context);
        buycarstyle_list.setAdapter(popwindwobuycarAdapter);
        List<String> data=new ArrayList<>();
        data.add("换车");
        data.add("摇号");
        data.add("异地上牌");
        data.add("拍牌");
        popwindwobuycarAdapter.setAdapterdata(data);
        ListViewUtils.measureListViewHeight(buycarstyle_list);
        popwindwobuycarAdapter.notifyDataSetChanged();
    }

    public void showPop(View view){
        if(!isShowing()){
            this.showAtLocation(view, Gravity.BOTTOM,0,0);
        }else {
            this.dismiss();
        }
    }
}
