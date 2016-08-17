package com.bwf.tuanche.eneity.hotcartype;

import com.bwf.framwork.base.BaseBean;

import java.util.List;

/**
 * Created by fengchao on 2016/8/16.
 * Description：
 */
public class HotCarTypeResult extends BaseBean{
    public String code;

    public String msg;

    public List<HotCarResultBean> result ;

    @Override
    public String toString() {
        return "HotCarTypeResult{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }
}
