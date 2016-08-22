package com.bwf.tuanche.fragment.DetailFramgent;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bwf.framwork.base.BaseBean;
import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.R;
import com.bwf.tuanche.View.Popwindow_buycarStyle;
import com.bwf.tuanche.eneity.TestResult;
import com.bwf.tuanche.eneity.detail.DetailResult;
import com.bwf.tuanche.eneity.detail.DetailResultBean;
import com.bwf.tuanche.eneity.hotlogo.HotLogo;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by fengchao on 2016/8/20.
 * Description：
 */
public class DetailFragment1 extends BaseFragment{
    private SimpleDraweeView simpleDraweeView;

    private Button deatil_bt_button,deatil_bt_buystyle;

    private TextView baoming,leiji,jiesheng,tuangou_time,tuangou_address;

    @Override
    protected int getResource() {
        return R.layout.deatil_fragment1;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        deatil_bt_buystyle=findViewByIdNoCast(R.id.deatil_bt_buystyle);
        deatil_bt_buystyle.setOnClickListener(this);
        simpleDraweeView=findViewByIdNoCast(R.id.deatil_img);
        deatil_bt_button=findViewByIdNoCast(R.id.deatil_bt_button);
        baoming=findViewByIdNoCast(R.id.baoming);
        leiji=findViewByIdNoCast(R.id.leiji);
        jiesheng=findViewByIdNoCast(R.id.jiesheng);
        tuangou_time=findViewByIdNoCast(R.id.tuangou_time);
        tuangou_address=findViewByIdNoCast(R.id.tuangou_address);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.deatil_bt_buystyle:
                Popwindow_buycarStyle popwindow_buycarStyle=new Popwindow_buycarStyle(getContext());
                popwindow_buycarStyle.showPop(getActivity().findViewById(R.id.main));
                break;
        }
    }
    public  void getdata(final HotLogo hotLogo,DetailResult detailResult){
        simpleDraweeView.setImageURI(detailResult.logo);
        deatil_bt_button.setText(hotLogo.name);
        baoming.setText(detailResult.manNum+"人");
        leiji.setText(detailResult.saveUpString);
        jiesheng.setText(detailResult.saveUpMoney);
        String time=detailResult.groupbuyDate+"("+detailResult.groupbuyWeek+")";
        tuangou_time.setText(String.format(tuangou_time.getText().toString(),time));
        String address=detailResult.regular4sShop;
        tuangou_address.setText(String.format(tuangou_address.getText().toString(),address));
    }
}
