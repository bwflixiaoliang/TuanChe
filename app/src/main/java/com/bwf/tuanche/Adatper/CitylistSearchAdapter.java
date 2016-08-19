package com.bwf.tuanche.Adatper;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwf.framwork.utils.DisplayUtil;
import com.bwf.tuanche.R;

import java.util.List;

/**
 * Created by lixiaoliang on 2016/8/18.
 * Description:
 */
public class CitylistSearchAdapter extends BaseAdapter {
    private List<String>  stringList;
    private Context context;

    public CitylistSearchAdapter(List<String> stringList, Context context) {
        this.stringList = stringList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return stringList==null?0:stringList.size();
    }

    @Override
    public Object getItem(int i) {
        return stringList==null?null:stringList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = new TextView(context);
        AbsListView.LayoutParams params = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.height = DisplayUtil.dip2px(context,23);
        textView.setLayoutParams(params);
        textView.setGravity(Gravity.CENTER);
        textView.setText(stringList.get(i));
        return textView;
    }
}
