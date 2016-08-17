package com.bwf.tuanche.Adatper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwf.tuanche.R;
import com.bwf.tuanche.eneity.hotlogo.HotLogo;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by fengchao on 2016/8/17.
 * Description：
 */
public class gridviewAdapter extends BaseAdapter{
    private List<HotLogo> hotLogos;

    private Context context;

    public gridviewAdapter(List<HotLogo> hotLogos,Context context) {
        this.hotLogos = hotLogos;
        this.context=context;
    }

    @Override
    public int getCount() {
        return hotLogos==null?0:hotLogos.size();
    }

    @Override
    public Object getItem(int i) {
        return hotLogos.get(i)==null?null:hotLogos.get(i);
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
            conview=View.inflate(context, R.layout.topbrand_item,null);
            viewHolder.textView1= (TextView) conview.findViewById(R.id.topbrand_item_tv1);
            viewHolder.textView2= (TextView) conview.findViewById(R.id.topbrand_item_tv2);
            viewHolder.simpleDraweeView= (SimpleDraweeView) conview.findViewById(R.id.topbrand_item_sdv);
            conview.setTag(viewHolder);
        }
        viewHolder= (ViewHolder) conview.getTag();
        viewHolder.textView1.setText(hotLogos.get(position).name);
        viewHolder.textView2.setText(hotLogos.get(position).baseNum);
        viewHolder.simpleDraweeView.setImageURI(hotLogos.get(position).logo);
        return conview;
    }
    private class  ViewHolder{
        private TextView textView1;
        private TextView textView2;
        private SimpleDraweeView simpleDraweeView;

}
}
