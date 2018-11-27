package com.example.stell.calenderex;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;


public class CalMain extends AppCompatActivity {

    CalendarView calendarView;
    String date;
    String monthss;
    String fulldate;
    int sum;

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

        final DBHelper dbHelper = new DBHelper(getApplicationContext(), "catDB", null, 1);

        final TextView result = (TextView) findViewById(R.id.totalcal);

        long now = System.currentTimeMillis();
        Date date = new Date(now);

        SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
        fulldate = sdf.format(new Date());

        final int count;
        count = dbHelper.totalCalCount(fulldate);
        System.out.println(fulldate);

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cals;
                int sums=0;
                for(int i=0; i<count; i++)
                {
                    cals = dbHelper.getTotalCal(i,fulldate);

                    sums = sums + cals;
                    System.out.println(cals);
                }
                System.out.println(sums);
                int from = sums;
                String to = Integer.toString(from);
                result.setText(to);
                result.setTextSize(20);
            }
        });
    }
}
