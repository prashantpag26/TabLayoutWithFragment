package com.indianic.tablayoutwithfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by indianic on 23/11/16.
 */

public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                // Top Rated fragment activity
                return new Onefragment();
            case 1:
                // Games fragment activity
                return new SecondFragment();
            case 2:
                // Movies fragment activity
                return new ThirdFragment();
        }

        return null;
    }

    @Override
    public int getItemPosition(Object object) {
        if (object instanceof Onefragment) {
            return 0;
        } else {
            return POSITION_NONE;
        }
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }

}
