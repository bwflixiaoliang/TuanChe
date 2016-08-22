package com.bwf.tuanche.sql;

import android.content.ContentValues;
import android.database.Cursor;
import com.bwf.framwork.base.BaseModel;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.framwork.utils.ToastUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fengchao on 2016/8/19.
 * Description：
 */
public class History extends BaseModel{
    private HistoryBean historyBean;

    private static final String TABLENAME="history";

    private static final Map<String,String> params=new HashMap<>();

    static {
        params.put(_ID,"integer primary key autoincrement");
        params.put("name","TEXT NOT　NULL");
        params.put("time","TEXT NOT NULL");
    }

    public void insertnew(HistoryBean historyBean){
        if(historyBean==null)
            return;
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",historyBean.name);
        contentValues.put("time",historyBean.time);
        insert(TABLENAME,contentValues);
        LogUtils.e("添加数据"+contentValues.toString());
    }

    /**
     * 删除数据库数据
     * @param historyBean
     */
    public void Delete(HistoryBean historyBean){
        String[] arg={String.valueOf(historyBean.time)};
        delete(TABLENAME,"time=?",arg);
    }

    public List<HistoryBean> Querey(){
        int count=0;
        List<HistoryBean> historyBeanList=new ArrayList<>();
        String sql="select * from "+TABLENAME;
        Cursor cursor=select(sql);
        if (cursor != null) {
            if (cursor.moveToNext()) {
                ToastUtil.showToast("------------");
                historyBean=new HistoryBean();
                historyBean.name = cursor.getString(cursor.getColumnIndex("name"));
                historyBean.time = cursor.getLong(cursor.getColumnIndex("time"));
                historyBeanList.add(historyBean);
            }
        }

        return historyBeanList;

    }


    @Override
    protected String getTableName() {
        return TABLENAME;
    }

    @Override
    protected Map<String, String> getParamsMap() {
        return params;
    }
}
