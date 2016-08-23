package com.bwf.tuanche.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.map.MapLocation;
import com.bwf.framwork.tools.RequestAndResultCode;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.ListViewUtils;
import com.bwf.tuanche.Adatper.CityListAdapter;
import com.bwf.tuanche.Adatper.CityListHeadAdapter;
import com.bwf.tuanche.Adatper.CitylistSearchAdapter;
import com.bwf.tuanche.R;
import com.bwf.tuanche.View.LoadAnimation;
import com.bwf.tuanche.eneity.CityList.CityListBean;
import com.bwf.tuanche.eneity.location.LocationBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class CityListActivity extends BaseActivity implements BDLocationListener{
    private String currentCity;
    private LoadAnimation loadAnimation;
    private boolean showFloatTitle,locaFailed;
    private TextView textView_title,textView_location,textView_cityName;
    private ListView listView_hotCity,listViewContent,listViewSearch,listViewSurround;
    private View headView;
    private Map<String,Integer> position;
    private LocationBean.LocationCity locationCity;
    private List<CityListBean.CityListResult.OpenCity> openCityList,hotCityList;
    private List<String> searchlist;
    @Override
    public int getContentViewId() {
        return R.layout.activity_city_list;
    }
    @Override
    public void beforeInitView() {
        currentCity = getIntent().getStringExtra("currentCity");
        currentCity =currentCity==null?"成都":currentCity;
        new MapLocation().onCreate(this,this);
    }
    @Override
    public void initView() {
        position = new HashMap<>();
        searchlist = new ArrayList<>();
        searchlist.add("#");
        searchlist.add("&");
        searchlist.add("*");
        setOnClick(R.id.citylist_imageBack);
        textView_title = findViewByIdNoCast(R.id.citylist_textTitle);
        listViewContent = findViewByIdNoCast(R.id.citylist_listContent);
        listViewSearch = findViewByIdNoCast(R.id.citylist_searchlist);
        textView_cityName = findViewByIdNoCast(R.id.citylist_list_tvTitle);
        loadAnimation = findViewByIdNoCast(R.id.citylist_loadAnimation);
        //listview的headerView设置
        headView = View.inflate(this,R.layout.citylist_header,null);
        textView_location = (TextView) headView.findViewById(R.id.citylist_textLocation);
        textView_location.setOnClickListener(this);
        listView_hotCity = (ListView) headView.findViewById(R.id.citylist_hotCity);
        listViewSurround = (ListView) headView.findViewById(R.id.citylist_cityAround);
        listViewContent.addHeaderView(headView);
        listViewContent.setVisibility(View.GONE);
        listViewSearch.setVisibility(View.GONE);
    }
    @Override
    public void initData() {
        if(currentCity!=null)textView_title.setText(String.format(getString(R.string.nowCity_name),currentCity));
        else textView_title.setText(String.format(getString(R.string.nowCity_name),"未知"));
        getData();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.citylist_textLocation:
                if(locaFailed){
                    textView_location.setText("定位中···");
                    new MapLocation().onCreate(this,this);
                }
                break;
            case R.id.citylist_imageBack:
                finish();
                break;
        }
    }

    @Override
    public void onReceiveLocation(BDLocation bdLocation) {
        Log.i("msg","<-------onReceiveLocation------->");
        if(bdLocation==null){
            locaFailed = true;
            textView_location.setText( Html.fromHtml("<font color = black>定位失败   </font><font color = red>点击重试！！！</font>"));
            return;
        }
        if(bdLocation.getLocType()!=61&&bdLocation.getLocType()!=161) {
            locaFailed = true;
            textView_location.setText( Html.fromHtml("<font color = black>定位失败   </font><font color = red>点击重试！！！</font>"));
            return;
        }
        String  latitude = bdLocation.getLatitude()+"";
        String   longitude = bdLocation.getLongitude()+"";
        Log.i("msg","longitude-->"+longitude);
        HttpHelper.getDataNowCity(longitude,latitude, new HttpCallBack<LocationBean>() {
            @Override
            public void onSuccess(LocationBean result) {
                if(result!=null){
                    locationCity = result.result;
                    textView_location.setText(locationCity.name);
                    locaFailed = false;
                }
            }
            @Override
            public void onFail(String errMsg) {
                locaFailed = true;
                textView_location.setText( Html.fromHtml("<font color = black>定位失败   </font><font color = red>点击重试！！！</font>"));
            }
        },this);
    }
    public void listViewItemOnClick(){
        listViewContent.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }
            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                if(i>0){
                    CityListAdapter.MyCityViewHolder viewHolder = (CityListAdapter.MyCityViewHolder) (listViewContent.getAdapter()).getView(i,null,listViewContent).getTag();
                    if(viewHolder!=null){
                        if(viewHolder.tvTitle.getVisibility()==View.VISIBLE){
                            textView_cityName.setText(viewHolder.tvTitle.getText());
                            textView_cityName.setVisibility(View.VISIBLE);
                            showFloatTitle = true;
                        }else if(showFloatTitle){
                            textView_cityName.setText(viewHolder.tvTitle.getText());
                            textView_cityName.setVisibility(View.VISIBLE);
                            showFloatTitle = false;
                        }
                    }
                }else textView_cityName.setVisibility(View.GONE);
                if(i1+i==i2){textView_cityName.setVisibility(View.GONE);}
            }
        });
        listViewSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String content= (String) ((TextView)view).getText();
                if(position.get(content)==null)listViewContent.setSelection(0);
                else listViewContent.setSelection(position.get(content)+1);
            }
        });
    }
   //请求网络数据···
    private void  getData(){
        HttpHelper.getDataCityList("4", new HttpCallBack<CityListBean>() {
            @Override
            public void onSuccess(CityListBean result) {
                if(result==null){
                    loadAnimation.failLoadNodata(loadListener);
                    return;
                }
                openCityList = result.result.openCitys;
                hotCityList= result.result.hotCitys;
                if (hotCityList==null){
                    listView_hotCity.setVisibility(View.GONE);
                    loadAnimation.failLoadNodata(loadListener);
                    return;
                }
                setHeadViewList(hotCityList,listView_hotCity);
                setSurroundListView();
                setCityList();
                listViewContent.setVisibility(View.VISIBLE);
                listViewSearch.setVisibility(View.VISIBLE);
                loadAnimation.successLoad();
                listViewItemOnClick();
            }
            @Override
            public void onFail(String errMsg) {
                loadAnimation.failLoadNoNetWork(loadListener);
            }
        });
    }
    //设置城市数据列表···
    private void setCityList(){
        if(openCityList!=null){
            Collections.sort(openCityList);
            listViewContent.setAdapter(new CityListAdapter(openCityList,this,listener,currentCity));
            for (int i = 0; i <openCityList.size() ; i++) {
                String first = openCityList.get(i).pinyin.toUpperCase().trim().substring(0,1);
                if (!searchlist.contains(first)){
                    searchlist.add(first);
                    position.put(first,i);
                }
                listViewSearch.setAdapter(new CitylistSearchAdapter(searchlist,this));
            }
        }
    }
    //设置热门城市数据加载···
    private void  setHeadViewList(List<CityListBean.CityListResult.OpenCity> openCityList,ListView listView){
        List<List<CityListBean.CityListResult.OpenCity>> hotlist = new ArrayList<>();
        List<CityListBean.CityListResult.OpenCity> hotCityList1 =new ArrayList<>();
        for (int i = 0; i < openCityList.size(); i++) {
            if(i%4==0){
                if(i==0) hotlist.add(hotCityList1);
                else {
                    hotCityList1 = new ArrayList<>();
                    hotlist.add(hotCityList1);
                }
            }
            hotCityList1.add(openCityList.get(i));
        }
        listView.setAdapter(new CityListHeadAdapter(hotlist,CityListActivity.this,listener,currentCity));
        ListViewUtils.measureListViewHeight(listView);
    }
   //设置周边城市数据加载···
    private void setSurroundListView(){
        List<CityListBean.CityListResult.OpenCity> CityList =new ArrayList<>();
        List<CityListBean.CityListResult.OpenCity> CityList1 =new ArrayList<>();
        CityList.addAll(openCityList);
        CityList.addAll(hotCityList);
        Random random = new Random();
        while (true){
            int position = random.nextInt(CityList.size());
            if(!CityList1.contains(CityList.get(position)))CityList1.add(CityList.get(position));
            if(CityList1.size()==4)break;
        }
        setHeadViewList(CityList1,listViewSurround);
    }
    //城市列表的内容点击监听回调跳转
    private CityListAdapter.CitySelectListener listener  =  new CityListAdapter.CitySelectListener() {
        @Override
        public void cityMessage(CityListBean.CityListResult.OpenCity openCity) {
            if(openCity==null)return;
            String cityName = openCity.name;
            String cityId = openCity.id;
            Bundle bundle = new Bundle();
            bundle.putString("cityName",cityName);
            bundle.putString("cityId",cityId);
            Intent intent = new Intent();
            intent.putExtras(bundle);
            CityListActivity.this.setResult(RequestAndResultCode.CityListResultCode,intent);
            CityListActivity.this.finish();
        }
    };


    //下载动画的重新下载的案件监听
    private LoadAnimation.LoadListener loadListener = new LoadAnimation.LoadListener() {
        @Override
        public void reLoad() {
            loadAnimation.startLoadAnimation();
            getData();
        }
    };
    @Override
    protected void onDestroy() {
        //取消下载动画的timer;
        if(loadAnimation!=null)loadAnimation.release();
        super.onDestroy();
    }
}
