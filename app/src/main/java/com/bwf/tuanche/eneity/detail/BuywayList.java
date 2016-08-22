package com.bwf.tuanche.eneity.detail;

import java.io.Serializable;

/**
 * Created by fengchao on 2016/8/20.
 * Description：
 */
public class BuywayList implements Serializable{
      public String name;// "name": "换车",

    @Override
    public String toString() {
        return "BuywayList{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public String value;//  "value": "1
}
