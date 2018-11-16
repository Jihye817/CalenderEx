package com.example.stell.calenderex;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalAll extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cal_all);
        TextView monthee = (TextView)findViewById(R.id.monthee);
        TextView datee = (TextView)findViewById(R.id.datee);

        Intent intent = getIntent();
        String data = intent.getStringExtra("month");
        String data2 = intent.getStringExtra("dayOfMonth");
        monthee.setText(data);
        datee.setText(data2);

        PageAdapter pageAdapter = new PageAdapter(
                getSupportFragmentManager()
        );
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(pageAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

    }
}