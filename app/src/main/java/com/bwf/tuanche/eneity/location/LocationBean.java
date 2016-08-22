package com.bwf.tuanche.eneity.location;

import com.bwf.framwork.base.BaseBean;

import java.io.Serializable;

/**
 * Created by lixiaoliang on 2016/8/17.
 * Description:
 */
public class LocationBean extends BaseBean implements Serializable {
    public LocationCity result;
    @Override
    public String toString() {
        return "LocationBean{" +
                "result=" + result +
                '}';
    }

    public class LocationCity implements Serializable{
        public String  id;// "id": 156,
        public String  name;//    "name": "成都",
        public String  pinyin;//      "pinyin": "chengdu",
        public String  py;//     "py": "cd",
        public String  openStatus;//     "openStatus": 1

        @Override
        public String toString() {
            return "LocationCity{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", pinyin='" + pinyin + '\'' +
                    ", py='" + py + '\'' +
                    ", openStatus='" + openStatus + '\'' +
                    '}';
        }
    }
}
