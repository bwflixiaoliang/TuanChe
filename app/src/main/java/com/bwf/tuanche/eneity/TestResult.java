package com.bwf.tuanche.eneity;

import com.bwf.framwork.base.BaseBean;

/**
 * Created by fengchao on 2016/8/21.
 * Description：
 */
public class TestResult extends BaseBean{

    public MyText result;

    @Override
    public String toString() {
        return "TestResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }
}
