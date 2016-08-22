package com.bwf.tuanche.Adatper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwf.framwork.base.BaseListAdpter;
import com.bwf.framwork.image.ImageLoader;
import com.bwf.tuanche.R;
import com.bwf.tuanche.eneity.carlsitpopwindow.CarListBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by che on 2016/8/20
 * Description:.POpWindow的适配器
 */
public class CarListPopAdapter extends BaseListAdpter<CarListBean, CarListPopAdapter.MyViewHolder00> {

    private List<CarListBean> carListBeenall;

    public CarListPopAdapter(Context context) {
        super(context);
    }

    public CarListPopAdapter(List<CarListBean> carListBeen, Context context) {
        super(carListBeen, context);
    }


    @Override
    public int getResourceId() {
        return R.layout.item_popwindow;
    }

    @Override
    public MyViewHolder00 onCreateViewHolder(ViewGroup parent) {
        MyViewHolder00 myViewHolder00 = new MyViewHolder00();
        myViewHolder00.car_list_image02 = findViewByIdNoCast(R.id.car_list_image02);
        myViewHolder00.car_list_textnew = findViewByIdNoCast(R.id.car_list_textnew);
        myViewHolder00.carName_text001 = findViewByIdNoCast(R.id.carName_text001);
        myViewHolder00.carPice_text003 = findViewByIdNoCast(R.id.carPice_text003);
        return myViewHolder00;
    }

    @Override
    public void onBindViewHolder(MyViewHolder00 holder, CarListBean carListBean, int position) {
        ImageLoader.getInstance().disPlayImage(holder.car_list_image02, carListBean.logo);
        holder.car_list_textnew.setText(carListBean.brandName);
        holder.carName_text001.setText(carListBean.styleName);
        holder.carPice_text003.setText(carListBean.factoryPrice);
        if (position == 0) {
            holder.car_list_textnew.setVisibility(View.VISIBLE);
        } else if (position >= 1) {
            CarListBean carListBean02 = (CarListBean) getItem(position - 1);
            if (carListBean.brandName.equals(carListBean02.brandName)) {
                holder.car_list_textnew.setVisibility(View.GONE);
            }else{
                holder.car_list_textnew.setVisibility(View.VISIBLE);
            }
        }
    }

    public class MyViewHolder00 extends BaseListAdpter.ViewHolder {
        SimpleDraweeView car_list_image02;
        TextView car_list_textnew, carName_text001, carPice_text003;
    }
}
