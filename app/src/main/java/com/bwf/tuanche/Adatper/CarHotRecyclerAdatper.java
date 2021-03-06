package com.bwf.tuanche.Adatper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.widget.TextView;

import com.bwf.framwork.image.ImageLoader;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.MyApplication;
import com.bwf.tuanche.R;
import com.bwf.tuanche.eneity.hotlogo.HotLogo;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by lixiaoliang on 2016/8/17.
 * Description:
 */
public class CarHotRecyclerAdatper extends RecyclerView.Adapter<CarHotRecyclerAdatper.CarHotViewHolder> {

    private List<HotLogo> list;
    private Context context;
    private CallRecycleBack recycleBack;

    public CarHotRecyclerAdatper(Context context, List<HotLogo> list, CallRecycleBack recycleBack) {
        this.context = context;
        this.list = list;
        this.recycleBack = recycleBack;
    }

    @Override
    public CarHotViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_hot_car_content, null);
        CarHotViewHolder hotViewHolder = new CarHotViewHolder(view);

        hotViewHolder.car_content_fresco = (SimpleDraweeView) view.findViewById(R.id.car_content_fresco);
        hotViewHolder.car_content_text = (TextView) view.findViewById(R.id.car_content_text);

        return hotViewHolder;
    }

    @Override
    public void onBindViewHolder(CarHotViewHolder holder, final int position) {
        //加载数据
        if (list != null && !list.isEmpty()) {
            ImageLoader.getInstance().disPlayImage(holder.car_content_fresco, list.get(position).logo);
            holder.car_content_text.setText(list.get(position).name);
            holder.car_content_fresco.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recycleBack != null) {
                        recycleBack.callRecyclePop(list.get(position));
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class CarHotViewHolder extends ViewHolder {

        SimpleDraweeView car_content_fresco;
        TextView car_content_text;

        public CarHotViewHolder(View itemView) {
            super(itemView);
        }
    }

    //回调接口，弹出POpWindow
    public interface CallRecycleBack {
        void callRecyclePop(HotLogo hotLogo);
    }
}
