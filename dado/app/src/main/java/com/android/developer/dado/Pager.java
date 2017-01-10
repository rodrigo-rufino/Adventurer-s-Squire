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
                Dice d4 = new Dice(4);
                return d4;
            case 1:
                Dice d6 = new Dice(6);
                return d6;
            case 2:
                Dice d8 = new Dice(8);
                return d8;
            case 3:
                Dice d10 = new Dice(10);
                return d10;
            case 4:
                Dice d12 = new Dice(12);
                return d12;
            case 5:
                Dice d20 = new Dice(20);
                return d20;
            case 6:
                Dice d100 = new Dice(100);
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