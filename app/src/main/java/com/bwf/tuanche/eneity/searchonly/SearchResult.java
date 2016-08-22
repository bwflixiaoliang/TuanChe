package com.bwf.tuanche.eneity.searchonly;

import com.bwf.framwork.base.BaseBean;
import com.bwf.framwork.base.BaseBean1;

import java.util.List;

/**
 * Created by fengchao on 2016/8/19.
 * Description：
 */
public class SearchResult {
    public String brandId;

    public String brandName;

    public String brandPic;

    public List<SearchOnly> styleList ;

    @Override
    public String toString() {
        return "SearchResult{" +
                "brandId='" + brandId + '\'' +
                ", brandName='" + brandName + '\'' +
                ", brandPic='" + brandPic + '\'' +
                ", styleList=" + styleList +
                '}';
    }
}
