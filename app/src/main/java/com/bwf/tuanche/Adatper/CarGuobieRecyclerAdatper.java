package com.bwf.tuanche.Adatper;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.ForwardingListener;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bwf.framwork.image.ImageLoader;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.R;
import com.bwf.tuanche.eneity.TiaojianCar.CarCountry;
import com.bwf.tuanche.eneity.TiaojianCar.CarRank;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by lixiaoliang on 2016/8/17.
 * Description:
 */
public class CarGuobieRecyclerAdatper extends RecyclerView.Adapter<CarGuobieRecyclerAdatper.CarHotViewHolder> {

    private List<CarCountry> series;
    private Context context;
    private boolean isSelect =true;

    public CarGuobieRecyclerAdatper(Context context, List<CarCountry> series) {
        this.context = context;
        this.series = series;
    }

    @Override
    public CarHotViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_guobie_car_content,null);
        CarHotViewHolder hotViewHolder = new CarHotViewHolder(view);

        hotViewHolder.guojia_image = (SimpleDraweeView) view.findViewById(R.id.guojia_image);
        hotViewHolder.guojia_kuang = (Button) view.findViewById(R.id.guojia_kuang);

        return hotViewHolder;
    }

    @Override
    public void onBindViewHolder(final CarHotViewHolder holder, final int position) {
        //加载数据
        if(series != null && !series.isEmpty()){
            ImageLoader.getInstance().disPlayImage(holder.guojia_image,series.get(position).icon);
            holder.guojia_kuang.setText(series.get(position).name);

            holder.guojia_kuang.setOnClickListener(new View.OnClickListener() {
                @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onClick(View view) {
                    if(isSelect == false){
                        holder.guojia_kuang.setTextColor(Color.BLACK);
                        holder.guojia_kuang.setBackground(context.getResources().getDrawable(R.drawable.shape_black));
                        isSelect = true;
                    }else if(isSelect = true){
                        holder.guojia_kuang.setTextColor(Color.RED);
                        holder.guojia_kuang.setBackground(context.getResources().getDrawable(R.drawable.shape_read));
                        isSelect = false;
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return series == null ? 0 :series.size();
    }

    public class CarHotViewHolder extends ViewHolder {

        SimpleDraweeView guojia_image;
        Button guojia_kuang;

        public CarHotViewHolder(View itemView) {
            super(itemView);
        }
    }
}
