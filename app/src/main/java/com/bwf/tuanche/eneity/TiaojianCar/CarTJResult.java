package com.bwf.tuanche.eneity.TiaojianCar;

import java.util.List;

/**
 * Created by che on 2016/8/17
 * Description:.
 */
public class CarTJResult {

    public List<CarCountry> series;
    public List<CarLevle> levle;
    public List<CarRank> bos;

    @Override
    public String toString() {
        return "CarTJResult{" +
                "series=" + series +
                ", levle=" + levle +
                ", bos=" + bos +
                '}';
    }
}
