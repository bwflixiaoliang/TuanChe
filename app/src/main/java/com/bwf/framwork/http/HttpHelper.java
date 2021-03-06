package com.bwf.framwork.http;


import com.bwf.framwork.utils.UrlUtils;

import android.app.Activity;

import com.bwf.framwork.utils.LogUtils;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.OkHttpClient;


/**
 * Created by Lizhangfeng on 2016/7/13 0013.
 * Description:
 */
public class HttpHelper {

    public static void getDetail(String url, String pageNo, String pageSize, HttpCallBack callBack) {
        OkHttpUtils
                .post()
                .url(url)
                .addParams("pageNo", pageNo)
                .addParams("pageSize", pageSize)
                .build()
                .execute(callBack);
    }

    //首页数据请求方法
    public static void getDataAtCity(String cityId, HttpCallBack callBack) {
        OkHttpUtils
                .post()
                .url(UrlUtils.HOMEPAGE_URL)
                .addParams("cityId", cityId)
                .build()
                .execute(callBack);
    }

    //当前城市数据请求方法
    public static void getDataNowCity(String longitude, String latitude, HttpCallBack callBack, Activity activity) {
        OkHttpUtils.post().url(UrlUtils.NOWCITY_URL)
                .addParams("longitude", longitude)
                .addParams("latitude", latitude)
                .tag(activity)
                .build()
                .execute(callBack);
    }

    //热门车型数据请求方法?count=2&offset=0&cityId=156
    public static void getDataHotCarType(String count, String offset, String cityId, HttpCallBackArray callBack) {
        OkHttpUtils.post().url(UrlUtils.HOTCARTYPE_URL)
                .addParams("cityId", cityId)
                .addParams("count", count)
                .addParams("offset", offset)
                .build()
                .execute(callBack);
    }

    //城市module数据请求方式cityId=156
    public static void getDataCityModule(String cityId, HttpCallBack callBack) {
        OkHttpUtils.post().url(UrlUtils.CITYMODUEL_URL)
                .addParams("cityId", cityId)
                .build()
                .execute(callBack);
    }

    //热门品牌数据请求方法 ?isBuy=2&cityId=156
    public static void getDataHotLogo(String isBuy, String cityId, HttpCallBack callBack) {
        LogUtils.e("url--->" + UrlUtils.HOTLOGO_URL);
        LogUtils.e("url参数-->cityId=" + cityId + ",isBuy=" + isBuy + "");
        OkHttpUtils.post().
                url(UrlUtils.HOTLOGO_URL)
                .addParams("cityId", cityId)
                .addParams("isBuy", isBuy)
                .build()
                .execute(callBack);
    }

    //首页Banner部分数据请求方法 ?cityId=156
    public static void getDataHomePageBanner(String cityId, HttpCallBack callBack) {
        OkHttpUtils.post().url(UrlUtils.HOMEPAGEBANNER_URL)
                .addParams("cityId", cityId)
                .build()
                .execute(callBack);
    }

    //选择城市列表数据请求方法?pageSize=4
    public static void getDataCityList(String pageSize, HttpCallBack callBack) {
        OkHttpUtils.post().url(UrlUtils.CITYLIST_URL)
                .addParams("pageSize", pageSize)
                .build()
                .execute(callBack);
    }

    //选车列表数据请求方法？cityId =156
    public static void getDataSelectCarList(String cityId, HttpCallBack callBack) {
        OkHttpUtils.post().url(UrlUtils.SELECTCAR_URL)
                .addParams("cityId", cityId)
                .build()
                .execute(callBack);
    }

    ////选车 根据国产 进口，排量
    public static void getDataSelectCarByParams(HttpCallBack callBack) {
        OkHttpUtils.post().url(UrlUtils.SELECTCARBYPARAMS_URL)
                .build()
                .execute(callBack);
    }

    //根据车品牌获取车列表type=0&cityId=156&brandId=25
    public static void getDataCarByBrand(String type, String cityId, String brandId, HttpCallBack callBack) {
        OkHttpUtils.post().url(UrlUtils.SELECTCARLISTBYBRAND_URL)
                .addParams("type", type)
                .addParams("cityId", cityId)
                .addParams("brandId", brandId)
                .build()
                .execute(callBack);
    }

    //汽车详情styleId=166&brandId=31&cityId=156
    public static void getDataCarDetail(String styleId, String brandId, String cityId, HttpCallBack callBack) {
        OkHttpUtils.post().url(UrlUtils.CARDETAILS_URL)
                .addParams("styleId", styleId)
                .addParams("brandId", brandId)
                .addParams("cityId", cityId)
                .build()
                .execute(callBack);
    }

    //版本更新数据请求
    public static void getDataVersionUpgrade(HttpCallBack callBack) {
        OkHttpUtils.post().url(UrlUtils.VERSIONUPDATE_URL).build().execute(callBack);
    }

    //汽车列表cityId=156
    public static void getDataCarList(String cityId, HttpCallBack callBack) {
        OkHttpUtils.post()
                .url(UrlUtils.CARLIST_URL)
                .addParams("cityId", cityId)
                .build()
                .execute(callBack);
    }

    public static void getDataHotCarDetail(String brandId, String cityId, HttpCallBack callBack) {
        OkHttpUtils.post().url(UrlUtils.CARDETAILS_URL)
                .addParams("firmbrandId", brandId)
                .addParams("cityId", cityId)
                .build()
                .execute(callBack);
    }

    public static void getHotSearch(String cityId, StringCallback callback) {
        OkHttpUtils.post().url(UrlUtils.HOTSEARCH_URL)
                .addParams("cityId", cityId)
                .build()
                .execute(callback);
    }

    //婚姻座驾的请求数据接口（不传数据）
    public static void getMarriageData(HttpCallBack callBack) {
        OkHttpUtils.post()
                .url(UrlUtils.MARRIAGECAR_URL)
                .build()
                .execute(callBack);
    }
    //全部评价请求，count=10,offset=1,cityid城市id,brandid品牌id
    public static void getDataAllPinglun(String count,String offset,String cityId ,String brandid,HttpCallBack callBack){
        OkHttpUtils.post().url(UrlUtils.JUDGE_URL)
                .addParams("cityId",cityId)
                .addParams("count",count)
                .addParams("offset",offset)
                .addParams("brandId",brandid)
                .build()
                .execute(callBack);
    }
}
