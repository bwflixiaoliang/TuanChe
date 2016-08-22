package com.bwf.tuanche.Adatper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bwf.tuanche.R;
import com.bwf.tuanche.eneity.detail.CommentList;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;

/**
 * Created by fengchao on 2016/8/22.
 * Description：
 */
public class DetailFrag4_ListViewAdapter extends BaseAdapter{
    private List<CommentList> commentList;

    private Context context;

    public DetailFrag4_ListViewAdapter(Context context) {

        this.context = context;
    }
    public void setAdapterdata( List<CommentList> commentList){
        this.commentList=commentList;
    }

    @Override
    public int getCount() {
        return commentList==null?0:commentList.size();
    }

    @Override
    public Object getItem(int i) {
        return commentList.get(i)==null?null:commentList.get(i);
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
            conview=View.inflate(context, R.layout.item_detailfrag4,null);
            viewHolder.textView1= (TextView) conview.findViewById(R.id.deatil_frag4_item_tv1);
            viewHolder.textView2= (TextView) conview.findViewById(R.id.deatil_frag4_item_tv2);
            viewHolder.textView3= (TextView) conview.findViewById(R.id.deatil_frag4_item_tvping);
            viewHolder.ratingBar= (RatingBar) conview.findViewById(R.id.deatil_frag4_item_rating);
            viewHolder.simpleDraweeView= (SimpleDraweeView) conview.findViewById(R.id.deatil_frag4_item_sim);
            conview.setTag(viewHolder);
        }
        viewHolder= (ViewHolder) conview.getTag();
        viewHolder.textView1.setText(commentList.get(position).userName);
        viewHolder.textView2.setText(commentList.get(position).commentDate);
        viewHolder.textView3.setText(commentList.get(position).content);
        viewHolder.simpleDraweeView.setImageURI(commentList.get(position).memberPic);
        viewHolder.ratingBar.setRating(Float.parseFloat(commentList.get(position).score));
        return conview;
    }
    private class  ViewHolder{
        private TextView textView1,textView2,textView3;
        private RatingBar ratingBar;
        private SimpleDraweeView simpleDraweeView;

    }
}

