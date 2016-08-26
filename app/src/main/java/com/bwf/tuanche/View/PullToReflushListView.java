package com.bwf.tuanche.View;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Scroller;
import android.widget.TextView;

import com.bwf.tuanche.R;

@SuppressLint("NewApi")
public class PullToReflushListView extends ListView{
	/**头部视图的高度**/
	private int headHeight;
	/**头部视图里的容器**/
	private View headContentLayout;
	/**头部视图里的箭头**/
	private ImageView headArrowImg;
	/**头部视图里的进度条**/
	private ProgressBar headPb;
	/**头部视图里的提示作用的TextView**/
	private TextView headTickTv;
	/**头部视图里的 显示上次更新的TextView**/
	private TextView headUpdateTimeTv;
	
	private Scroller scroller;

	public PullToReflushListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public PullToReflushListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public PullToReflushListView(Context context) {
		super(context);
		init();
	}

	private void init() {
		scroller = new Scroller(getContext());
		initHeaderView();
	}
	private Animation aninDown,animUp;

	/**
	 * 初始化头部视图
	 * 1：给ListView添加头部
	 * 2：测量头部视图的高度，再给这个View设置 外上边距(tobMargin) 等于-头部视图高度。
	 * 3：找到头部视图里面的一些控件
	 */
	private void initHeaderView() {
		View headerView = LayoutInflater.from(getContext()).inflate(R.layout.refresh_list_header, null);
		headerView.measure(0, 0); //测量视图
		headHeight = headerView.getMeasuredHeight();
		addHeaderView(headerView);
		
		headContentLayout = headerView.findViewById(R.id.head_contentLayout);
		headParams = (LinearLayout.LayoutParams) headContentLayout.getLayoutParams();
		headParams.bottomMargin = -headHeight;
		headContentLayout.setLayoutParams(headParams);
		
		headArrowImg = (ImageView) headerView.findViewById(R.id.head_arrowImageView);
		headPb = (ProgressBar) headerView.findViewById(R.id.head_progressBar);
		headTickTv = (TextView) headerView.findViewById(R.id.head_tipsTextView);
		headUpdateTimeTv = (TextView) headerView.findViewById(R.id.head_lastUpdatedTextView);
		initAnim();
		//将ImageView旋转180°
		headArrowImg.setRotationX(0.5f);
		headArrowImg.setRotationY(0.5f);
		headArrowImg.setRotation(180);
	}
	
	private void initAnim() {
		aninDown = new RotateAnimation(180, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		aninDown.setDuration(500);
		aninDown.setFillAfter(true);
		
		animUp = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		animUp.setDuration(500);
		animUp.setFillAfter(true);
	}
	private static final int STATE_DONE = 1;
	private static final int STATE_PULL_TO_REFLUSH = 2;
	private static final int STATE_RELEASE_TO_REFLUSH = 3;
	private static final int STATE_REFLUSHING = 4;
	private int curState = STATE_DONE;
	private float firstDownY;
	private LinearLayout.LayoutParams headParams;
	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		Log.d(VIEW_LOG_TAG, getFirstVisiblePosition()+"");
		switch (ev.getAction()) {
		case MotionEvent.ACTION_DOWN:
			firstDownY = ev.getY();
			break;
		case MotionEvent.ACTION_MOVE:
			return handleMove(ev);
		case MotionEvent.ACTION_UP:
			handleUP(ev);
			break;
		}
		return super.onTouchEvent(ev);
	}
	/**
	 * 处理up事件
	 * @param ev
	 */
	private void handleUP(MotionEvent ev) {
		switch (curState) {
		case STATE_PULL_TO_REFLUSH:
			curState = STATE_DONE;
			smoothTo(headParams.bottomMargin, -headHeight);
			break;
		case STATE_RELEASE_TO_REFLUSH:
			curState = STATE_REFLUSHING;
			smoothTo(headParams.bottomMargin, 0);
			changeHeadByState(curState);
			//回调
			if(reflushListener != null){
				reflushListener.onReflush();
			}
			break;
		}
	}

	/**
	 * 处理move事件
	 * @param ev
	 * @return
	 */
	private boolean handleMove(MotionEvent ev){
		float offsetY = ev.getY() - firstDownY;
		switch (curState) {
		case STATE_DONE:
			if(getFirstVisiblePosition() == 0 && offsetY > 0 ){
				headParams.bottomMargin = (int) (-headHeight+offsetY/3);
				headContentLayout.setLayoutParams(headParams);
				curState = STATE_PULL_TO_REFLUSH;
			}
			break;
		case STATE_PULL_TO_REFLUSH:
			headParams.bottomMargin = (int) (-headHeight+offsetY/3);
			if(headParams.bottomMargin > 0){
				curState = STATE_RELEASE_TO_REFLUSH;
				changeHeadByState(curState);
			}
			if(headParams.bottomMargin < -headHeight){
				headParams.bottomMargin = -headHeight;
			}
			headContentLayout.setLayoutParams(headParams);
			setSelection(0);
			break;
		case STATE_RELEASE_TO_REFLUSH:
			headParams.bottomMargin = (int) (-headHeight+offsetY/3);
			if(headParams.bottomMargin < 0){
				curState = STATE_PULL_TO_REFLUSH;
				changeHeadByState(curState);
			}
			headContentLayout.setLayoutParams(headParams);
			setSelection(0);
			break;
		}
		return super.onTouchEvent(ev);
	}
	/**
	 * 通过状态来改变头部视图
	 * @param state
	 */
	private void changeHeadByState(int state){
		switch (state) {
		case STATE_PULL_TO_REFLUSH:
			headTickTv.setText("下拉刷新");
			headArrowImg.startAnimation(aninDown);
			break;
		case STATE_RELEASE_TO_REFLUSH:
			headTickTv.setText("松手刷新");
			headArrowImg.startAnimation(animUp);
			break;
		case STATE_REFLUSHING:
			headTickTv.setText("正在刷新");
			headArrowImg.setVisibility(View.GONE);
			headArrowImg.clearAnimation();
			headPb.setVisibility(View.VISIBLE);
			break;
		case STATE_DONE:
			headTickTv.setText("下拉刷新");
			headArrowImg.setVisibility(View.VISIBLE);
			headPb.setVisibility(View.GONE);
			break;
		}
	}
	
	private void smoothTo(int frombottomMargin,int tobottomMargin){
		scroller.startScroll(0, frombottomMargin, 0, tobottomMargin-frombottomMargin, 500);
		invalidate();
	}
	@Override
	public void computeScroll() {
		super.computeScroll();
		if(scroller.computeScrollOffset()){
			headParams.bottomMargin = scroller.getCurrY();
			headContentLayout.setLayoutParams(headParams);
			invalidate();
		}
	}
	
	private OnReflushListener reflushListener;
	public interface OnReflushListener{
		void onReflush();
	}
	public void setOnReflushListener(OnReflushListener listener){
		this.reflushListener = listener;
	}
	/**
	 * 当外部更新结束了，要调用这个方法
	 */
	public void reflushComplete(){
		curState = STATE_DONE;
		changeHeadByState(curState);
		smoothTo(headParams.bottomMargin, -headHeight);
	}
}
