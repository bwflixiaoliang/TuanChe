package com.bwf.tuanche.fragment.MainlistFragment;

import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.tuanche.Activity.MarriageCarActivity;
import com.bwf.tuanche.Adatper.RecycleViewAdapters;
import com.bwf.tuanche.R;
import com.bwf.tuanche.View.DividerItemDecoration;
import com.bwf.tuanche.eneity.Banner.CenterBannerBean;
import com.bwf.tuanche.eneity.Banner.PositionBanner;
import com.facebook.drawee.view.SimpleDraweeView;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengchao on 2016/8/16.
 * Description：
 */
public class MainListFragment_3 extends BaseFragment {
    private SimpleDraweeView f_chexian, f_baozhang, f_hun, f_mm, f_zijia;
    private TextView hun1, hun2, mm1, mm2, zijia1, zijia2;
    private RecyclerView recyclerViews;
    //点击婚姻座驾的跳转
    private RelativeLayout marriage_Car01;

    @Override
    protected int getResource() {
        return R.layout.main_list_fragment3;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        f_chexian = findViewByIdNoCast(R.id.f_chexian);
        f_baozhang = findViewByIdNoCast(R.id.f_baozhang);
        f_hun = findViewByIdNoCast(R.id.f_hunying);
        hun1 = findViewByIdNoCast(R.id.tv_hunying);
        hun2 = findViewByIdNoCast(R.id.tv_hunying2);
        f_mm = findViewByIdNoCast(R.id.f_mother);
        f_zijia = findViewByIdNoCast(R.id.zijieche);
        mm1 = findViewByIdNoCast(R.id.tv_mm1);
        mm2 = findViewByIdNoCast(R.id.tv_mm2);
        zijia1 = findViewByIdNoCast(R.id.tv_zijia);
        zijia2 = findViewByIdNoCast(R.id.tv_zijia2);
        recyclerViews = findViewByIdNoCast(R.id.frag3_recylerview);
        //点击婚姻座驾的跳转
        marriage_Car01 = findViewByIdNoCast(R.id.marriage_Car01);
        marriage_Car01.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        //点击婚姻座驾的跳转
        switch (view.getId()) {
            case R.id.marriage_Car01:
                IntentUtils.openActivity(getContext(), MarriageCarActivity.class);
                break;
        }
    }

    public void setData(List<CenterBannerBean> centerBannerBeen, List<PositionBanner> positionBanners) {
        f_chexian.setImageURI(centerBannerBeen.get(0).adImgUrl);
        f_baozhang.setImageURI(centerBannerBeen.get(1).adImgUrl);
        f_hun.setImageURI(positionBanners.get(0).iconUrl);
        hun1.setText(positionBanners.get(0).bigTitle);
        hun2.setText(positionBanners.get(0).subTitle);
        mm1.setText(positionBanners.get(1).bigTitle);
        mm2.setText(positionBanners.get(1).subTitle);
        f_mm.setImageURI(positionBanners.get(1).iconUrl);
        zijia2.setText(positionBanners.get(2).subTitle);
        zijia1.setText(positionBanners.get(2).bigTitle);
        f_zijia.setImageURI(positionBanners.get(2).iconUrl);
        List<PositionBanner> newpositionBanner = new ArrayList<>();
        newpositionBanner.add(positionBanners.get(positionBanners.size() - 3));
        newpositionBanner.add(positionBanners.get(positionBanners.size() - 2));
        newpositionBanner.add(positionBanners.get(positionBanners.size() - 1));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), LinearLayout.HORIZONTAL);
        DividerItemDecoration dividerItemDecoration2 = new DividerItemDecoration(getContext(), LinearLayout.VERTICAL);
        dividerItemDecoration.setColor(Color.parseColor("#E3E3E3"));
        dividerItemDecoration2.setColor(Color.parseColor("#E3E3E3"));
        RecycleViewAdapters recycleViewAdapters = new RecycleViewAdapters(getContext(), newpositionBanner);
        recyclerViews.addItemDecoration(dividerItemDecoration);
        recyclerViews.addItemDecoration(dividerItemDecoration2);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        recyclerViews.setLayoutManager(gridLayoutManager);
        recyclerViews.setAdapter(recycleViewAdapters);
    }
}
