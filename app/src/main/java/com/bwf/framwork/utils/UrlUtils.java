package com.bwf.framwork.utils;

/**
 * Created by Lizhangfeng on 2016/7/19 0019.
 * Description:
 */
public class UrlUtils {
    //团车基本网址
    public static final String BASE_URL = "http://123.56.145.151:8080/TuanCheNetWork";
    //首页
    public static final String HOMEPAGE_URL =BASE_URL+"/bwf_TuanChe_HomeServlet";//cityId=156
    //当前城市
    public static final String NOWCITY_URL=BASE_URL+"/bwf_TuanChe_QueryCityByLatitude";//longitude=104.147981&latitude=30.606906
    //热门车型
    public static final String HOTCARTYPE_URL =BASE_URL+"/bwf_TuanChe_Hotstyle";//?count=2&offset=0&cityId=156
    //城市Moduel
    public static final String CITYMODUEL_URL =BASE_URL+"/bwf_TuanChe_CityMode";//cityId=156
    //热门品牌
    public static final String HOTLOGO_URL = BASE_URL+"/bwf_TuanChe_TopBrand";//?isBuy=2&cityId=156
    //首页bananer部分
    public static final String HOMEPAGEBANNER_URL =BASE_URL+"/bwf_TuanChe_BannerServlet";//?cityId=156
    //选择城市列表
    public static final String CITYLIST_URL = BASE_URL+"/bwf_TuanChe_Getcitys";//?pageSize=4
    //8、选车—热门 接口在修复中；
    //选车列表
    public static final String SELECTCAR_URL =BASE_URL+"/bwf_TuanChe_SelectTopBrand";//?cityId=156
    //选车 国产 进口，排量
    public static final String SELECTCARBYPARAMS_URL =BASE_URL+"/bwf_TuanChe_SelectCarInfosServlet";//
    //根据车品牌获取车列表
    public static final  String SELECTCARLISTBYBRAND_URL = BASE_URL+"/bwf_TuanChe_BrandCarStyleServlet";//?type=0&cityId=156&brandId=25
    //汽车详情
    public static final  String CARDETAILS_URL =BASE_URL+"/bwf_TuanChe_BuyInfoServlet";//?styleId=166&brandId=31&cityId=156
    //购车流程 用webview 直接加载
    public static final String BUYCAR_URL = BASE_URL+"/bwf_TuanChe_BuyInfoNogroupServlet";
    //汽车详情，常见问题用webview 直接加载
    public static final  String BUYCARQUESTION_URL = BASE_URL+"/bwf_TuanChe_BuyInfoQuestionServlet";
    //汽车详情，全部评价
    public static final String JUDGE_URL = BASE_URL+"/bwf_TuanChe_BuyInfoEvaluateServlet";//count=10&offset=1&cityId=156&brandId=31
    //汽车 热门搜索
    public static final String HOTSEARCH_URL = BASE_URL+"/bwf_TuanChe_SearchhotServlet";//?cityId=156
    //版本更新
    public static  final String VERSIONUPDATE_URL = BASE_URL+"/bwf_TuanChe_VersionUpadteServlet";
}
