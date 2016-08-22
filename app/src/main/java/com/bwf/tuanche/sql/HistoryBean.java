package com.bwf.tuanche.sql;

/**
 * Created by fengchao on 2016/8/19.
 * Description：
 */
public class HistoryBean {
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
}
