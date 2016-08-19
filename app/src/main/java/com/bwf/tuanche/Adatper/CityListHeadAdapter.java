package com.bwf.tuanche.Adatper;

import android.content.Context;
import android.graphics.Color;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwf.framwork.base.BaseListAdpter;
import com.bwf.tuanche.R;
import com.bwf.tuanche.eneity.CityList.CityListBean;


import java.util.List;


/**
 * Created by lixiaoliang on 2016/8/18.
 * Description:
 */
public class CityListHeadAdapter extends BaseListAdpter<List<CityListBean.CityListResult.OpenCity>,CityListHeadAdapter.MyViewHolder> {
    private CityListAdapter.CitySelectListener listener;
    private String currentCity;
    public CityListHeadAdapter(Context context) {
        super(context);
    }
    public CityListHeadAdapter(List list, Context context, CityListAdapter.CitySelectListener listener,String currentCity) {
        super(list, context);
        this.listener = listener;
        this.currentCity = currentCity;
    }

    @Override
    public int getResourceId() {
        return R.layout.citylist_head_item;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent) {
        MyViewHolder viewHolder = new MyViewHolder();
          viewHolder.tv1 = (TextView) rootView.getChildAt(0);
          viewHolder.v1 = rootView.getChildAt(1);
          viewHolder.tv2 = (TextView) rootView.getChildAt(2);
          viewHolder.v2 = rootView.getChildAt(3);
          viewHolder.tv3 = (TextView) rootView.getChildAt(4);
          viewHolder.v3 = rootView.getChildAt(5);
          viewHolder.tv4 = (TextView) rootView.getChildAt(6);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final List<CityListBean.CityListResult.OpenCity>o, int position) {
        holder.v1.setVisibility(View.GONE);
        holder.v2.setVisibility(View.GONE);
        holder.v3.setVisibility(View.GONE);
        holder.tv1.setVisibility(View.GONE);
        holder.tv2.setVisibility(View.GONE);
        holder.tv3.setVisibility(View.GONE);
        holder.tv4.setVisibility(View.GONE);
        if(o!=null){
            for (int i = 0; i < o.size(); i++) {
                final CityListBean.CityListResult.OpenCity openCity = o.get(i);
                switch (i){
                    case 0:
                        holder.tv1.setText(openCity.name);
                        if(currentCity!=null&&openCity.name.equals(currentCity)) holder.tv1.setTextColor(Color.RED);
                        else holder.tv1.setTextColor(Color.BLACK);
                        holder.tv1.setVisibility(View.VISIBLE);
                        holder.tv1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if(listener!=null)
                                listener.cityMessage(openCity);
                            }
                        });
                        holder.v1.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        holder.tv2.setText(openCity.name);
                        if(currentCity!=null&&openCity.name.equals(currentCity)) holder.tv2.setTextColor(Color.RED);
                        else holder.tv2.setTextColor(Color.BLACK);
                        holder.tv2.setVisibility(View.VISIBLE);
                        holder.tv2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if(listener!=null)
                                listener.cityMessage(openCity);
                            }
                        });
                        holder.v2.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        holder.tv3.setText(openCity.name);
                        if(currentCity!=null&&openCity.name.equals(currentCity)) holder.tv3.setTextColor(Color.RED);
                        else holder.tv3.setTextColor(Color.BLACK);
                        holder.tv3.setVisibility(View.VISIBLE);
                        holder.tv3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if(listener!=null)
                                listener.cityMessage(openCity);
                            }
                        });
                        holder.v3.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        holder.tv4.setText(openCity.name);
                        if(currentCity!=null&&openCity.name.equals(currentCity)) holder.tv4.setTextColor(Color.RED);
                        else holder.tv4.setTextColor(Color.BLACK);
                        holder.tv4.setVisibility(View.VISIBLE);
                        holder.tv4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if(listener!=null)
                                listener.cityMessage(openCity);
                            }
                        });
                        break;
                }
            }
        }
    }
    public class MyViewHolder extends BaseListAdpter.ViewHolder{
            private TextView tv1,tv2,tv3,tv4;
            private View v1,v2,v3;
    }
}
