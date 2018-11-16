package com.example.stell.calenderex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EatDet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        final DBHelper dbHelper = new DBHelper(getApplicationContext(), "catDB", null, 1);
        setContentView(R.layout.activity_eat_det);

        TextView food_name = (TextView)findViewById(R.id.food_name);
        TextView food_kcal = (TextView)findViewById(R.id.eatdet_kcal);

        Intent intent = getIntent();
        final String month = intent.getStringExtra("month");
        final String dayOfMonth = intent.getStringExtra("dayOfMonth");
        final String data = intent.getStringExtra("fname");
        Log.i(this.getClass().getName(), data);
        food_name.setText(data);
        ab.setTitle("상세입력 : " + data);

        String[] farray = data.split("/");
        final String name = farray[0];
        final String cal = farray[1];
        food_kcal.setText(cal);

        String from = cal;
        final int to = Integer.parseInt(from);

        final String fulldate = month + dayOfMonth;

        long now = System.currentTimeMillis();
        Date nowtime = new Date(now);
        SimpleDateFormat sdfNow = new SimpleDateFormat("HH:mm");
        final String formatDate = sdfNow.format(nowtime);

        Button btnplus = (Button)findViewById(R.id.btn_plus);
        btnplus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //dbHelper.insert(날짜, 이름, 시간, 칼로리 );
                //Intent intent = new Intent(getApplicationContext(), EatInput.class);
                //startActivity(intent);
                dbHelper.insertFood(fulldate, name ,formatDate, to);
                finish();
            }
        });

        //Spinner
        Spinner numSpinner = (Spinner)findViewById(R.id.spinner_num);
        ArrayAdapter numAdapter = ArrayAdapter.createFromResource(this,
                R.array.eatdet_num, android.R.layout.simple_spinner_item);
        numAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        numSpinner.setAdapter(numAdapter);
    }
}
