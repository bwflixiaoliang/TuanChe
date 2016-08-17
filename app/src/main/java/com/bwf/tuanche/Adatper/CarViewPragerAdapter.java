package com.bwf.tuanche.Adatper;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by che on 2016/8/17
 * Description:.
 */
public class CarViewPragerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;

    public CarViewPragerAdapter(FragmentManager fm) {
        super(fm);
    }
    public CarViewPragerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments == null ? null : fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments == null ? 0 : fragments.size();
    }
}
