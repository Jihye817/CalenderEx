package com.example.stell.calenderex;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalWater extends Fragment {


    public CalWater() {
        // Required empty public constructor
    }

    public static CalWater newInstance(){
        Bundle args = new Bundle();

        CalWater fragment = new CalWater();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cal_water, container, false);
    }

}
