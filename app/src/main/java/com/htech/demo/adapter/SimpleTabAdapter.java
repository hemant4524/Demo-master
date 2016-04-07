package com.htech.demo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.htech.demo.fragment.BlankFragment;
import com.htech.demo.fragment.FourFragment;
import com.htech.demo.fragment.OneFragment;
import com.htech.demo.fragment.ThreeFragment;
import com.htech.demo.fragment.TwoFragment;


/**
 * Created by Chatikyan on 19.01.2016.
 */
public class SimpleTabAdapter extends FragmentPagerAdapter {

    private int page = 4;
    private String[] tabtitle = new String[]{"Customers", "Collection", "Registration", "Sync"};

    public SimpleTabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return OneFragment.newInstance("One", "Two");
        } else if (position == 1) {
            return TwoFragment.newInstance("One", "Two");
        } else if (position == 2) {
            return FourFragment.newInstance("One", "Two");
        } else if (position == 3) {
            return ThreeFragment.newInstance("One", "Two");
        }
        return new BlankFragment();
    }

    @Override
    public int getCount() {
        return page;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitle[position];
    }
}

