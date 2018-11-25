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
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
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

       // int count = dbHelper.getFoodCount(fulldate, fpagename);
       // System.out.print(count);
        System.out.println("아침탭입니다");

        FrameLayout layout = (FrameLayout) inflater.inflate(R.layout.fragment_cal_breakfast, container, false);
        String[] list_food = {"가래떡", "가자미구이", "3분카레"}; //임시 메뉴
        String[] list_cal = {"120", "110", "175"};

        int nDatCnt = 0;
        ArrayList<ItemData> oData = new ArrayList<>();
        //String[] list_food =null;

        for(int i=0; i<3; i++)
        {

            //list_food[i] = dbHelper.getFoodData(i, fulldate, fpagename);
            System.out.println(list_food[i]);
            ItemData oItem = new ItemData();
            //oItem.strTitle = "데이터" + (i+1);
            oItem.strTitle = list_food[nDatCnt];
            oItem.strCal = list_cal[nDatCnt++];
            oData.add(oItem);
            if(nDatCnt >= list_food.length) nDatCnt = 0;
        }


        ListView listview = (ListView) layout.findViewById(R.id.list_food);

        //ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,list_food);
        ListAdapter listViewAdapter = new ListAdapter(oData);

        listview.setAdapter(listViewAdapter);

       // Button btn_eatinput = (Button)findViewById(R.id.btn_fplus);
        ImageButton btn_eatinput = (ImageButton)layout.findViewById(R.id.btn_fplus);

        btn_eatinput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EatInput.class);
                intent.putExtra("month", data);
                intent.putExtra("dayOfMonth", data2);
                intent.putExtra("fpagename", fpagename);
                startActivity(intent);
            }
        });

        return layout;
    }
}
