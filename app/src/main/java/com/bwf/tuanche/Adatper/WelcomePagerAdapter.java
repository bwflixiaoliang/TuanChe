package com.bwf.tuanche.Adatper;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bwf.framwork.share.SharePrefreceHelper;
import com.bwf.framwork.utils.DisplayUtil;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.tuanche.Activity.CityListActivity;
import com.bwf.tuanche.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lixiaoliang on 2016/8/17.
 * Description:
 */
public class WelcomePagerAdapter extends PagerAdapter implements View.OnClickListener{
    private Activity context;
    private List<RelativeLayout> relativeLayoutlist;
    public WelcomePagerAdapter(Activity context) {
        this.context = context;
        relativeLayoutlist = new ArrayList<>();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        relativeLayout.setLayoutParams(layoutParams);
        ImageView imageView = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        imageView.setLayoutParams(layoutParams1);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(R.mipmap.guide01);
        relativeLayout.addView(imageView);
        relativeLayoutlist.add(relativeLayout);
        //
        RelativeLayout relativeLayout1 = new RelativeLayout(context);
        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        relativeLayout1.setLayoutParams(layoutParams2);
        ImageView imageView1 = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        imageView1.setLayoutParams(layoutParams3);
        imageView1.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView1.setImageResource(R.mipmap.guide02);
        relativeLayout1.addView(imageView1);
        Button button = new Button(context);
        RelativeLayout.LayoutParams layoutParambutton = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParambutton.height = DisplayUtil.dip2px(context,35);
        layoutParambutton.width = DisplayUtil.dip2px(context,100);
        layoutParambutton.addRule(RelativeLayout.CENTER_HORIZONTAL);
        layoutParambutton.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        layoutParambutton.bottomMargin = DisplayUtil.dip2px(context,20);
        button.setLayoutParams(layoutParambutton);
        button.setBackgroundResource(R.drawable.start_btn_click);
        button.setOnClickListener(this);
        relativeLayout1.addView(button);
        relativeLayoutlist.add(relativeLayout1);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(relativeLayoutlist.get(position));
        return relativeLayoutlist.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(relativeLayoutlist.get(position));
    }

    @Override
    public void onClick(View view) {
        IntentUtils.openActivity(context, CityListActivity.class);
        SharePrefreceHelper.getInstence(context).setFirst();
        context.finish();
    }
}
