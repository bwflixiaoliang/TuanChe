package com.bwf.tuanche.eneity.searchonly;

import java.io.Serializable;

/**
 * Created by fengchao on 2016/8/19.
 * Description：
 */
public class SearchOnly implements Serializable{
    public String id;

    public String brandId;

    public String logo;

    public String styleName;

    public String factoryPrice;

    public String content;

    public String isBuy;

    public String manNum;

    public String isNew;

    public String prefix;

    public String suffix;

    public String levelStr;

    public String brandName;

    public String carModelPrices;

    public String firmBrandId;

    public String identify;

    public String basePrice;

    public String pricePrefix;

    public String price;

    public String priceSuffix;

    public String adInfo;

    public String ecLable;
    @Override
    public String toString() {
        return "SearchOnly{" +
                "id='" + id + '\'' +
                ", brandId='" + brandId + '\'' +
                ", logo='" + logo + '\'' +
                ", styleName='" + styleName + '\'' +
                ", factoryPrice='" + factoryPrice + '\'' +
                ", content='" + content + '\'' +
                ", isBuy='" + isBuy + '\'' +
                ", manNum='" + manNum + '\'' +
                ", isNew='" + isNew + '\'' +
                ", prefix='" + prefix + '\'' +
                ", suffix='" + suffix + '\'' +
                ", levelStr='" + levelStr + '\'' +
                ", brandName='" + brandName + '\'' +
                ", carModelPrices='" + carModelPrices + '\'' +
                ", firmBrandId='" + firmBrandId + '\'' +
                ", identify='" + identify + '\'' +
                ", basePrice='" + basePrice + '\'' +
                ", pricePrefix='" + pricePrefix + '\'' +
                ", price='" + price + '\'' +
                ", priceSuffix='" + priceSuffix + '\'' +
                ", adInfo='" + adInfo + '\'' +
                ", ecLable='" + ecLable + '\'' +
                '}';
    }
}
