package com.bwf.tuanche.Adatper;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView.ViewHolder;

/**
 * Created by lixiaoliang on 2016/8/17.
 * Description:
 */
public class CarHotRecyclerAdatper extends RecyclerView.Adapter<CarHotRecyclerAdatper.CarHotViewHolder> {
    @Override
    public CarHotViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(CarHotViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CarHotViewHolder extends ViewHolder {
        public CarHotViewHolder(View itemView) {
            super(itemView);
        }
    }
}
