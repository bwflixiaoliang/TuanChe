package com.bwf.tuanche.eneity.hotlogo;

import com.bwf.framwork.base.BaseBean;

/**
 * Created by fengchao on 2016/8/16.
 * Description：
 */
public class Result extends BaseBean{

    public ResultBean result;

    @Override
    public String toString() {
        return "Result{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }
}
