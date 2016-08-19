package com.bwf.framwork.share;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lizhangfeng on 2016/7/13 0013.
 * Description:
 */
public class SharePrefreceHelper extends PrefrenceWrapper {

    private static SharePrefreceHelper sharePrefreceHelper;

    private SharePrefreceHelper(Context context) {
        super(context);
    }

    public static SharePrefreceHelper getInstence(Context context) {
        if (sharePrefreceHelper == null)
            sharePrefreceHelper = new SharePrefreceHelper(context);
        return sharePrefreceHelper;
    }
    public void setLastCity(String cityName,String cityId){
            putString("cityName",cityName);
            putString("cityId",cityId);
    }
    public Map<String,String> getLastCity(){
        Map<String,String> map = new HashMap<String,String>();
        map.put("cityName",getString("cityName","北京"));
        map.put("ciytId",getString("cityId","10"));
        return map;
    }
    public boolean isFirst(){
        return getBoolean("isFirst",true);
    }
    public void setFirst(){
        setBoolean("isFirst",false);
    }
}
