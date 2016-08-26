package com.bwf.tuanche.Activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.base.BaseBean1;
import com.bwf.framwork.db.model.SearchHistoryTab;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.DisplayUtil;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.Adatper.CitylistSearchAdapter;
import com.bwf.tuanche.Adatper.HotSearchGridAdapter;
import com.bwf.tuanche.Adatper.PopwindowbuycarAdapter;
import com.bwf.tuanche.Adatper.hotSearchpagerAdapter;
import com.bwf.tuanche.R;
import com.bwf.tuanche.sql.HistoryBean;
import com.zhy.http.okhttp.callback.StringCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import okhttp3.Call;

public class HotSearch_Activity extends BaseActivity {
    private ImageView imageView,image_delete;

    private TextView search_button;

    private GridView gridView,gridView1;

    private ViewPager viewPager;


    private EditText search_wodesousuo;

    private HotSearchGridAdapter hotSearchGridAdapter;

    private List<GridView> datagrid;

    private List<String> text1,text,search_contents;

    private ListView search_history;

    private CitylistSearchAdapter adapter;

    private  List <HistoryBean> historyBeanList;
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
        imageView=findViewByIdNoCast(R.id.search_imageBack);
        viewPager=findViewByIdNoCast(R.id.search_viewpager);
        search_button=findViewByIdNoCast(R.id.search_tv);
        image_delete = findViewByIdNoCast(R.id.search_edDelete);
        search_history = findViewByIdNoCast(R.id.search_history);
        setSearchHistory();
        setOnClick(imageView,search_button,image_delete);
    }
    private boolean isShowDelete;
    @Override
    public void initData() {
        getData();
        setEditTextChange();
        search_contents = getDataFromSql();
        if(search_contents.size()!=0)search_history.setVisibility(View.VISIBLE);
        adapter = new CitylistSearchAdapter(search_contents,this);
        search_history.setAdapter(adapter);
    }
    private void setEditTextChange(){
        search_wodesousuo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!isShowDelete){
                    image_delete.setVisibility(View.VISIBLE);
                    isShowDelete = true;
                }
                if(charSequence.toString().isEmpty()){
                    image_delete.setVisibility(View.GONE);
                    isShowDelete = false;
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }
    private void  getData(){
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
                if(string!=null){
                    Bundle bundle = new Bundle();
                    bundle.putString("search",string);
                    IntentUtils.openActivity(HotSearch_Activity.this,Search_only_Activity.class,bundle);
                    search_wodesousuo.setText(string);
                }
            }
        });
        gridView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String string =(String) adapterView.getAdapter().getItem(i);
                if(string!=null)
                    IntentUtils.openActivity(HotSearch_Activity.this,CarContentActivity.class);
            }
        });
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.search_imageBack:
                  finish();
                break;
            case R.id.search_tv:
                if(search_wodesousuo.getText().toString().isEmpty()){
                    ToastUtil.showToast("请输入内容");
                }else{
                    if(search_history.getVisibility()!=View.VISIBLE)search_history.setVisibility(View.VISIBLE);
                    String content = search_wodesousuo.getText().toString();
                    if(search_contents.contains(content)){
                        search_contents.remove(content);
                        for (int i = 0; i < historyBeanList.size(); i++) {
                            if(historyBeanList.get(i).name.equals(content)){
                                historyBeanList.remove(i);
                                break;
                            }
                        }
                    }
                    if(search_contents.size()>=6){
                        for (int i = 5; i < search_contents.size(); i++){
                            search_contents.remove(i);
                            historyBeanList.remove(i);
                        }
                    }
                    search_contents.add(0,content);
                    adapter.notifyDataSetChanged();
                    putDataIntoSql(content);
                    Bundle bundle = new Bundle();
                    bundle.putString("search", content);
                    IntentUtils.openActivity(HotSearch_Activity.this,Search_only_Activity.class,bundle);
                }
                break;
            case R.id.search_edDelete:
                search_wodesousuo.setText("");
                image_delete.setVisibility(View.GONE);
                isShowDelete = false;
                break;
        }
    }

    @Override
    protected void onDestroy() {
        LogUtils.i("msg","onDestroy--->" +historyBeanList.toString());
        new Thread(){
            @Override
            public void run() {
               SearchHistoryTab.addAll(historyBeanList);
                super.run();
            }
        }.start();
        super.onDestroy();
    }
    private void  putDataIntoSql(String content){
        historyBeanList.add(0,new HistoryBean(content,System.currentTimeMillis()));
    }
    private List<String> getDataFromSql(){
        List<String> contents = new ArrayList<>();
        try{
             historyBeanList = SearchHistoryTab.queryAll();
            Collections.sort(historyBeanList);
            for (int i = 0; i <historyBeanList.size() ; i++) {
                contents.add(historyBeanList.get(i).name);
                if(i>5)SearchHistoryTab.delete(historyBeanList.get(i));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  contents;
    }
    //设置search_history的头,脚以及相应的
    private void setSearchHistory(){
        TextView head = new TextView(this);
        head.setText("搜索历史");
        ListView.LayoutParams layoutParams = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.height = DisplayUtil.dip2px(this,30);
        head.setLayoutParams(layoutParams);
        head.setPadding(10,0,0,0);
        head.setGravity(Gravity.CENTER_VERTICAL);
        head.setBackgroundColor(getResources().getColor(R.color.lightGray));
        search_history.addHeaderView(head,null,false);
        TextView foot = new TextView(this);
        foot.setText("清空记录");
        foot.setLayoutParams(layoutParams);
        foot.setGravity(Gravity.CENTER);
        foot.setBackgroundColor(getResources().getColor(R.color.lightGray));
        foot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                historyBeanList.clear();
                search_contents.clear();
                search_history.setVisibility(View.GONE);
                adapter.notifyDataSetChanged();
            }
        });
        search_history.addFooterView(foot,null,false);
        search_history.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String string = ((TextView) view).getText().toString();
                if(string==null)return;
                Bundle bundle = new Bundle();
                bundle.putString("search",string);
                IntentUtils.openActivity(HotSearch_Activity.this,Search_only_Activity.class,bundle);
                search_wodesousuo.setText(string);
            }
        });
        search_history.setVisibility(View.GONE);
    }
}
