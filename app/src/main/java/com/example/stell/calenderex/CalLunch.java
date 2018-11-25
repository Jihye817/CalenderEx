package com.example.stell.calenderex;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalLunch extends Fragment {

    Button btn;

    public CalLunch() {
        // Required empty public constructor
    }

    public static CalLunch newInstance(){
        Bundle args = new Bundle();

        CalLunch fragment = new CalLunch();
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

        final String fpagename = "점심";
        final String fulldate = data + data2;

        View view = inflater.inflate(R.layout.fragment_cal_lunch,null);

//        int count = dbHelper.getFoodCount(fulldate, fpagename);
        //System.out.print(count);
        System.out.println("ㄱㄱㄱㄱㄱㄱ");

        FrameLayout layout = (FrameLayout) inflater.inflate(R.layout.fragment_cal_lunch, container, false);
        String[] list_food = {"아니음식ㄷ을", "나오게해달라고", "똥꼬들아"}; //임시 메뉴

        int nDatCnt = 0;
        ArrayList<ItemData> oData = new ArrayList<>();
        //String[] list_food =null;

        for(int i=0; i<3; i++)
        {

            //list_food[i] = dbHelper.getFoodData(i, fulldate, fpagename);
            System.out.println(list_food[i]);
            ItemData oItem = new ItemData();
            oItem.strTitle = "데이터" + (i+1);
            oItem.strCal = list_food[nDatCnt++];
            oData.add(oItem);
            if(nDatCnt >= list_food.length) nDatCnt = 0;
        }


        ListView listview = (ListView) layout.findViewById(R.id.list_food);

        //ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,list_food);
        ListAdapter listViewAdapter = new ListAdapter(oData);

        listview.setAdapter(listViewAdapter);

        // Button btn_eatinput = (Button)findViewById(R.id.btn_fplus);
        Button btn_eatinput = (Button)layout.findViewById(R.id.btn_fplus);

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
