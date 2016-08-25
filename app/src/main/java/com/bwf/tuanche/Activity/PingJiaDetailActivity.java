package com.bwf.tuanche.Activity;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;
import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.ListViewUtils;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.Adatper.AllpingjiaAdapter;
import com.bwf.tuanche.R;
import com.bwf.tuanche.eneity.Allping.Comment;
import com.bwf.tuanche.eneity.Allping.CommentListBean;

import java.util.ArrayList;
import java.util.List;

public class PingJiaDetailActivity extends BaseActivity implements Handler.Callback{
    private ListView listofpingjia;

    private String brandId,cityid;

    private float down,move,up;//根据动作不同拿到相应的坐标

    private TextView footView,tv_back;

    private Handler handler;

    private List<CommentListBean> listBeen;

    private int first,screennum,itemnum,page=0,item=10,state,heiget;

    private AllpingjiaAdapter adapter;

    private View headview;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ping_jia_detail;
    }

    @Override
    public void beforeInitView() {
        brandId=getIntent().getStringExtra("brandId");
        cityid=getIntent().getStringExtra("cityId");
    }

    @Override
    public void initView() {
        listofpingjia=findViewByIdNoCast(R.id.listofpingjia);
        tv_back= (TextView) findViewById(R.id.img_pngjiaback);
        tv_back.setOnClickListener(this);
        adapter=new AllpingjiaAdapter(this);
        listofpingjia.setAdapter(adapter);
        handler=new Handler(this);
        footView=new TextView(this);
        listBeen=new ArrayList<>();
        footView.setText("加载中，请稍后。。。");
        footView.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        footView.setHeight(50);
        footView.setGravity(Gravity.CENTER);
        footView.setTextSize(15);
        footView.setTextColor(getResources().getColor(R.color.black));
        listofpingjia.addFooterView(footView);
        headview=View.inflate(this,R.layout.fcheadview,null);
        listofpingjia.addHeaderView(headview);
        ListViewUtils.measureView(headview);
        heiget=headview.getMeasuredHeight();
        headview.setPadding(0,-(heiget),0,0);
        LogUtils.e(headview.getMeasuredHeight()+"123456");
    }

    @Override
    public void initData() {
        getData();
        //通过滑动状态及item位置确定是否完成数据请求
        listofpingjia.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                state=i;
                handler.sendEmptyMessageDelayed(1,1000);
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                    first=i;
                    screennum=i1;
                    itemnum=i2;
            }
        });
        //监听滑动，通过是否有下拉动作来确定是否下拉刷新，在使用OnScrollChangeListener监听时需要自定义View暴露出接口
        listofpingjia.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch(motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        down=motionEvent.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        move=motionEvent.getRawY();
                        LogUtils.e("Move:"+move+"Down:"+down);
                        if(move-down>0&&first==0){
                            LogUtils.e("刷："+((int)(move-down)-50));
                            headview.setPadding(0,(int)(move-down)-50,0,0);
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        headview.setPadding(0,0,0,0);
                        handler.sendEmptyMessageDelayed(2,1500);
                        break;
                }

                return false;
            }
        });


    }

    private void getData(){
        HttpHelper.getDataAllPinglun(item+"", page+"", cityid, brandId, new HttpCallBack<Comment>() {
            @Override
            public void onSuccess(Comment result) {
                listBeen.addAll(result.result.commentList);
                adapter.setAdapterdata(listBeen);
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onFail(String errMsg) {
                ToastUtil.showToast("请求失败"+errMsg);
            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_pngjiaback:
                this.finish();
            break;
        }
    }

    @Override
    public boolean handleMessage(Message message) {
        switch(message.what){
            case 1:
                LogUtils.e("first:"+first+"screennum:"+screennum+"itemnum:"+itemnum);
                if(state==0&&first+screennum==itemnum){
                    if((itemnum-2)%10==0){
                        page++;
                        item=+10;
                        getData();
                    }else if((itemnum-2)%10!=0||screennum==itemnum) {
                        footView.setText("已经是全部了");
                        footView.setTextColor(Color.RED);
                    }
                }
                break;
            case 2:
                headview.setPadding(0,-heiget,0,0);
                break;

        }

        return false;
    }
}
