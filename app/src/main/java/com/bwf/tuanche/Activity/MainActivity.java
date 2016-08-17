package com.bwf.tuanche.Activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.tuanche.MainListActivity;
import com.bwf.tuanche.R;

public class MainActivity extends BaseActivity {

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void beforeInitView() {
//        Intent intent=new Intent(this,MainListActivity.class);
//        startActivity(intent);
    }

    @Override
    public void initView() {
        Button AAAA = findViewByIdNoCast(R.id.AAAA);
        AAAA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentUtils.openActivity(MainActivity.this,CarContentActivity.class);
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {

    }
}
