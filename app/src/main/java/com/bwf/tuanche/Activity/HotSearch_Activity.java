package com.bwf.tuanche.Activity;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import com.alibaba.fastjson.JSON;
import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.base.BaseBean;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.Adatper.HotSearchGridAdapter;
import com.bwf.tuanche.R;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

public class HotSearch_Activity extends BaseActivity {
    private ImageView imageView;

    private ViewPager viewPager;

    List<String> text;

    private GridView gridView;

    @Override
    public int getContentViewId() {
        return R.layout.activity_hot_search_;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        imageView=findViewByIdNoCast(R.id.img_back);
        viewPager=findViewByIdNoCast(R.id.search_viewpager);
        gridView=findViewByIdNoCast(R.id.GridView_item);
        setOnClick(imageView);
    }

    @Override
    public void initData() {
       HttpHelper.getHotSearch("156", new StringCallback() {
           @Override
           public void onError(Call call, Exception e, int id) {

           }

           @Override
           public void onResponse(String response, int id) {
               BaseBean baseBean=JSON.parseObject(response,BaseBean.class);
               String strings=baseBean.result;
               String[] list=strings.replace("[","").replace("]","").split(",");
                text=new ArrayList<>();
               for(String a:list){
                   text.add(a);
               }
           }
       });
        HotSearchGridAdapter hotSearchGridAdapter=new HotSearchGridAdapter(this,text);
        gridView.setAdapter(hotSearchGridAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_back:
                IntentUtils.openActivity(this,MainListActivity.class);
                break;



        }
    }
}
