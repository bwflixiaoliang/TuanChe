package com.bwf.tuanche.eneity.Allping;

import java.util.List;

/**
 * Created by fengchao on 2016/8/24.
 * Description：
 */
public class ComResultBean {
    public String count;//  "count": 32,
    public String commentTotal;//"commentTotal": 4.6,
    public String priceScore;//"priceScore": 4.0,

    @Override
    public String toString() {
        return "ComResultBean{" +
                "count='" + count + '\'' +
                ", commentTotal='" + commentTotal + '\'' +
                ", priceScore='" + priceScore + '\'' +
                ", salerScore='" + salerScore + '\'' +
                ", shopScore='" + shopScore + '\'' +
                ", offset='" + offset + '\'' +
                ", commentList=" + commentList +
                '}';
    }

    public String salerScore;// "salerScore": 4.7,
    public String shopScore;//  "shopScore": 4.3,
    public String offset;// "offset": 2,
    public List<CommentListBean> commentList;// "commentList": [{
//            "userName": "高团员", "commentDate": "2015-7-14", "score": 5, "content": "不错，还是可以。", "memberPic": "http://pic.tuanche.com/umapi/head/default/tuantuan04.png", "commentPicList": [],
}
