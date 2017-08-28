package com.aeiton.androidworkshop;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by User on 06-Feb-17.
 */

public class CalculatorFragmentAdapter  extends FragmentPagerAdapter {

    public CalculatorFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        switch (position){
            case 0:
                return SimpleCalculator.getInstance();
            case 1:
                return DoubleCalculator.getInstance();
        }

        return null;
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "COUNTER";
            case 1:
                return "CALCULATOR";
        }
        return null;
    }
}