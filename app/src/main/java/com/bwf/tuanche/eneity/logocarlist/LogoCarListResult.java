package com.bwf.tuanche.eneity.logocarlist;

import com.bwf.framwork.base.BaseBean;

import java.util.List;

/**
 * Created by che on 2016/8/19
 * Description:.
 */
public class LogoCarListResult extends BaseBean {

    public List<LogoCarListBean> result;

    @Override
    public String toString() {
        return "LogoCarListResult{" +
                "result=" + result +
                '}';
    }
}
