package com.bwf.tuanche.View;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
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
    private View HeaderView;
    private View rootView;
    private int headerHeight;
    private boolean isFirst =true;
    private TextView tv_title;
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
        rootView = View.inflate(context, R.layout.refresh_scrollview,null);
        HeaderView = rootView.findViewById(R.id.scrollView_header);
        tv_title = (TextView)HeaderView.findViewById(R.id.refresh_tvTitle);
        screenHeight = DisplayUtil.getDensity_Height(context);
        addView(rootView);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.i("msg","onMeasure"+widthMeasureSpec);
        if(isFirst){
            HeaderView.measure(0,0);
            headerHeight = HeaderView.getMeasuredHeight();
            isFirst = false;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if(changed){
            HeaderView.setPadding(0,-headerHeight,0,0);
        }
    }
    private int startY;
    private int moveY;
    private int startScrollY;
    private boolean upToRefresh;
    private boolean isComplement = true;
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                startScrollY = getScrollY();
                Log.i("msg","scrollY"+startScrollY);
                startY  = (int) ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                if(!isComplement)break;
                moveY = (int)ev.getY()-startY;
                if(moveY>0&& moveY<screenHeight/5&&startScrollY==0){
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
                if(startScrollY==0&&isComplement){
                    if(upToRefresh){
                        HeaderView.setPadding(0,0,0,0);
                        isComplement = false;
                        if(listenr!=null)listenr.refresh();
                    }
                    else HeaderView.setPadding(0,-headerHeight,0,0);
                }
                break;
        }
        return super.onTouchEvent(ev);
    }
    public interface PullListenr{
        void refresh();
    }
    public void refreshComplete(){
        isComplement = true;
        HeaderView.setPadding(0,-headerHeight,0,0);
        tv_title.setText("下拉刷新");
    }
}
