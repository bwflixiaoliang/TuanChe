package com.bwf.tuanche.Activity;

import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.map.MapLocation;
import com.bwf.framwork.utils.ListViewUtils;
import com.bwf.tuanche.Adatper.CityListAdapter;
import com.bwf.tuanche.Adatper.CityListHeadAdapter;
import com.bwf.tuanche.Adatper.CitylistSearchAdapter;
import com.bwf.tuanche.R;
import com.bwf.tuanche.eneity.CityList.CityListBean;
import com.bwf.tuanche.eneity.location.LocationBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CityListActivity extends BaseActivity implements BDLocationListener{
    private String currentCity;
    private TextView textView_title,textView_location,textView_cityName;
    private ListView listView_hotCity,listViewContent,listViewSearch;
    private View headView;
    private LocationBean.LocationCity locationCity;
    private List<CityListBean.CityListResult.OpenCity> openCityList;
    private List<CityListBean.CityListResult.HotCity> hotCityList;
    private List<String> searchlist;
    @Override
    public int getContentViewId() {
        return R.layout.activity_city_list;
    }

    @Override
    public void beforeInitView() {
        currentCity = getIntent().getStringExtra("currentCity");
        new MapLocation().onCreate(this,this);
    }

    @Override
    public void initView() {
        searchlist = new ArrayList<>();
        searchlist.add("#");
        searchlist.add("&");
        searchlist.add("*");
        setOnClick(R.id.citylist_imageBack);
        textView_title = findViewByIdNoCast(R.id.citylist_textTitle);
        listViewContent = findViewByIdNoCast(R.id.citylist_listContent);
        listViewSearch = findViewByIdNoCast(R.id.citylist_searchlist);
        textView_cityName = findViewByIdNoCast(R.id.citylist_list_tvTitle);
        //listview的headerView设置
        headView = View.inflate(this,R.layout.citylist_header,null);
        textView_location = (TextView) headView.findViewById(R.id.citylist_textLocation);
        listView_hotCity = (ListView) headView.findViewById(R.id.citylist_hotCity);
        listViewContent.addHeaderView(headView);
    }

    @Override
    public void initData() {
        if(currentCity!=null)textView_title.setText(String.format(getString(R.string.nowCity_name),currentCity));
        else textView_title.setText(String.format(getString(R.string.nowCity_name),"未知"));
        getData();
        listViewItemOnClick();
    }

    @Override
    public void onClick(View view) {

    }
    public void listViewItemOnClick(){
        listViewContent.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                Log.i("msg","positio-->"+i);
                if(i>0){
                    CityListAdapter.MyCityViewHolder viewHolder = (CityListAdapter.MyCityViewHolder) (listViewContent.getAdapter()).getView(i,null,listViewContent).getTag();
                    if(viewHolder!=null){
                        if(viewHolder.tvTitle.getVisibility()==View.VISIBLE){
                            textView_cityName.setText(viewHolder.tvTitle.getText());
                            textView_cityName.setVisibility(View.VISIBLE);
                        }
                    }
                }else textView_cityName.setVisibility(View.GONE);
                if(i1+i==i2){textView_cityName.setVisibility(View.GONE);}
            }
        });
    }
    private void  getData(){
        HttpHelper.getDataCityList("4", new HttpCallBack<CityListBean>() {

            @Override
            public void onSuccess(CityListBean result) {
                if(result==null){

                    return;
                }
                openCityList = result.result.openCitys;
                hotCityList= result.result.hotCitys;
                if (hotCityList==null){
                    listView_hotCity.setVisibility(View.GONE);
                    return;
                }
                List<List<CityListBean.CityListResult.HotCity>> hotlist = new ArrayList<>();
                List<CityListBean.CityListResult.HotCity> hotCityList1 =new ArrayList<CityListBean.CityListResult.HotCity>();
                for (int i = 0; i < hotCityList.size(); i++) {
                    if(i%4==0){
                        if(i==0) hotlist.add(hotCityList1);
                        else {
                            hotCityList1 = new ArrayList<>();
                            hotlist.add(hotCityList1);
                        }
                    }
                    hotCityList1.add(hotCityList.get(i));
                }
                Log.i("msg","hotlist--->"+hotlist.size());
                listView_hotCity.setAdapter(new CityListHeadAdapter(hotlist,CityListActivity.this));
                ListViewUtils.measureListViewHeight(listView_hotCity);
                setCityList();
            }
            @Override
            public void onFail(String errMsg) {

            }
        });
    }
    private void setCityList(){
        if(openCityList!=null){
            Collections.sort(openCityList);
            Log.i("msg","openCityList--sort--->"+openCityList.toString());
            listViewContent.setAdapter(new CityListAdapter(openCityList,this));
            for (int i = 0; i <openCityList.size() ; i++) {
                String first = openCityList.get(i).pinyin.toUpperCase().trim().substring(0,1);
                if (!searchlist.contains(first))searchlist.add(first);
                listViewSearch.setAdapter(new CitylistSearchAdapter(searchlist,this));
            }
        }
    }
    @Override
    public void onReceiveLocation(BDLocation bdLocation) {
        Log.i("msg","<-------onReceiveLocation------->");
        if(bdLocation==null){
            textView_location.setText( Html.fromHtml("<font color = black>定位失败   </font><font color = red>点击重试！！！</font>"));
            return;
        }
        if(bdLocation.getLocType()!=61&&bdLocation.getLocType()!=161) {
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
                }
            }
            @Override
            public void onFail(String errMsg) {
                textView_location.setText( Html.fromHtml("<font color = black>定位失败   </font><font color = red>点击重试！！！</font>"));
            }
        },this);
    }
}
