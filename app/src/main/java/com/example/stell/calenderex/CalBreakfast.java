package com.example.stell.calenderex;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;


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

        Button.OnClickListener btnListener = new View.OnClickListener(){
            public void onClick(View v){
                switch (v.getId()){
                    case R.id.btn:
                        Intent intent = new Intent(v.getContext(), PopupActivity.class);
                        startActivityForResult(intent, 1);

                        break;
                }
            }
        };
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cal_breakfast, container, false);
    }
}
