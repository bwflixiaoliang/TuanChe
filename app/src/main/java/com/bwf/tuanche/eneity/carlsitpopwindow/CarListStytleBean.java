package com.bwf.tuanche.eneity.carlsitpopwindow;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by che on 2016/8/20
 * Description:.
 */
public class CarListStytleBean implements Parcelable {
    public String brandId;//          "brandId": 31,
    public String brandName;//          "brandName": "一汽奥迪",
    public String brandPic;//        "brandPic": "http://pic.tuanche.com/car/20160421/14612051324506050_s.jpg",
    public List<CarListBean> styleList;

    @Override
    public String toString() {
        return "CarListStytleBean{" +
                "brandId='" + brandId + '\'' +
                ", brandName='" + brandName + '\'' +
                ", brandPic='" + brandPic + '\'' +
                ", styleList=" + styleList +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.brandId);
        dest.writeString(this.brandName);
        dest.writeString(this.brandPic);
        dest.writeTypedList(this.styleList);
    }

    public CarListStytleBean() {
    }

    protected CarListStytleBean(Parcel in) {
        this.brandId = in.readString();
        this.brandName = in.readString();
        this.brandPic = in.readString();
        this.styleList = in.createTypedArrayList(CarListBean.CREATOR);
    }

    public static final Parcelable.Creator<CarListStytleBean> CREATOR = new Parcelable.Creator<CarListStytleBean>() {
        @Override
        public CarListStytleBean createFromParcel(Parcel source) {
            return new CarListStytleBean(source);
        }

        @Override
        public CarListStytleBean[] newArray(int size) {
            return new CarListStytleBean[size];
        }
    };
}
