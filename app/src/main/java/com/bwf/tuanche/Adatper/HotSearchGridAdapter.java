package com.bwf.tuanche.Adatper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.bwf.tuanche.R;
import java.util.List;

/**
 * Created by fengchao on 2016/8/18.
 * Description：
 */
public class HotSearchGridAdapter extends BaseAdapter{
    private Context context;

    private List<String> list;

    public HotSearchGridAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if(view==null){
            viewHolder=new ViewHolder();
            view=View.inflate(context, R.layout.topbrand_item,null);
            viewHolder.textView1= (TextView) view.findViewById(R.id.topbrand_item_tv1);
            viewHolder.textView2= (TextView) view.findViewById(R.id.topbrand_item_tv2);
            view.setTag(viewHolder);
        }
        viewHolder= (ViewHolder) view.getTag();
        viewHolder.textView1.setText(list.get(position));
        if(position==4||position==8||position==12){
            viewHolder.textView2.setVisibility(View.GONE);
        }
        return view;
    }

    private class  ViewHolder{
        private TextView textView1;
        private TextView textView2;

    }

}
