package com.bwf.tuanche.sql;

import java.util.Comparator;

/**
 * Created by fengchao on 2016/8/19.
 * Description：
 */
public class HistoryBean implements Comparable<HistoryBean>{
    public String name;
    public long time;

    public HistoryBean() {
    }

    @Override
    public String toString() {
        return "HistoryBean{" +
                "name='" + name + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public HistoryBean(String name, long time) {
        this.name = name;
        this.time = time;
    }

    @Override
    public int compareTo(HistoryBean historyBean) {
        if(historyBean.time<this.time){
            return -1;
        }
        if(historyBean.time>this.time){
            return 1;
        }
        return 0;
    }
}
