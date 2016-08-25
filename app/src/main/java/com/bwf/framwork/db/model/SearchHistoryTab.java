package com.bwf.framwork.db.model;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

import com.bwf.framwork.base.BaseModel;
import com.bwf.framwork.db.DBHelper;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.tuanche.sql.HistoryBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lixiaoliang on 2016/8/24.
 * Description:
 */
public class SearchHistoryTab extends BaseModel {
    public final static String TABLENAME = "search_History";
    private  static Map<String,String> params = new HashMap<>();
    public final static String column2 = "content";
    public final static String column3 = "time";
    public static  SQLiteDatabase write =  DBHelper.getInstence().getWritableDatabase();
    @Override
    public String getTableName() {
        return TABLENAME;
    }

    @Override
    public Map<String, String> getParamsMap() {
        params.put(_ID,"integer  primary key autoincrement");
        params.put(column2,"text");
        params.put(column3,"text");
        return params;
    }
    public static void insert(HistoryBean historyBean){
        ContentValues values = new ContentValues();
        values.put(column2,historyBean.name);
        values.put(column3,historyBean.time+"");
        write.insert(TABLENAME,null,values);
    }
    public static void delete(HistoryBean historyBean){
        write.delete(TABLENAME,column3+"=?",new String[]{historyBean.time+""});
    }
    public static void  clear(){
        write.execSQL("delete from "+TABLENAME);
    }
    public static List<HistoryBean> queryAll(){
        Cursor cursor = DBHelper.getInstence().getReadableDatabase().rawQuery("select * from "+TABLENAME,null);
        if(cursor==null)return null;
        List<HistoryBean> historyBeanList = new ArrayList<>();
        while (cursor.moveToNext()){
            String content = cursor.getString(cursor.getColumnIndex(column2));
            String time = cursor.getString(cursor.getColumnIndex(column3));
            historyBeanList.add(new HistoryBean(content,Long.parseLong(time.trim())));
        }
        return historyBeanList;
    }
    public static void addAll(List<HistoryBean> historyBeen){
        clear();
        if(historyBeen==null&&historyBeen.isEmpty())return;
        for (int i = 0; i < historyBeen.size(); i++) {
            LogUtils.i("msg",historyBeen.get(i).toString());
            insert(historyBeen.get(i));
        }
    }
}
