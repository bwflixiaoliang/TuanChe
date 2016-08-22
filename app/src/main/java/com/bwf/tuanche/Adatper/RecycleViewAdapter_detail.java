package com.bwf.tuanche.Adatper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwf.tuanche.R;
import com.bwf.tuanche.eneity.Banner.PositionBanner;
import com.bwf.tuanche.eneity.detail.Bigxiang;
import com.bwf.tuanche.eneity.detail.Xiangqing;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by fengchao on 2016/8/18.
 * Description：
 */
public class RecycleViewAdapter_detail extends RecyclerView.Adapter<RecycleViewAdapter_detail.ViewHolder>{
    private Context context;

    private List<Xiangqing> xiangqings;

    public RecycleViewAdapter_detail(Context context) {
        this.context = context;
    }

    public void setAdapterData(List<Xiangqing> xiangqings){
        this.xiangqings=xiangqings;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.item_tcbaozheng,null);
        ViewHolder viewholder=new ViewHolder(view);
        viewholder.textview= (TextView) view.findViewById(R.id.item_big);
        viewholder.textview2= (TextView) view.findViewById(R.id.item_small);
        viewholder.sim= (SimpleDraweeView) view.findViewById(R.id.item_baozheng_simple);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            holder.textview.setText(xiangqings.get(position).title);
            holder.textview2.setText(xiangqings.get(position).describe);
            holder.sim.setImageURI(xiangqings.get(position).imgurl);

    }

    @Override
    public int getItemCount() {
        return xiangqings==null?0:xiangqings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textview;
        TextView textview2;
        SimpleDraweeView sim;
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
