package com.bwf.tuanche.eneity.detail;

import android.graphics.Paint;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fengchao on 2016/8/20.
 * Description：
 */
public class DetailResult {
    public String  commentTotal;//"commentTotal": 4.6,
    public String  regular4sShop;//"regular4sShop": "正规4S店",
    public String  isFree;//"isFree": "免费参团",
    public String  isLowest;//"isLowest": "低价保证",
    public String  isPriorityBy4S;//"isPriorityBy4S": "4S店优先提车",
    public String  isAllFree;//"isAllFree
    public Comment comment;
    public String  groupbuyDate;//"groupbuyDate": "2016.08.20",
    public String  groupbuyWeek;//"groupbuyWeek": "周六",
    public String  salerId;// "salerId": 1910,
    public String  id;//  "id": 166,
    public String  logo;//  "logo": "http://pic.tuanche.com/car/20160622/14665650461656418_o.jpg",
    public String  styleName;//  "styleName": "奥迪A4L",
    public String  factoryPrice;//  "factoryPrice": "28.99-39.39万",
    public String  content;//  "content": "(1.8T/2.0T)",
    public String  isBuy;//  "isBuy": 0,
    public String  manNum;//  "manNum": 104,
    public String  state;// "state": 1,
    public String  isCompensate;// "isCompensate": "买贵赔三倍",
    public String  addUp;// "addUp": "32.0",
    public String  brandLogo;//"brandLogo": "http://pic.tuanche.com/car/20160421/14612051324506050_s.jpg",
    public String  flowUrl;// "flowUrl": "http://umapi.tuanche.com/jsp/common/nogroup.jsp",
    public String  questionUrl;//  "questionUrl"
    public Buyway  buyWays;
    public String  manNumDesc;//  "manNumDesc": "本周104人报名",
    public String  brandName;// "brandName": "一汽奥迪",
    public String  brandPic;//"brandPic": "http://pic.tuanche.com/car/20160714/14684806400978938_m.jpg",
    public Ssgtz  ssgTz;// "ssgTz": {},
    public String  passNum;// "passNum": "549",
    public String  brandGroupStyleNum;//  "brandGroupStyleNum": 41981,
    public String  brandGroupStyleManNum;//  "brandGroupStyleManNum": 427,  "shareBrandTitle": "成都一汽奥迪团购会",
    public String  shareStyleTitle;// "shareStyleTitle": "成都奥迪A4L团购会",
    public String  shareDesc;// "shareDesc": "享超低团购价,最专业团购服务给您带来省钱、省心买车体验!",
    public String  shareBrandUrl;// "shareBrandUrl": "http://m.tuanche.com/cd/b31/tuan",
    public String  shareStyleUrl;//  "shareStyleUrl": "http://m.tuanche.com/cd/c166/tuan",
    public String tcbzDesc;// "tcbzDesc"
    public String  brandId;//  "brandId": 31,
    public String  styleId;//  "styleId": 166,
    public String  saveUpString;//  "saveUpString": "累计为团友额外",
    public String  saveUpMoney;//  "saveUpMoney": "节省32.0万",
    public String  special;//  "special": false

    @Override
    public String toString() {
        return "DetailResult{" +
                "commentTotal='" + commentTotal + '\'' +
                ", regular4sShop='" + regular4sShop + '\'' +
                ", isFree='" + isFree + '\'' +
                ", isLowest='" + isLowest + '\'' +
                ", isPriorityBy4S='" + isPriorityBy4S + '\'' +
                ", isAllFree='" + isAllFree + '\'' +
                ", comment=" + comment +
                ", groupbuyDate='" + groupbuyDate + '\'' +
                ", groupbuyWeek='" + groupbuyWeek + '\'' +
                ", salerId='" + salerId + '\'' +
                ", id='" + id + '\'' +
                ", logo='" + logo + '\'' +
                ", styleName='" + styleName + '\'' +
                ", factoryPrice='" + factoryPrice + '\'' +
                ", content='" + content + '\'' +
                ", isBuy='" + isBuy + '\'' +
                ", manNum='" + manNum + '\'' +
                ", state='" + state + '\'' +
                ", isCompensate='" + isCompensate + '\'' +
                ", addUp='" + addUp + '\'' +
                ", brandLogo='" + brandLogo + '\'' +
                ", flowUrl='" + flowUrl + '\'' +
                ", questionUrl='" + questionUrl + '\'' +
               ", buyWays=" + buyWays +
                ", manNumDesc='" + manNumDesc + '\'' +
                ", brandName='" + brandName + '\'' +
                ", brandPic='" + brandPic + '\'' +
                ", ssgTz=" + ssgTz +
                ", passNum='" + passNum + '\'' +
                ", brandGroupStyleNum='" + brandGroupStyleNum + '\'' +
                ", brandGroupStyleManNum='" + brandGroupStyleManNum + '\'' +
                ", shareStyleTitle='" + shareStyleTitle + '\'' +
                ", shareDesc='" + shareDesc + '\'' +
                ", shareBrandUrl='" + shareBrandUrl + '\'' +
                ", shareStyleUrl='" + shareStyleUrl + '\'' +
                ", tcbzDesc=" + tcbzDesc +
                ", brandId='" + brandId + '\'' +
                ", styleId='" + styleId + '\'' +
                ", saveUpString='" + saveUpString + '\'' +
                ", saveUpMoney='" + saveUpMoney + '\'' +
                ", special='" + special + '\'' +
                '}';
    }
}
