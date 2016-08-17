package com.bwf.tuanche.eneity.TuanChe;

import java.io.Serializable;

/**
 * Created by fengchao on 2016/8/16.
 * Description：
 */
public class Nc implements Serializable{
    public String weight;

    public String name;

    public String pic;

    public String show;

    public String type;

    public String modules;

    public String is_ng;

    public String is_login;

    @Override
    public String toString() {
        return "Nc{" +
                "weight='" + weight + '\'' +
                ", name='" + name + '\'' +
                ", pic='" + pic + '\'' +
                ", show='" + show + '\'' +
                ", type='" + type + '\'' +
                ", modules='" + modules + '\'' +
                ", is_ng='" + is_ng + '\'' +
                ", is_login='" + is_login + '\'' +
                '}';
    }
}
