package com.example.stell.calenderex;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;


public class CalMain extends AppCompatActivity {

    CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_main);

        calendarView = (CalendarView) findViewById(R.id.calendarView);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                int from = month+1;
                String to = Integer.toString(from);
                int from2 = dayOfMonth;
                String to2 = Integer.toString(from2);

                Intent intent = new Intent(getApplicationContext(), CalAll.class);
                intent.putExtra("month", to);
                intent.putExtra("dayOfMonth", to2);
                startActivity(intent);
            }
        });
    }
}
