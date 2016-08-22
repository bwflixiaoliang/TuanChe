package com.bwf.tuanche.eneity.detail;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fengchao on 2016/8/20.
 * Description：
 */
public class CommentList implements Serializable{
    @Override
    public String toString() {
        return "CommentList{" +
                "userName='" + userName + '\'' +
                ", commentDate='" + commentDate + '\'' +
                ", score='" + score + '\'' +
                ", content='" + content + '\'' +
                ", memberPic='" + memberPic + '\'' +
                ", commentPicList=" + commentPicList +
                ", fine='" + fine + '\'' +
                '}';
    }

    public String userName;//"userName": "高团员",
    public String commentDate;//"commentDate": "2015-7-14",
    public String score;//  "score": 5,
    public String content;// "content": "不错，还是可以。",
    public String memberPic;//   "memberPic": "http://pic.tuanche.com/umapi/head/default/tuantuan04.png",
    public List<Com> commentPicList;//  "commentPicList": [],
    public String fine;//   "fine": fal
}
