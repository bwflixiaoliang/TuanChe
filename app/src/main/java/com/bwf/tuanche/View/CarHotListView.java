package com.bwf.tuanche.View;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

import com.bwf.framwork.utils.ListViewUtils;
import com.bwf.tuanche.Adatper.CarHotRecyclerAdatper;
import com.bwf.tuanche.MyApplication;
import com.bwf.tuanche.R;
import com.bwf.tuanche.eneity.hotlogo.HotLogo;

import java.util.List;

/**
 * Created by che on 2016/8/19
 * Description:.
 */
public class CarHotListView extends ListView {

    private View hotLogoview;
    private RecyclerView car_contentRecy;
    private CarHotRecyclerAdatper recyclerAdatper;
    private Context context;

    public CarHotListView(Context context) {
        this(context, null);
    }

    public CarHotListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CarHotListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initView(context);
    }

    //初始化View
    public void initView(Context context) {
        //添加头部热门品牌
        hotLogoview = View.inflate(context, R.layout.fragment_logo_fragment01, null);
        car_contentRecy = (RecyclerView) hotLogoview.findViewById(R.id.car_contentRecy);
        addHeaderView(hotLogoview);
    }

    public void setRecycler(List<HotLogo> list, CarHotRecyclerAdatper.CallRecycleBack recycleBack) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 4);
        car_contentRecy.setLayoutManager(gridLayoutManager);
        //加载RcycleView数据
        recyclerAdatper = new CarHotRecyclerAdatper(context, list, recycleBack);
        car_contentRecy.setAdapter(recyclerAdatper);
    }
}
