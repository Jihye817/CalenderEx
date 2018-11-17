package com.example.stell.calenderex;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;


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
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final DBHelper dbHelper = new DBHelper(getActivity().getApplicationContext(), "catDB", null, 1);
        // Inflate the layout for this fragment
        Intent intent = getActivity().getIntent();
        final String data = intent.getStringExtra("month");
        final String data2 = intent.getStringExtra("dayOfMonth");

        final String fpagename = "아침";
        final String fulldate = data + data2;

        View view = inflater.inflate(R.layout.fragment_cal_breakfast,null);

       //final TableLayout table = (TableLayout)view.getRootView().findViewById(R.id.food_list_table);
        final TableLayout table = (TableLayout)view.findViewById(R.id.food_list_table);
        TableLayout.LayoutParams tableLayoutParams = new TableLayout.LayoutParams();

        TableRow.LayoutParams tableRowParams = new TableRow.LayoutParams();
        tableRowParams.setMargins(1, 1, 1, 1);
        tableRowParams.weight=1;

        int count = dbHelper.getFoodCount(fulldate, fpagename);
        System.out.print(count);
        System.out.println("ㄱㄱㄱㄱㄱㄱ");
        /*for(int i=0; i<2; i++){
            TableRow row = new TableRow(getActivity());

            row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

            TextView tv = new TextView(getActivity());
            tv.setText(i);

            row.addView(tv, tableRowParams);
            table.addView(row, tableLayoutParams);
        }*/
        /*for(int i=0; i<2; i++){
            System.out.print(dbHelper.getFoodCount(fulldate, fpagename));
            //make TR
            TableRow tr = new TableRow(getActivity());
            tr.setId(100 + i);
            tr.setLayoutParams(new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            tr.addView(tr, 101);

            //make TV to hold the details
            TextView detailstv = new TextView(getActivity());
            detailstv.setId(200+i);
            detailstv.setText(dbHelper.getFoodData(i, fulldate, fpagename));
            tr.addView(detailstv, 202);
            System.out.print(dbHelper.getFoodData(i, fulldate, fpagename));

            // Make TV to hold the detailvals

            TextView valstv = new TextView(getActivity());
            valstv.setId(300 + i);
            valstv.setText(dbHelper.getCalData(i, fulldate, fpagename));
            tr.addView(valstv, 303);
            System.out.print(dbHelper.getCalData(i, fulldate, fpagename));

            Button btndelete = new Button(getActivity());
            btndelete.setId(400 + i);
            btndelete.setText("삭제");
            tr.addView(btndelete, 404);

            table.addView(tr, new TableLayout.LayoutParams(ViewPager.LayoutParams.MATCH_PARENT, ViewPager.LayoutParams.WRAP_CONTENT));
        }

        Button btn_eatinput = (Button) view.findViewById(R.id.btn);
        //Button btndelete = (Button) view.findViewById(R.id.btn_delete);

        //input버튼
        btn_eatinput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EatInput.class);
                intent.putExtra("month", data);
                intent.putExtra("dayOfMonth", data2);
                intent.putExtra("fpagename", fpagename);
                startActivity(intent);
            }
        });*/

        //삭제버튼
        /*btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TableRow ftablerow = (TableRow)table.getChildAt(202);
                //int fdelete = ftablerow.getId();
                //String fdeletename = ftablerow.findViewById(fdelete).getText();
                //TableRow t = (TableRow) view;
                TableRow t = (TableRow) table.getChildAt(202);
                TextView firsttv = (TextView) t.getChildAt(0);
                TextView secondtv = (TextView) t.getChildAt(1);
                String firstText = firsttv.getText().toString();
                String secondText = secondtv.getText().toString();

                dbHelper.deleteFoodCal(fulldate, firstText ,fpagename);
                dbHelper.deleteFoodCal(fulldate, secondText ,fpagename);
                View view1 = inflater.inflate(R.layout.fragment_cal_breakfast, null);
            }
        });*/

        return view;
       // return inflater.inflate(R.layout.fragment_cal_breakfast, container, false);
    }

}
