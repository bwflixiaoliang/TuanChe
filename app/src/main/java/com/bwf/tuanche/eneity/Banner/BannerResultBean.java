package com.bwf.tuanche.eneity.Banner;

import com.bwf.framwork.base.BaseBean;

import java.util.List;

/**
 * Created by fengchao on 2016/8/18.
 * Description：
 */
public class BannerResultBean {
    public List<BannerBean> header_banner;
    public List<CenterBannerBean> center_banner;
    public List<PositionBanner> position_banner;

    @Override
    public String toString() {
        return "BannerResultBean{" +
                "header_banner=" + header_banner +
                ", center_banner=" + center_banner +
                ", position_banner=" + position_banner +
                '}';
    }
}
