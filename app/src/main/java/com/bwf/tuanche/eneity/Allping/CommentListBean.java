package com.bwf.tuanche.eneity.Allping;

import java.io.Serializable;

/**
 * Created by fengchao on 2016/8/24.
 * Description：
 */
public class CommentListBean implements Serializable{
    public String userName;//"userName": "高团员",

    @Override
    public String toString() {
        return "CommentListBean{" +
                "userName='" + userName + '\'' +
                ", commentDate='" + commentDate + '\'' +
                ", score='" + score + '\'' +
                ", memberPic='" + memberPic + '\'' +
                '}';
    }

    public String commentDate;//"commentDate": "2015-7-14",
    public String score;//"score": 5,
    public String content;// "content": "不错，还是可以。",
    public String memberPic;//"memberPic": "http://pic.tuanche.com/umapi/head/default/tuantuan04.png",
    //"commentPicList": [],
}
