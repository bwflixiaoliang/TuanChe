package com.bwf.tuanche.Adatper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.bwf.framwork.base.BaseListAdpter;
import com.bwf.tuanche.R;

import java.util.List;

/**
 * Created by che on 2016/8/22
 * Description:.
 */
public class CarScreenAdapter extends BaseAdapter {

    private Context context;
    private List<Object> list;

    public CarScreenAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 20;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = View.inflate(context,R.layout.item_shaixuan,null);
        return view;
    }
}
