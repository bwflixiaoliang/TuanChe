package com.bwf.tuanche.Adatper;

import android.content.Context;
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
public class CityListAdapter extends BaseListAdpter<CityListBean.CityListResult.OpenCity,CityListAdapter.MyCityViewHolder> {
    public CityListAdapter(Context context) {
        super(context);
    }

    public CityListAdapter(List<CityListBean.CityListResult.OpenCity> openCities, Context context) {
        super(openCities, context);
    }

    @Override
    public int getResourceId() {
        return R.layout.citylist_item;
    }

    @Override
    public MyCityViewHolder onCreateViewHolder(ViewGroup parent) {
        MyCityViewHolder viewHolder = new MyCityViewHolder();
        viewHolder.tvTitle = findViewByIdNoCast(R.id.citylist_item_tvTitle);
        viewHolder.tvContent = findViewByIdNoCast(R.id.citylist_item_tvContent);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyCityViewHolder holder, CityListBean.CityListResult.OpenCity openCity, int position) {
         String newp = openCity.pinyin.toUpperCase().trim().substring(0,1);
         String old =null;
         if(position!=0)
          old = ((CityListBean.CityListResult.OpenCity) getItem(position-1)).pinyin.toUpperCase().trim().substring(0,1);
          if(old!=null&&newp.equals(old))
              holder.tvTitle.setVisibility(View.GONE);
          else {
              holder.tvTitle.setVisibility(View.VISIBLE);
              holder.tvTitle.setText(newp);
          }
          holder.tvContent.setText(openCity.name);
    }

    public class MyCityViewHolder extends BaseListAdpter.ViewHolder{
        public TextView tvTitle,tvContent;
    }
}
