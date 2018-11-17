package com.example.stell.calenderex;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalDinner extends Fragment {

    Button btn;

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
        Intent intent = getActivity().getIntent();
        final String data = intent.getStringExtra("month");
        final String data2 = intent.getStringExtra("dayOfMonth");

        View view = inflater.inflate(R.layout.fragment_cal_dinner,null);
        Button btn_eatinput = (Button) view.findViewById(R.id.btn);
        btn_eatinput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EatInput.class);
                intent.putExtra("month", data);
                intent.putExtra("dayOfMonth", data2);
                startActivity(intent);
            }
        });
        return view;
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_cal_dinner, container, false);
    }

}
