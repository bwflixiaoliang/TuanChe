package com.bwf.tuanche.eneity.detail;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fengchao on 2016/8/20.
 * Description：
 */
public class Buyway implements Serializable{
    public List<BuywayList> buyWayList;
    public String  showWhere;//"showWhere": 2,

    @Override
    public String toString() {
        return "Buyway{" +
                "buyWayList=" + buyWayList +
                ", showWhere='" + showWhere + '\'' +
                ", isMust='" + isMust + '\'' +
                '}';
    }

    public String  isMust;// "isMust":

}
