package com.example.stell.calenderex;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PageAdapter extends FragmentStatePagerAdapter{
    private int Pagenumber = 4;

    public PageAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position){
        switch (position){
            case 0:
                return CalBreakfast.newInstance();
            case 1:
                return CalLunch.newInstance();
            case 2:
                return CalDinner.newInstance();
            case 3:
                return CalWater.newInstance();
            default:
                return null;
        }
    }
    @Override
    public int getCount(){
        return Pagenumber;
    }

    @Override
    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "아침";
            case 1:
                return "점심";
            case 2:
                return "저녁";
            case 3:
                return "물";
                default:
                    return null;
        }
    }
}
