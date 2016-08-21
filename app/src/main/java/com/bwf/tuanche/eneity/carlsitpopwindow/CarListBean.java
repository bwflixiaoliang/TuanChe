package com.bwf.tuanche.eneity.carlsitpopwindow;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by che on 2016/8/20
 * Description:.
 */
public class CarListBean implements Parcelable {

    public String id; // "id": 288,
    public String brandId; //        "brandId": 31,
    public String logo; //       "logo": "http://pic.tuanche.com/car/20160622/14665654756472770_s.jpg",
    public String styleName; //       "styleName": "奥迪A3",
    public String factoryPrice; //        "factoryPrice": "18.49-28.1万",
    public String content; //        "content": "已有23人报名",
    public String isBuy; //         "isBuy": 0,
    public String manNum; //         "manNum": 23,
    public String isNew; //        "isNew": 0,
    public String prefix; //          "prefix": "已有",
    public String suffix; //        "suffix": "人报名",
    public String levelStr; //       "levelStr": "1.4T 1.8T",
    public String brandName; //        "brandName": "一汽奥迪",
    public String carModelPrices; //        "carModelPrices": "22323,18.49;22324,20.92;22325,22.59;22326,19.09;22327,21.52;22328,23.19;22329,24.99;22330,27.70;22331,25.39;22332,28.10;23572,23.88;23573,24.28;",
    public String firmBrandId; //       "firmBrandId": 25,
    public String identify; //        "identify": 1,
    public String basePrice; //         "basePrice": "18.49",
    public String pricePrefix; //       "pricePrefix": "指导价：",
    public String price; //        "price": "18.49-28.1",
    public String priceSuffix; //         "priceSuffix": "万",
    public String adInfo; //       "adInfo": "",
    public String ecLable; //       "ecLable": ""

    @Override
    public String toString() {
        return "CarListBean{" +
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.brandId);
        dest.writeString(this.logo);
        dest.writeString(this.styleName);
        dest.writeString(this.factoryPrice);
        dest.writeString(this.content);
        dest.writeString(this.isBuy);
        dest.writeString(this.manNum);
        dest.writeString(this.isNew);
        dest.writeString(this.prefix);
        dest.writeString(this.suffix);
        dest.writeString(this.levelStr);
        dest.writeString(this.brandName);
        dest.writeString(this.carModelPrices);
        dest.writeString(this.firmBrandId);
        dest.writeString(this.identify);
        dest.writeString(this.basePrice);
        dest.writeString(this.pricePrefix);
        dest.writeString(this.price);
        dest.writeString(this.priceSuffix);
        dest.writeString(this.adInfo);
        dest.writeString(this.ecLable);
    }

    public CarListBean() {
    }

    protected CarListBean(Parcel in) {
        this.id = in.readString();
        this.brandId = in.readString();
        this.logo = in.readString();
        this.styleName = in.readString();
        this.factoryPrice = in.readString();
        this.content = in.readString();
        this.isBuy = in.readString();
        this.manNum = in.readString();
        this.isNew = in.readString();
        this.prefix = in.readString();
        this.suffix = in.readString();
        this.levelStr = in.readString();
        this.brandName = in.readString();
        this.carModelPrices = in.readString();
        this.firmBrandId = in.readString();
        this.identify = in.readString();
        this.basePrice = in.readString();
        this.pricePrefix = in.readString();
        this.price = in.readString();
        this.priceSuffix = in.readString();
        this.adInfo = in.readString();
        this.ecLable = in.readString();
    }

    public static final Parcelable.Creator<CarListBean> CREATOR = new Parcelable.Creator<CarListBean>() {
        @Override
        public CarListBean createFromParcel(Parcel source) {
            return new CarListBean(source);
        }

        @Override
        public CarListBean[] newArray(int size) {
            return new CarListBean[size];
        }
    };
}
