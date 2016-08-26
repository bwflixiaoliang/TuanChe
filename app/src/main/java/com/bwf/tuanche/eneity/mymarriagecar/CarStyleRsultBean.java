package com.bwf.tuanche.eneity.mymarriagecar;

import java.util.List;

/**
 * Created by che on 2016/8/24
 * Description:.
 */
public class CarStyleRsultBean {

    public String adpTitle;//          "adpTitle": "婚姻座驾",
    public String adpLogo;//           "adpLogo": "http://pic.tuanche.com/ams/20150919/14426718579625495.png",
    public String shareUrl;//        "shareUrl": "http://umapi.tuanche.com/wx/ad/popular?cityId=156&adpId=30&logo=http://pic.tuanche.com/ams/20150919/14426718579625495.png&title=婚姻座驾",
    public String sharePic;//        "sharePic": "http://pic.tuanche.com/ams/20150921/14428131954665581.png",
    public String shareCtx;//         "shareCtx": "空间、经济、实用，家庭成员多就怕一车坐不下",
    public String shareSlogan;//        "shareSlogan": "婚姻座驾,给她最好的",
    public String isShare;//         "isShare": 1,
    public String cardTotal;//         "cardTotal": 14,
    public String offset;//         "offset": 20,
    public String count;//        "count": 20,
    public List<CarStyleListBean> carstyleList;

    @Override
    public String toString() {
        return "CarStyleRsultBean{" +
                "adpTitle='" + adpTitle + '\'' +
                ", adpLogo='" + adpLogo + '\'' +
                ", shareUrl='" + shareUrl + '\'' +
                ", sharePic='" + sharePic + '\'' +
                ", shareCtx='" + shareCtx + '\'' +
                ", shareSlogan='" + shareSlogan + '\'' +
                ", isShare='" + isShare + '\'' +
                ", cardTotal='" + cardTotal + '\'' +
                ", offset='" + offset + '\'' +
                ", count='" + count + '\'' +
                ", carstyleList=" + carstyleList +
                '}';
    }
}
