package com.bwf.tuanche.Adatper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwf.framwork.utils.LogUtils;
import com.bwf.tuanche.R;
import com.bwf.tuanche.eneity.searchonly.SearchOnly;
import com.bwf.tuanche.eneity.searchonly.SearchResult;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengchao on 2016/8/22.
 * Description：
 */
public class PopwindowsamecarbrandAdapter extends BaseAdapter{
    private List<SearchOnly> searchonlylist;

    private Context context;

    public PopwindowsamecarbrandAdapter(Context context) {

        this.context = context;
    }
    public void setAdapterdata( List<SearchResult> searchResult){
        searchonlylist=new ArrayList<>();
        for (int i = 0; i <searchResult.size() ; i++) {
            for (SearchOnly s:searchResult.get(i).styleList) {
                searchonlylist.add(s);
            }
        }
    }

    @Override
    public int getCount() {
        return searchonlylist==null?0:searchonlylist.size();
    }

    @Override
    public Object getItem(int i) {
        return searchonlylist.get(i)==null?null:searchonlylist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View conview, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if(conview==null){
            viewHolder=new ViewHolder();
            conview=View.inflate(context, R.layout.item_samecarbrand,null);
            viewHolder.textView1= (TextView) conview.findViewById(R.id.carid);
            viewHolder.textView2= (TextView) conview.findViewById(R.id.carprice);
            viewHolder.simpleDraweeView= (SimpleDraweeView) conview.findViewById(R.id.samecarsim);
            conview.setTag(viewHolder);
        }
        viewHolder= (ViewHolder) conview.getTag();
        viewHolder.textView1.setText(searchonlylist.get(position).styleName);
        viewHolder.textView2.setText(searchonlylist.get(position).pricePrefix+searchonlylist.get(position).price+searchonlylist.get(position).priceSuffix);
        viewHolder.simpleDraweeView.setImageURI(searchonlylist.get(position).logo);
        return conview;
    }
    private class  ViewHolder{
        private TextView textView1,textView2;
        private SimpleDraweeView simpleDraweeView;
    }
}

