package com.bwf.tuanche.eneity.detail;

import java.io.Serializable;

/**
 * Created by fengchao on 2016/8/21.
 * Description：
 */
public class Xiangqing implements Serializable{
    public String id;

    public String dataType;

    public String datakey;

    public String dataValue;

    public String title;

    public String describe;

    public String linkurl;

    public String imgurl;

    public String versionCode;

    public String sourceId;

    public String sort;

    public String status;

    public String isDel;

    public String createTime;

    @Override
    public String toString() {
        return "Xiangqing{" +
                "id='" + id + '\'' +
                ", dataType='" + dataType + '\'' +
                ", datakey='" + datakey + '\'' +
                ", dataValue='" + dataValue + '\'' +
                ", title='" + title + '\'' +
                ", describe='" + describe + '\'' +
                ", linkurl='" + linkurl + '\'' +
                ", imgurl='" + imgurl + '\'' +
                ", versionCode='" + versionCode + '\'' +
                ", sourceId='" + sourceId + '\'' +
                ", sort='" + sort + '\'' +
                ", status='" + status + '\'' +
                ", isDel='" + isDel + '\'' +
                ", createTime='" + createTime + '\'' +
                ", ts='" + ts + '\'' +
                '}';
    }

    public String ts;
}
