package com.bwf.tuanche.eneity.hotlogo;

import java.io.Serializable;

/**
 * Created by fengchao on 2016/8/16.
 * Description：
 */
public class HotLogo implements Serializable{

    public String id;
    public String name;
    public String logo;
    public String baseNum;
    public String modelType;

    @Override
    public String toString() {
        return "HotLogo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                ", baseNum='" + baseNum + '\'' +
                ", modelType='" + modelType + '\'' +
                '}';
    }
}

