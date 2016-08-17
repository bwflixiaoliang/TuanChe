package com.bwf.tuanche.eneity.TuanChe;

import java.util.List;

/**
 * Created by fengchao on 2016/8/16.
 * Description：
 */
public class TuanCheResultBean {
//    private List<Oc> oc ;为空，暂时不知作用

    public List<Nc> nc ;

//    private List<Tc> tc ;为空，暂时不知作用

//    public void setOc(List<Oc> oc){
//        this.oc = oc;
//    }
//    public List<Oc> getOc(){
//        return this.oc;
//    }
//    public void setNc(List<Nc> nc){
//        this.nc = nc;
//    }
//    public List<Nc> getNc(){
//        return this.nc;
//    }

    @Override
    public String toString() {
        return "TuanCheResultBean{" +
                "nc=" + nc +
                '}';
    }
//    public void setTc(List<Tc> tc){
//        this.tc = tc;
//    }
//    public List<Tc> getTc(){
//        return this.tc;
//    }
}
