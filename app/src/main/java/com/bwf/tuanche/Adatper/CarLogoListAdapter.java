package com.bwf.tuanche.Adatper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwf.framwork.base.BaseListAdpter;
import com.bwf.framwork.image.ImageLoader;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.MyApplication;
import com.bwf.tuanche.R;
import com.bwf.tuanche.eneity.hotlogo.HotLogo;
import com.bwf.tuanche.eneity.logocarlist.LogoCarListBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by che on 2016/8/17
 * Description:.
 */
public class CarLogoListAdapter extends BaseListAdpter<LogoCarListBean, CarLogoListAdapter.MyViewHolder> {

    private List<LogoCarListBean> logoCarListBeen;

    public CarLogoListAdapter(Context context) {
        super(context);
    }

    public CarLogoListAdapter(List<LogoCarListBean> logoCarListBeen, Context context) {
        super(logoCarListBeen, context);
        this.logoCarListBeen = logoCarListBeen;
    }

    @Override
    public int getResourceId() {
        return R.layout.item_carlogo_list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent) {
        MyViewHolder viewHolder = new MyViewHolder();
        viewHolder.carLogo_list_last = findViewByIdNoCast(R.id.carLogo_list_last);
        viewHolder.carLogo_list_image = findViewByIdNoCast(R.id.carLogo_list_image);
        viewHolder.carLogo_list_text = findViewByIdNoCast(R.id.carLogo_list_text);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, LogoCarListBean logoCarListBean, int position) {
        //逻辑处理
        //判断当前position的Item中的对象的logoCarListBean.penname是否与下一个Item中的对象的logoCarListBean.penname相同，
        //如果相同即隐藏carLogo_list_last的TextView
        //如果判断不相同即正常显示
        holder.carLogo_list_last.setText(logoCarListBean.penname);
        ImageLoader.getInstance().disPlayImage(holder.carLogo_list_image, logoCarListBean.logo);
        holder.carLogo_list_text.setText(logoCarListBean.name);
        if(position > 1){
            LogoCarListBean logo2 = (LogoCarListBean) getItem(position - 1);
            if (logoCarListBean.penname.equals(logo2.penname)) {
                holder.carLogo_list_last.setVisibility(View.GONE);
            } else {
                holder.carLogo_list_last.setVisibility(View.VISIBLE);
            }
        }
    }

    public class MyViewHolder extends BaseListAdpter.ViewHolder {
        private TextView carLogo_list_last, carLogo_list_text;
        private SimpleDraweeView carLogo_list_image;
    }

}
