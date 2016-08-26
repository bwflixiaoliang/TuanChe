package com.bwf.tuanche.Adatper;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwf.framwork.base.BaseListAdpter;
import com.bwf.framwork.image.ImageLoader;
import com.bwf.tuanche.R;
import com.bwf.tuanche.eneity.mymarriagecar.CarStyleListBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by che on 2016/8/24
 * Description:.
 */
public class MyMarriageListAdapter extends BaseListAdpter<CarStyleListBean,MyMarriageListAdapter.MarriageViewHolder> {

    private List<CarStyleListBean> carstyleList;

    public MyMarriageListAdapter(Context context) {
        super(context);
    }

    public MyMarriageListAdapter(List<CarStyleListBean> carstyleList, Context context) {
        super(carstyleList, context);
    }

    public void setCarstyleList(List<CarStyleListBean> carstyleList) {
        this.carstyleList = carstyleList;
    }

    @Override
    public int getResourceId() {
        return R.layout.item_popwindow;
    }

    @Override
    public MarriageViewHolder onCreateViewHolder(ViewGroup parent) {
        MarriageViewHolder viewHolder = new MarriageViewHolder();
        viewHolder.car_list_textnew = findViewByIdNoCast(R.id.car_list_textnew);
        viewHolder.car_list_image02 = findViewByIdNoCast(R.id.car_list_image02);
        viewHolder.carName_text001 = findViewByIdNoCast(R.id.carName_text001);
        viewHolder.carPice_text002 = findViewByIdNoCast(R.id.carPice_text002);
        viewHolder.carPice_text003 = findViewByIdNoCast(R.id.carPice_text003);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MarriageViewHolder holder, CarStyleListBean carStyleListBean, int position) {
        holder.car_list_textnew.setVisibility(View.GONE);
        ImageLoader.getInstance().disPlayImage(holder.car_list_image02,carStyleListBean.logo);
        holder.carName_text001.setText(carStyleListBean.styleName);
        holder.carPice_text002.setText(carStyleListBean.pricePrefix+carStyleListBean.factoryPrice);
        holder.carPice_text002.setTextColor(Color.BLACK);
        holder.carPice_text003.setText(carStyleListBean.content);
        holder.carPice_text003.setTextColor(Color.RED);
    }

    public  class MarriageViewHolder extends BaseListAdpter.ViewHolder {
        private TextView car_list_textnew, carName_text001, carPice_text002,carPice_text003;
        private SimpleDraweeView car_list_image02;
    }

}
