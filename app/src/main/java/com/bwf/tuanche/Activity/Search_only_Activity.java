package com.bwf.tuanche.Activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.R;
import com.bwf.tuanche.eneity.searchonly.ResultBean;

public class Search_only_Activity extends BaseActivity {
    private ListView searchonly_list;

    private EditText editText;

    private String nr;
    private TextView tv_search;
    @Override
    public int getContentViewId() {
        return R.layout.activity_search_only;
    }

    @Override
    public void beforeInitView() {
        nr = getIntent().getStringExtra("search");
        LogUtils.i("msg","search"+nr);
    }

    @Override
    public void initView() {
        editText = findViewByIdNoCast(R.id.search_wodesousuo);
        searchonly_list = findViewByIdNoCast(R.id.searchonly_list);
        tv_search  =  findViewByIdNoCast(R.id.search_tv);
        tv_search.setVisibility(View.GONE);
        setOnClick(R.id.search_imageBack);
    }

    @Override
    public void initData() {
        if (nr != null)
            editText.setText(nr);
    }

    @Override
    public void onClick(View view) {
            switch (view.getId()){
                case R.id.search_imageBack:
                    finish();
                    break;
            }
    }
}
