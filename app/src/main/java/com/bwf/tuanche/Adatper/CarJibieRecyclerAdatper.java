package com.bwf.tuanche.Adatper;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwf.framwork.image.ImageLoader;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.R;
import com.bwf.tuanche.eneity.TiaojianCar.CarLevle;
import com.bwf.tuanche.eneity.TiaojianCar.CarRank;
import com.bwf.tuanche.eneity.hotlogo.HotLogo;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lixiaoliang on 2016/8/17.
 * Description:
 */
public class CarJibieRecyclerAdatper extends RecyclerView.Adapter<CarJibieRecyclerAdatper.CarHotViewHolder> {

    private List<CarRank> list;
    private Context context;
    private boolean isSelect =true;

    private List<String> names;

    public CarJibieRecyclerAdatper(Context context, List<CarRank> list) {
        names = new ArrayList<>();
        names.clear();
        this.context = context;
        this.list = list;
    }

    @Override
    public CarHotViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_jibie_car_content,null);
        CarHotViewHolder hotViewHolder = new CarHotViewHolder(view);

        hotViewHolder.jibie_content_fresco = (SimpleDraweeView) view.findViewById(R.id.jibie_content_fresco);
        hotViewHolder.jibie_content_text = (TextView) view.findViewById(R.id.jibie_content_text);

        return hotViewHolder;
    }

    @Override
    public void onBindViewHolder(final CarHotViewHolder holder, final int position) {
        //加载数据
        if(list != null && !list.isEmpty()){
            ImageLoader.getInstance().disPlayImage(holder.jibie_content_fresco,list.get(position).defIcon);
            holder.jibie_content_text.setText(list.get(position).name);

            holder.jibie_content_fresco.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(isSelect == false){
                        ImageLoader.getInstance().disPlayImage(holder.jibie_content_fresco,list.get(position).defIcon);
                        holder.jibie_content_text.setTextColor(Color.BLACK);
                        names.remove(list.get(position).name);
                        isSelect = true;
                    }else if(isSelect == true){
                        ImageLoader.getInstance().disPlayImage(holder.jibie_content_fresco,list.get(position).icon);
                        holder.jibie_content_text.setTextColor(Color.RED);
                        names.add(list.get(position).name);
                        isSelect = false;
                    }
                    //拿到点击选中的集合，是name
                    ToastUtil.showToast(""+names.size());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CarHotViewHolder extends ViewHolder {

        SimpleDraweeView jibie_content_fresco;
        TextView jibie_content_text;

        public CarHotViewHolder(View itemView) {
            super(itemView);
        }
    }
}
