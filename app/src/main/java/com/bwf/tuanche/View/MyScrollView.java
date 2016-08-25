package com.bwf.tuanche.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created by fengchao on 2016/8/23.
 * Description：
 */
public class MyScrollView extends ScrollView {

    private OnScrollChanged onScrollChanged=null;

    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setOnScrollChanged(OnScrollChanged onScrollChanged) {
        this.onScrollChanged = onScrollChanged;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (onScrollChanged != null) {
            onScrollChanged.onScrollChanged(this, l, t, oldl, oldt);
        }
    }

    public interface OnScrollChanged{
         void onScrollChanged(MyScrollView myScrollView,int l, int t, int oldl, int oldt);
    }


}
