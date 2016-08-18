package com.bwf.tuanche.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.bwf.tuanche.R;

/**
 * Created by che on 2016/8/17
 * Description:.
 */
public class CarShaiXuanListView extends ListView {

    private View SX_item_view;



    public CarShaiXuanListView(Context context) {
        this(context,null);
    }

    public CarShaiXuanListView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CarShaiXuanListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    //初始化View
    public void initView(Context context){
        SX_item_view = View.inflate(context, R.layout.item_shaixuan,null);


    }

}
