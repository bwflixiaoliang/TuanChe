package com.bwf.tuanche.Adatper;

import android.content.Context;
import android.graphics.Color;
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
        return list==null?0:list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if(view==null){
            viewHolder=new ViewHolder();
            view=View.inflate(context, R.layout.itemofgridview,null);
            viewHolder.textView1= (TextView) view.findViewById(R.id.item_text);
            view.setTag(viewHolder);
        }
        viewHolder= (ViewHolder) view.getTag();
        if(list.get(position).equals("全部车型")){
            viewHolder.textView1.setTextColor(Color.parseColor("#D02B14"));
            viewHolder.textView1.setText(list.get(position));
        }
        viewHolder.textView1.setText(list.get(position));
        return view;
    }

    private class  ViewHolder{
        private TextView textView1;
    }

}
