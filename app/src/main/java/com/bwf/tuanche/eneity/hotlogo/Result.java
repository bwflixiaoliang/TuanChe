package com.bwf.tuanche.eneity.hotlogo;

import com.bwf.framwork.base.BaseBean;

import java.util.List;

/**
 * Created by fengchao on 2016/8/16.
 * Description：
 */
public class Result extends BaseBean{

    public List<HotLogo>  list;

    @Override
    public String toString() {
        return "Result{" +
                "list=" + list +
                '}';
    }
}
