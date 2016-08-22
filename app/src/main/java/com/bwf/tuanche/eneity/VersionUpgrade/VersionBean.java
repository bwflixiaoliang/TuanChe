package com.bwf.tuanche.eneity.VersionUpgrade;

import com.bwf.framwork.base.BaseBean;

import java.io.Serializable;

/**
 * Created by lixiaoliang on 2016/8/22.
 * Description:
 */
public class VersionBean extends BaseBean {
    public VersionResult result;
    public class VersionResult implements Serializable{
        public String versionCode;//      "versionCode": 20160729,
        public String versionName;//    "versionName": "2.4.3",
        public String url;//     "url": "http://download.tuanche.com/app/android/tuancheapp.apk",
        public String md5file;//     "md5file": "faedcabaad6c68d6597e93404915172b",
        public String description;//      "description": "1、优化首页，优质好车抢先看 \n\n2、优化搜索，更精准、更快捷 \n\n3、优化详情页，报名更方便 \n\n4、优化订单，提升用户的体验",
        public String upgradeIntervalWarn;//     "upgradeIntervalWarn": 100,
        public String isFourceUpGrade;//      "isFourceUpGrade": false,
        public String isPromtUpGrade;//     "isPromtUpGrade": true,
        public String titleText;//      "titleText": "发现新版本",
        public String giveUpText;//      "giveUpText": "以后再说",
        public String upgradeText;//      "upgradeText": "立即更新",
        public String textPic;//      "textPic": "http://pic.tuanche.com/icon/base/common/version.png",
        public String isForce;//       "isForce": null,
        public String specificEdition;//      "specificEdition": null,
        public String minVersion;//       "minVersion": null
        @Override
        public String toString() {
            return "VersionResult{" +
                    "versionCode='" + versionCode + '\'' +
                    ", versionName='" + versionName + '\'' +
                    ", url='" + url + '\'' +
                    ", md5file='" + md5file + '\'' +
                    ", description='" + description + '\'' +
                    ", upgradeIntervalWarn='" + upgradeIntervalWarn + '\'' +
                    ", isFourceUpGrade='" + isFourceUpGrade + '\'' +
                    ", isPromtUpGrade='" + isPromtUpGrade + '\'' +
                    ", titleText='" + titleText + '\'' +
                    ", giveUpText='" + giveUpText + '\'' +
                    ", upgradeText='" + upgradeText + '\'' +
                    ", textPic='" + textPic + '\'' +
                    ", isForce='" + isForce + '\'' +
                    ", specificEdition='" + specificEdition + '\'' +
                    ", minVersion='" + minVersion + '\'' +
                    '}';
        }
    }
}
