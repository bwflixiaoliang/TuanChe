package com.bwf.tuanche.eneity.CityList;

import com.bwf.framwork.base.BaseBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lixiaoliang on 2016/8/18.
 * Description:
 */
public class CityListBean extends BaseBean implements Serializable {
    public CityListResult result;

    @Override
    public String toString() {
        return "CityListBean{" +
                "result=" + result +
                '}';
    }

    public class CityListResult implements Serializable{
        public List<OpenCity> hotCitys;
        public List<OpenCity> openCitys;

        @Override
        public String toString() {
            return "CityListResult{" +
                    "hotCitys=" + hotCitys +
                    ", openCitys=" + openCitys +
                    '}';
        }

        public class OpenCity implements Serializable,Comparable<OpenCity>{
            public String id;// "id": 197,
            public String name;//        "name": "鞍山",
            public String province;//     "province": "辽宁",
            public String pinyin;//     "pinyin": "anshan",
            public String citycode;//     "citycode": null,
            public String pname;//     "pname": "东北区",
            public String py;//      "py": "as",
            public String openStatus;//     "openStatus": 0,
            public String manNum;//     "manNum": null
            @Override
            public String toString() {
                return "OpenCity{" +
                        "id='" + id + '\'' +
                        ", name='" + name + '\'' +
                        ", province='" + province + '\'' +
                        ", pinyin='" + pinyin + '\'' +
                        ", citycode='" + citycode + '\'' +
                        ", pname='" + pname + '\'' +
                        ", py='" + py + '\'' +
                        ", openStatus='" + openStatus + '\'' +
                        ", manNum='" + manNum + '\'' +
                        '}';
            }

            @Override
            public int compareTo(OpenCity openCity) {
                String newPinyin = this.pinyin.toUpperCase();
                String oldPinyin = openCity.pinyin.toUpperCase();
                return newPinyin.compareTo(oldPinyin);
            }
        }
    }
}
