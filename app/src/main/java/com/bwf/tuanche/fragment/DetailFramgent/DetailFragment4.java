package com.bwf.tuanche.fragment.DetailFramgent;

import android.view.View;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.utils.ListUtils;
import com.bwf.framwork.utils.ListViewUtils;
import com.bwf.tuanche.Adatper.DetailFrag4_ListViewAdapter;
import com.bwf.tuanche.R;
import com.bwf.tuanche.eneity.detail.DetailResult;

/**
 * Created by fengchao on 2016/8/20.
 * Description：
 */
public class DetailFragment4 extends BaseFragment{
    private RatingBar ratingBar;

    private DetailFrag4_ListViewAdapter adapter;

    private TextView fenshu,tv_all;

    private ListView listView;
    @Override
    protected int getResource() {
        return R.layout.deatil_fragment4;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        ratingBar=findViewByIdNoCast(R.id.progressbar);
        fenshu=findViewByIdNoCast(R.id.fenshu);
        listView=findViewByIdNoCast(R.id.deatil_frag4_list);
        tv_all=findViewByIdNoCast(R.id.tv_all);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {

    }
    public void setdata(DetailResult detailResult){
        tv_all.setText(String.format(tv_all.getText().toString(),detailResult.comment.count));
        ratingBar.setRating(Float.parseFloat(detailResult.commentTotal));
        fenshu.setText(detailResult.commentTotal+"分");
        adapter=new DetailFrag4_ListViewAdapter(getContext());
        listView.setAdapter(adapter);
        adapter.setAdapterdata(detailResult.comment.commentList);
        ListViewUtils.measureListViewHeight(listView);
        adapter.notifyDataSetChanged();
    }
}
