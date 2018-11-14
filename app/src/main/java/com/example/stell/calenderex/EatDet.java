package com.example.stell.calenderex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class EatDet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eat_det);

        TextView food_name = (TextView)findViewById(R.id.food_name);

        Intent intent = getIntent();
        String data = intent.getStringExtra("fname");
        Log.i(this.getClass().getName(), data);
        food_name.setText(data);

        //Spinner
        Spinner numSpinner = (Spinner)findViewById(R.id.spinner_num);
        ArrayAdapter numAdapter = ArrayAdapter.createFromResource(this,
                R.array.eatdet_num, android.R.layout.simple_spinner_item);
        numAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        numSpinner.setAdapter(numAdapter);
    }
}
