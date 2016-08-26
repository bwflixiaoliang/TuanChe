package com.bwf.tuanche.View;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by fengchao on 2016/8/25.
 * Description：暂时不用，勿删
 */
public class PinjiaListView extends ListView{
    public PinjiaListView(Context context) {
        super(context);
    }

    public PinjiaListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PinjiaListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
    }


    private interface OnScrollChandedListenear{
        void OnScrollChanged();
    }
}
