package com.bwf.tuanche.View;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwf.tuanche.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by lixiaoliang on 2016/8/19.
 * Description:
 */
public class LoadAnimation extends RelativeLayout implements View.OnClickListener {
    private View rootView;
    private ImageView imageView_anima;
    private TextView tv_loading, tv_loaded;
    private AnimationDrawable drawable;
    private LoadListener listener;
    private Timer timer;
    private String[] loadingText = new String[]{"加载中", "加载中·", "加载中··", "加载中···"};
    private int count;

    public LoadAnimation(Context context) {
        this(context, null);
    }

    public LoadAnimation(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadAnimation(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public void setListener(LoadListener listener) {
        this.listener = listener;
    }

    private void initView(Context context) {
        rootView = View.inflate(context, R.layout.loadanimation, null);
        imageView_anima = (ImageView) rootView.findViewById(R.id.animation_image);
        tv_loading = (TextView) rootView.findViewById(R.id.animation_textloading);
        tv_loaded = (TextView) rootView.findViewById(R.id.animation_textloaded);
        tv_loaded.setOnClickListener(this);
        addView(rootView);
        startLoadAnimation();
    }

    public void startLoadAnimation() {
        timer = new Timer();
        tv_loaded.setVisibility(GONE);
        tv_loading.setVisibility(VISIBLE);
        imageView_anima.setBackgroundResource(R.drawable.loading);
        if (getVisibility() != VISIBLE) setVisibility(VISIBLE);
        drawable = (AnimationDrawable) imageView_anima.getBackground();
        if (drawable != null && !drawable.isRunning()) drawable.start();
        timer.schedule(getTimerTask(), 500, 500);
    }

    public void successLoad() {
        if (timer != null) {
            timer.cancel();
            timer = null;
            count = 0;
        }
        if (drawable != null && drawable.isRunning()) drawable.stop();
        drawable = null;
        setVisibility(GONE);
    }

    public void failLoadNodata(LoadListener listener) {
        this.listener = listener;
        if(timer!=null){timer.cancel();timer=null;count=0;}
        tv_loaded.setVisibility(VISIBLE);
        tv_loading.setVisibility(GONE);
        if (drawable != null && drawable.isRunning()) drawable.stop();
        drawable = null;
        imageView_anima.setBackgroundResource(R.mipmap.loading_nodata);
        tv_loaded.setText("暂无数据 点击重试");
    }

    public void failLoadNoNetWork(LoadListener listener) {
        this.listener = listener;
        if(timer!=null){timer.cancel();timer=null;count=0;}
        tv_loaded.setVisibility(VISIBLE);
        tv_loading.setVisibility(GONE);
        if (drawable != null && drawable.isRunning()) drawable.stop();
        drawable = null;
        imageView_anima.setBackgroundResource(R.mipmap.loading_nonetwork);
        tv_loaded.setText("网络连接失败 点击重试");
    }

    public TimerTask getTimerTask() {
        return new TimerTask() {
            @Override
            public void run() {
                if (count == 4) count = 0;
                post(new Runnable() {
                    @Override
                    public void run() {
                        tv_loading.setText(loadingText[count % 4]);
                    }
                });
                count++;
            }
        };
    }

    public void release() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    @Override
    public void onClick(View view) {
        if (view == tv_loaded) {
            if (listener != null) listener.reLoad();
        }
    }

    public interface LoadListener {
        void reLoad();
    }
}
