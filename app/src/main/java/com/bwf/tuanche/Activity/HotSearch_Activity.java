package com.bwf.tuanche.Activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.base.BaseBean1;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.Adatper.HotSearchGridAdapter;
import com.bwf.tuanche.Adatper.hotSearchpagerAdapter;
import com.bwf.tuanche.R;
import com.bwf.tuanche.sql.HistoryBean;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.Call;

public class HotSearch_Activity extends BaseActivity {
    private ImageView imageView;

    private TextView search_button;

    private GridView gridView,gridView1;

    private ViewPager viewPager;

    private EditText search_wodesousuo;

    private HotSearchGridAdapter hotSearchGridAdapter;

    private List<GridView> datagrid;

    private List<String> text;

    private List<String> text1;




    @Override
    public int getContentViewId() {
        return R.layout.activity_hot_search_;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        search_wodesousuo=findViewByIdNoCast(R.id.search_wodesousuo);
        imageView=findViewByIdNoCast(R.id.img_back);
        viewPager=findViewByIdNoCast(R.id.search_viewpager);
        search_button=findViewByIdNoCast(R.id.search_tv);
        setOnClick(imageView,search_button);
    }

    @Override
    public void initData() {

       HttpHelper.getHotSearch("156", new StringCallback() {
           @Override
           public void onError(Call call, Exception e, int id) {

           }

           @Override
           public void onResponse(String response, int id) {
               BaseBean1 baseBean=JSON.parseObject(response,BaseBean1.class);
               List<String> text2=new ArrayList<>();
               if(baseBean!=null){
                   String strings=baseBean.result;
                   String[] list=strings.replace("[","").replace("]","").split(",");
                   for (int i = 0; i <list.length ; i++)
                   {
                       text2.add(list[i].substring(1,list[i].length()-1));
                   }
                   HotSearch_Activity.this.setText(text2);
               }
           }
       });

    }

    public void setText(List<String> text) {
        this.text = text;
        hotSearchGridAdapter=new HotSearchGridAdapter(this,text);
        gridView=new GridView(this);
        gridView.setNumColumns(4);
        gridView.setHorizontalSpacing(1);
        gridView.setAdapter(hotSearchGridAdapter);
        datagrid=new ArrayList<>();
        datagrid.add(gridView);
        gridView1=new GridView(this);
        gridView1.setNumColumns(1);
        text1=new ArrayList<>();
        text1.add("全部车型");
        hotSearchGridAdapter=new HotSearchGridAdapter(this,text1);
        gridView1.setAdapter(hotSearchGridAdapter);
        datagrid.add(gridView1);
        hotSearchpagerAdapter hotSearchpageradapter=new hotSearchpagerAdapter(this,datagrid);
        viewPager.setAdapter(hotSearchpageradapter);
        /**
         * gridview监听
         */
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Adapter adapter=adapterView.getAdapter();
                String string= (String) adapter.getItem(i);
                HistoryBean historyBean=new HistoryBean();
                historyBean.name=string;
                Date date=new Date();
                long l1=date.getTime();
                historyBean.time=l1;
//                Intent intent=new Intent(HotSearch_Activity.this,Search_only_Activity.class);
//                intent.putExtra("123",string);
//                startActivity(intent);
            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_back:
                IntentUtils.openActivity(this,MainListActivity.class);
                break;
            case R.id.search_tv:
                if(search_wodesousuo.getText()==null){
                    ToastUtil.showToast("请输入内容");
                }else{

                }
                break;


        }
    }
}
