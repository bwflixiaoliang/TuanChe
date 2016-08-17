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
public class CarBrandListView extends ListView {

    private View ZimuTitle;
    private TextView shouzimu_text;

    public CarBrandListView(Context context) {
        this(context,null);
    }

    public CarBrandListView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CarBrandListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    //初始化View
    public void initView(Context context){
        //在头部add拼音首字母
        ZimuTitle = View.inflate(context, R.layout.item_shouzimu,null);
        shouzimu_text = (TextView) findViewById(R.id.shouzimu_text);
        addFooterView(ZimuTitle);
    }

}
