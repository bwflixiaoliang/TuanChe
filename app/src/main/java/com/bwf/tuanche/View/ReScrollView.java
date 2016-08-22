package com.bwf.tuanche.View;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bwf.framwork.base.BaseListAdpter;
import com.bwf.framwork.utils.DisplayUtil;
import com.bwf.tuanche.R;

/**
 * Created by lixiaoliang on 2016/8/21.
 * Description:
 */
public class ReScrollView extends ScrollView {
    private View HeaderView;//下拉的View
    private LinearLayout rootView;//整个自定义view的布局
    private int headerHeight;//下拉view的原始高度
    private TextView tv_title;
    private ImageView imageView;
    private  Context context;
    private int screenHeight;
    private PullListenr listenr;
    public ReScrollView(Context context) {
        this(context,null);
    }

    public ReScrollView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ReScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initView(context);
    }

    public void setOnPullListenr(PullListenr listenr) {
        this.listenr = listenr;
    }

    private void  initView(Context context){
        if(rootView!=null)return;
        rootView = (LinearLayout) View.inflate(context, R.layout.refresh_scrollview,null);
        HeaderView = rootView.findViewById(R.id.scrollView_header);
        tv_title = (TextView)HeaderView.findViewById(R.id.refresh_tvTitle);
        imageView = (ImageView) HeaderView.findViewById(R.id.refresh_image);
        screenHeight = DisplayUtil.getDensity_Height(context);
        addView(rootView);
        HeaderView.measure(0,0);
        headerHeight = HeaderView.getMeasuredHeight();
        //测试
        imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                refreshComplete();
            }
        });
    }
    public void setContentResource(int id){
        rootView.addView(View.inflate(context,id,null));
    }
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if(changed){
            imageView.setImageResource(R.mipmap.icon_loading_refresh1);
            HeaderView.setPadding(0,-headerHeight,0,0);
            tv_title.setText("下拉刷新");
        }
    }
    //下拉动画用到的属性
    private int startY;//触摸起始的Y坐标
    private int moveY;//Y轴方向移动的距离
    private int startScrollY;//触摸起始时scrollView滚动的Y轴位置
    private boolean upToRefresh;//是否松开刷新
    private boolean isComplement = true;//是否完成刷新
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                startScrollY = getScrollY();
                startY  = (int) ev.getY();
                upToRefresh = false;
                moveY = 0;
                break;
            case MotionEvent.ACTION_MOVE:
                if(!isComplement)break;
                moveY = (int)ev.getY()-startY;
                if(moveY>0&&startScrollY==0){
                    Log.i("msg","moveY"+moveY);
                    Log.i("msg","startY---->"+startY+"<>endY---->"+ev.getY());
                    HeaderView.setPadding(0,moveY-headerHeight,0,0);
                    if(moveY>screenHeight/10){
                        tv_title.setText("松开加载");
                        upToRefresh = true;
                    }
                    else {
                        tv_title.setText("下拉刷新");
                        upToRefresh = false;
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                if(startScrollY==0&&isComplement&&moveY>0){
                    if(upToRefresh){
                        refreshAnimation();
                        if(listenr!=null)listenr.refresh();
                    }
                    else {
                        HeaderView.setPadding(0,-headerHeight,0,0);
                        scrollTo(0,0);
                    }
                }
                break;
        }
        if(!isComplement)
            return false;
        return super.onTouchEvent(ev);
    }
    public interface PullListenr{
        void refresh();
    }
    public void refreshComplete(){
        isComplement = true;
        imageView.setImageResource(R.mipmap.icon_loading_refresh1);
        HeaderView.setPadding(0,-headerHeight,0,0);
        tv_title.setText("下拉刷新");
        scrollTo(0,0);
    }
    private void refreshAnimation(){
        isComplement = false;
        HeaderView.setPadding(0,0,0,0);
        imageView.setImageResource(R.drawable.refreshing);
        tv_title.setText("数据加载中···");
        scrollTo(0,0);
    }
}
