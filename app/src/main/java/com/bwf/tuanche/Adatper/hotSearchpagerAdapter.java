package com.bwf.tuanche.Adatper;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.List;

/**
 * Created by fengchao on 2016/8/18.
 * Description：
 */
public class hotSearchpagerAdapter extends PagerAdapter{
    private Context context;

    List<GridView> gridViews;

    public hotSearchpagerAdapter(Context context, List<GridView> gridViews) {
        this.context = context;
        this.gridViews=gridViews;
    }

    @Override
    public int getCount() {
        return gridViews==null?0:gridViews.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(gridViews.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = gridViews.get(position);
        container.addView(view);
        //返回当前视图
        return view;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}
