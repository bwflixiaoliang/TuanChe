package com.bwf.tuanche.View;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by che on 2016/8/22
 * Description:.
 */
public class CarScreenListView extends ListView {
    public CarScreenListView(Context context) {
        this(context,null);
    }

    public CarScreenListView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CarScreenListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }


    private void initView(){

    }
}
