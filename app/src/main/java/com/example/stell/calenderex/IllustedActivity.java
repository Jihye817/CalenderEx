package com.example.stell.calenderex;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

public class IllustedActivity extends AppCompatActivity {

    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("Illusted Book");
        setContentView(R.layout.activity_illusted);

        final DBHelper dbHelper = new DBHelper(getApplicationContext(), "catDB", null, 1);

        final TextView result = (TextView) findViewById(R.id.nowPoint);
        result.setText(dbHelper.nowPoint());
        result.setTextSize(22);
        result.setTextColor(Color.BLACK);
        result.setGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL);

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(dbHelper.nowPoint());
                result.setTextSize(22);
                result.setTextColor(Color.BLACK);
                result.setGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL);
            }});

        mainGrid = (GridLayout) findViewById(R.id.mainGrid);

        setSingleEvent(mainGrid);
    }

    private void setSingleEvent(GridLayout mainGrid) {
        //loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //you can see, all child item is CardView, so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    switch (finalI)
                    {
                        case 0 :
                            Intent intent0 = new Intent(IllustedActivity.this, Illusted_PopupB.class);
                            startActivity(intent0);
                            break;
                        case 1:
                            Intent intent1 = new Intent(IllustedActivity.this, Illusted_PopupW.class);
                            startActivity(intent1);
                            break;
                        case 2:
                            Intent intent2 = new Intent(IllustedActivity.this, Illusted_PopupY.class);
                            startActivity(intent2);
                            break;
                        default:
                    }
                }
            });
        }
    }
}
