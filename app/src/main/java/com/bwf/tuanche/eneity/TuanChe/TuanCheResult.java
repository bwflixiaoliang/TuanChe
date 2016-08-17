package com.bwf.tuanche.eneity.TuanChe;

import com.bwf.framwork.base.BaseBean;

/**
 * Created by fengchao on 2016/8/16.
 * Description：
 */
public class TuanCheResult extends BaseBean{
    public String code;

    public String msg;

    public TuanCheResultBean result;

    @Override
    public String toString() {
        return "TuanCheResult{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }
}
