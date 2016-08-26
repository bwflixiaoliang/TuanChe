package com.bwf.tuanche.Adatper;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwf.tuanche.R;
import com.bwf.tuanche.eneity.hotcartype.HotCarResultBean;
import com.bwf.tuanche.eneity.hotlogo.HotLogo;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by fengchao on 2016/8/17.
 * Description：
 */
public class farg4_gridviewAdapter extends BaseAdapter{
    private List<HotCarResultBean> result;

    private Context context;

    public farg4_gridviewAdapter(List<HotCarResultBean> result, Context context) {
        this.result = result;
        this.context=context;
    }

    @Override
    public int getCount() {
        return result==null?0:result.size();
    }

    @Override
    public Object getItem(int i) {
        return result.get(i)==null?null:result.get(i);
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
            conview=View.inflate(context, R.layout.frag4_item,null);
            viewHolder.textView1= (TextView) conview.findViewById(R.id.frag4_t1);
            viewHolder.textView2= (TextView) conview.findViewById(R.id.frag4_t2);
            viewHolder.textView3= (TextView) conview.findViewById(R.id.frag4_t3);
            viewHolder.simpleDraweeView= (SimpleDraweeView) conview.findViewById(R.id.frag4_f1);
            conview.setTag(viewHolder);
        }
        viewHolder= (ViewHolder) conview.getTag();
        viewHolder.textView1.setText(result.get(position).styleName);
        String redfont="已有"+"<font color ='#FF0000'>"+result.get(position).manNum+"</font>"+"人报名";
        viewHolder.textView2.setText(Html.fromHtml(redfont));
        viewHolder.textView3.setText(result.get(position).pricePrefix+result.get(position).price+"万");
        viewHolder.simpleDraweeView.setImageURI(result.get(position).logo);
        return conview;
    }
    private class  ViewHolder{
        private TextView textView1;
        private TextView textView2;
        private TextView textView3;
        private SimpleDraweeView simpleDraweeView;

}
}
