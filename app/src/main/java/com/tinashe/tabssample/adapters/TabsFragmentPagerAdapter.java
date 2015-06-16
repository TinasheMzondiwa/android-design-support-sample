package com.tinashe.tabssample.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tinashe.tabssample.fragments.PlaceHolderFragment;

/**
 * Created by tinashe on 2015/06/16.
 */
public class TabsFragmentPagerAdapter extends FragmentPagerAdapter {

    public TabsFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return PlaceHolderFragment.newInstance("Position [" + position + "]");
    }

    @Override
    public int getCount() {
        return 8;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Item " + (position + 1);
    }
}
