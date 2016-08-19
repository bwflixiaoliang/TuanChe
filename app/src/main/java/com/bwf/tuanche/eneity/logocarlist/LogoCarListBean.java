package com.bwf.tuanche.eneity.logocarlist;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by che on 2016/8/19
 * Description:.
 */
public class LogoCarListBean implements Parcelable {

    public String id;// "id": 25,
    public String pinyin;//         "pinyin": "aodi",
    public String name;//         "name": "奥 迪",
    public String logo;//        "logo": "http://pic.tuanche.com/car/20150420/14295244097434751_s.jpg",
    public String baseNum;//       "baseNum": 0,
    public String penname;//       "penname": "A"

    @Override
    public String toString() {
        return "LogoCarListBean{" +
                "id='" + id + '\'' +
                ", pinyin='" + pinyin + '\'' +
                ", name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                ", baseNum='" + baseNum + '\'' +
                ", penname='" + penname + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.pinyin);
        dest.writeString(this.name);
        dest.writeString(this.logo);
        dest.writeString(this.baseNum);
        dest.writeString(this.penname);
    }

    public LogoCarListBean() {
    }

    protected LogoCarListBean(Parcel in) {
        this.id = in.readString();
        this.pinyin = in.readString();
        this.name = in.readString();
        this.logo = in.readString();
        this.baseNum = in.readString();
        this.penname = in.readString();
    }

    public static final Parcelable.Creator<LogoCarListBean> CREATOR = new Parcelable.Creator<LogoCarListBean>() {
        @Override
        public LogoCarListBean createFromParcel(Parcel source) {
            return new LogoCarListBean(source);
        }

        @Override
        public LogoCarListBean[] newArray(int size) {
            return new LogoCarListBean[size];
        }
    };
}
