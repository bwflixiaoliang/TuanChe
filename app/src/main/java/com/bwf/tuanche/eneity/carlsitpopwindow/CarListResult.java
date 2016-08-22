package com.bwf.tuanche.eneity.carlsitpopwindow;

import com.bwf.framwork.base.BaseBean;

import java.util.List;

/**
 * Created by che on 2016/8/20
 * Description:.
 */
public class CarListResult extends BaseBean{

    public List<CarListStytleBean> result;

    @Override
    public String toString() {
        return "CarListResult{" +
                "result=" + result +
                '}';
    }
}
