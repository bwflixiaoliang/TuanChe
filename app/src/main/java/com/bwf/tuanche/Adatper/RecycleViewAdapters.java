package com.bwf.tuanche.Adatper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwf.tuanche.R;
import com.bwf.tuanche.eneity.Banner.PositionBanner;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by fengchao on 2016/8/18.
 * Description：
 */
public class RecycleViewAdapters  extends RecyclerView.Adapter<RecycleViewAdapters.ViewHolder>{
    private Context context;
    private List<PositionBanner> positionBanners;

    public RecycleViewAdapters(Context context,List<PositionBanner> positionBanners) {
        this.context = context;
        this.positionBanners=positionBanners;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.farg_3_item,null);
        ViewHolder viewholder=new ViewHolder(view);
        viewholder.textview= (TextView) view.findViewById(R.id.frag3_tv1);
        viewholder.textview2= (TextView) view.findViewById(R.id.frag3_tv2);
        viewholder.sim= (SimpleDraweeView) view.findViewById(R.id.frag3_f1);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            holder.textview.setText(positionBanners.get(position).bigTitle);
            holder.textview2.setText(positionBanners.get(position).subTitle);
            holder.sim.setImageURI(positionBanners.get(position).iconUrl);

    }

    @Override
    public int getItemCount() {
        return positionBanners==null?0:positionBanners.size();
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
