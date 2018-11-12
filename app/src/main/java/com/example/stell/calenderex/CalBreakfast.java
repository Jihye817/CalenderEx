package com.example.stell.calenderex;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalBreakfast extends Fragment {

    Button btn;

    public CalBreakfast() {
        // Required empty public constructor
    }

    public static CalBreakfast newInstance(){
        Bundle args = new Bundle();

        CalBreakfast fragment = new CalBreakfast();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cal_breakfast,null);
        Button btn_eatinput = (Button) view.findViewById(R.id.btn);
        btn_eatinput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EatInput.class);
                startActivity(intent);
            }
        });
        return view;
       // return inflater.inflate(R.layout.fragment_cal_breakfast, container, false);
    }
}
