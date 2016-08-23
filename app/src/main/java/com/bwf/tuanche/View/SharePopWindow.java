package com.bwf.tuanche.View;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.bwf.framwork.utils.DisplayUtil;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.R;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

/**
 * Created by che on 2016/8/23
 * Description:.
 */
public class SharePopWindow extends PopupWindow implements View.OnClickListener {

    private Activity activity;
    private View shareView;

    private ImageView share_to_qqF, share_to_qqZ, share_to_sina, share_to_qqW, share_finsh;
    private UMShareAPI shareAPI;

    public SharePopWindow(Activity activity) {
        this.activity = activity;
        initView();
    }

    public void initView() {
//        shareAPI = UMShareAPI.get(context);
        shareView = View.inflate(activity, R.layout.item_share_lin, null);
        this.setContentView(shareView);
        this.setWidth(DisplayUtil.getDensity_Width(activity));
        this.setHeight(DisplayUtil.getDensity_Height(activity) / 3);
        this.setFocusable(true);
        this.setBackgroundDrawable(new BitmapDrawable());
        this.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        //从底部弹出的动画
        this.setAnimationStyle(R.style.PopupShareAnimatiom);

        //引用图片文件
        share_to_qqF = (ImageView) shareView.findViewById(R.id.share_to_qqF);
        share_to_qqZ = (ImageView) shareView.findViewById(R.id.share_to_qqZ);
        share_to_sina = (ImageView) shareView.findViewById(R.id.share_to_sina);
        share_to_qqW = (ImageView) shareView.findViewById(R.id.share_to_qqW);
        share_finsh = (ImageView) shareView.findViewById(R.id.share_finsh);
        share_to_qqF.setOnClickListener(this);
        share_to_qqZ.setOnClickListener(this);
        share_to_sina.setOnClickListener(this);
        share_to_qqW.setOnClickListener(this);
        share_finsh.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //qq好友分享
            case R.id.share_to_qqF:
                new ShareAction(activity)
                        .setPlatform(SHARE_MEDIA.QQ)//设置QQ好友分享/QQ空间分享
                        .withTitle("This is my testProirct!")//设置分享的标题
                        .withText("Thank you downLoading!")//设置分享的内容
                        .withTargetUrl("http://www.baidu.com")//设置分享的网址
                        .withMedia(new UMImage(activity,//设置分享的图片url
                                "http://www.umeng.com/img/index/demo/12.cf56415c00129a80620855a35df7fc9f.png"))
                        .setCallback(new UMShareListener() {//回调分享状态（要重写onActivityResult方法）
                            @Override
                            public void onResult(SHARE_MEDIA share_media) {
                                Toast.makeText(activity,"Share Suess！",Toast.LENGTH_SHORT).show();
                            }
                            @Override
                            public void onError(SHARE_MEDIA share_media, Throwable throwable) {
                                Toast.makeText(activity,"Share Fail！",Toast.LENGTH_SHORT).show();
                            }
                            @Override
                            public void onCancel(SHARE_MEDIA share_media) {
                                Toast.makeText(activity,"Share Nothing！",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .share();//分享
                break;
            //qq空间分享
            case R.id.share_to_qqZ:
                new ShareAction(activity)
                        .setPlatform(SHARE_MEDIA.QZONE)//设置QQ好友分享/QQ空间分享
                        .withTitle("This is my testProirct!")//设置分享的标题
                        .withText("Thank you downLoading!")//设置分享的内容
                        .withTargetUrl("http://www.baidu.com")//设置分享的网址
                        .withMedia(new UMImage(activity,//设置分享的图片url
                                "http://www.umeng.com/img/index/demo/12.cf56415c00129a80620855a35df7fc9f.png"))
                        .setCallback(new UMShareListener() {//回调分享状态（要重写onActivityResult方法）
                            @Override
                            public void onResult(SHARE_MEDIA share_media) {
                                Toast.makeText(activity,"Share Suess！",Toast.LENGTH_SHORT).show();
                            }
                            @Override
                            public void onError(SHARE_MEDIA share_media, Throwable throwable) {
                                Toast.makeText(activity,"Share Fail！",Toast.LENGTH_SHORT).show();
                            }
                            @Override
                            public void onCancel(SHARE_MEDIA share_media) {
                                Toast.makeText(activity,"Share Nothing！",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .share();//分享
                break;
            case R.id.share_to_sina:
                ToastUtil.showToast("分享到新浪微博");
                break;
            case R.id.share_to_qqW:
                ToastUtil.showToast("分享到QQ微博");
                break;
            case R.id.share_finsh:
                SharePopWindow.this.dismiss();
                break;
        }
    }

    //显示PopWindow的方法
    //PopWindow与DiaLog不同的地方是，它可以显示在指定的位置
    public void showPopWindow() {
        if (!isShowing()) {
            this.showAtLocation(shareView,Gravity.RIGHT | Gravity.BOTTOM ,0,0);
        }
    }

    public interface ShareCallBack{
        void showShare();
    }


//    //QQ好友/空间分享的回调
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        UMShareAPI.get( activity ).onActivityResult( requestCode, resultCode, data);
//    }

}
