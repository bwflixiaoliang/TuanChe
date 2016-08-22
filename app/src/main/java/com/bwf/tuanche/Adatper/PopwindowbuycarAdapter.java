package com.bwf.tuanche.Adatper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.bwf.tuanche.R;
import java.util.List;

/**
 * Created by fengchao on 2016/8/22.
 * Description：
 */
public class PopwindowbuycarAdapter extends BaseAdapter{
    private List<String> data;

    private Context context;

    public PopwindowbuycarAdapter(Context context) {

        this.context = context;
    }
    public void setAdapterdata( List<String> data){
        this.data=data;
    }

    @Override
    public int getCount() {
        return data==null?0:data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i)==null?null:data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View conview, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if(conview==null){
            viewHolder=new ViewHolder();
            conview=View.inflate(context, R.layout.item_test,null);
            viewHolder.textView1= (TextView) conview.findViewById(R.id.tv_test);
            conview.setTag(viewHolder);
        }
        viewHolder= (ViewHolder) conview.getTag();
        viewHolder.textView1.setText(data.get(position));
        return conview;
    }
    private class  ViewHolder{
        private TextView textView1;


    }
}

