package com.bwf.tuanche.eneity.Banner;

import java.io.Serializable;

/**
 * Created by fengchao on 2016/8/18.
 * Description：
 */
public class PositionBanner implements Serializable{
    public String subTitle;

    public String bigTitle;

    @Override
    public String toString() {
        return "PositionBanner{" +
                "subTitle='" + subTitle + '\'' +
                ", bigTitle='" + bigTitle + '\'' +
                ", adpInfoUrl='" + adpInfoUrl + '\'' +
                ", positionId='" + positionId + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", positionType='" + positionType + '\'' +
                ", adType='" + adType + '\'' +
                '}';
    }

    public String adpInfoUrl;

    public String positionId;

    public String iconUrl;

    public String positionType;

    public String adType;
}
