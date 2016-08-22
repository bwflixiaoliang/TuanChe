package com.bwf.tuanche.View;

import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bwf.framwork.base.BaseBean;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.R;
import com.bwf.tuanche.eneity.VersionUpgrade.VersionBean;


/**
 * Created by lixiaoliang on 2016/8/22.
 * Description:
 */
public class VersionUpdateDialog extends Dialog implements View.OnClickListener{
    private int versionCode;
    private TextView tv_vercode, tv_upgradeContent;
    private Button btn_upgrade, btn_cancle;

    public VersionUpdateDialog(Context context) {
        this(context,android.R.style.Theme_Translucent_NoTitleBar);
    }

    public VersionUpdateDialog(Context context, int themeResId) {
        super(context, themeResId);
        initView(context);
    }

    private void initView(Context context)  {
        try {
           PackageInfo info =  context.getPackageManager().getPackageInfo(context.getPackageName(),0);
           versionCode = info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        setContentView(R.layout.versionupdatedialog);
        tv_vercode = (TextView) findViewById(R.id.upgrade_tvVersionCode);
        tv_upgradeContent = (TextView) findViewById(R.id.upgrade_tvContent);
        findViewById(R.id.upgrade_close).setOnClickListener(this);
        findViewById(R.id.upgrade_btnUpgrade).setOnClickListener(this);
        HttpHelper.getDataVersionUpgrade(new HttpCallBack<VersionBean>() {
            @Override
            public void onSuccess(VersionBean result) {
                if(result.result!=null)
                    if(Integer.parseInt(result.result.versionCode.trim())!=versionCode){
                        tv_vercode.setText("v"+result.result.versionName);
                        tv_upgradeContent.setText(result.result.description);
                        showDialog();
                    }
            }
            @Override
            public void onFail(String errMsg) {

            }
        });
    }
    public void  showDialog(){
        if(!this.isShowing())this.show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.upgrade_close:
                if(this.isShowing())this.dismiss();
                break;
            case R.id.upgrade_btnUpgrade:
                ToastUtil.showToast("升级功能暂未实现");
                break;
        }
    }
}

