package com.android.developer.dado;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Belal on 2/3/2016.
 */
//Extending FragmentStatePagerAdapter
public class Pager extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;

    //Constructor to the class
    public Pager(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                D4 d4 = new D4();
                return d4;
            case 1:
                D6 d6 = new D6();
                return d6;
            case 2:
                D8 d8 = new D8();
                return d8;
            case 3:
                D4 d10 = new D4();
                return d10;
            case 4:
                D4 d12 = new D4();
                return d12;
            case 5:
                D4 d20 = new D4();
                return d20;
            case 6:
                D4 d100 = new D4();
                return d100;
            default:
                return null;
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }
}