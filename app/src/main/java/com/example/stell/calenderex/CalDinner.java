package com.example.stell.calenderex;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalDinner extends Fragment {


    public CalDinner() {
        // Required empty public constructor
    }

    public static CalDinner newInstance(){
        Bundle args = new Bundle();

        CalDinner fragment = new CalDinner();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cal_dinner, container, false);
    }

}
