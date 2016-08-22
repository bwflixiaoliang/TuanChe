package com.bwf.tuanche.eneity.searchonly;

import com.bwf.framwork.base.BaseBean;

import java.util.List;

/**
 * Created by fengchao on 2016/8/19.
 * Description：
 */
public class ResultBean extends BaseBean{
    public List<SearchResult> result;

    @Override
    public String toString() {
        return "ResultBean{" +
                "result=" + result +
                '}';
    }
}
