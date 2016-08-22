package com.bwf.tuanche.eneity.detail;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fengchao on 2016/8/20.
 * Description：
 */
public class Comment implements Serializable{
     public String count;//"count": 32,

    @Override
    public String toString() {
        return "Comment{" +
                "count='" + count + '\'' +
                ", commentTotal='" + commentTotal + '\'' +
                ", commentList=" + commentList +
                '}';
    }

    public String commentTotal;//  "commentTotal": 4.6,
    public List<CommentList> commentList;//  "commentList"
}
