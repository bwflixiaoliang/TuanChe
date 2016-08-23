package com.bwf.tuanche.Activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.R;
import com.bwf.tuanche.eneity.searchonly.ResultBean;

public class Search_only_Activity extends BaseActivity {
    private ListView searchonly_list;

    private EditText editText;

    private String nr;

    @Override
    public int getContentViewId() {
        return R.layout.activity_search_only;
    }

    @Override
    public void beforeInitView() {
        nr = getIntent().getStringExtra("123");
    }

    @Override
    public void initView() {
        editText = findViewByIdNoCast(R.id.searchonly_wodesousuo);
        searchonly_list = findViewByIdNoCast(R.id.searchonly_list);
    }

    @Override
    public void initData() {
        if (nr != null)
            editText.setText(nr);
        HttpHelper.getDataCarByBrand("0", "156", "31", new HttpCallBack<ResultBean>() {
            @Override
            public void onSuccess(ResultBean result) {
                ToastUtil.showToast(result.toString());
            }

            @Override
            public void onFail(String errMsg) {
                ToastUtil.showToast(errMsg);
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}
