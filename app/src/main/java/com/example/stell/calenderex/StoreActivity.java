package com.example.stell.calenderex;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.widget.GridLayout;
import android.view.View;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

public class StoreActivity extends AppCompatActivity {

    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 타이틀 바 이름 바꾸기
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("Store");
        setContentView(R.layout.store_differ);

        mainGrid = (GridLayout) findViewById(R.id.mainGrid);

        setSingleEvent(mainGrid);

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

    }

    // 각각의 팝업창 띄우기
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
                            Intent intent0 = new Intent(StoreActivity.this, PlaysPopupActivityB.class);
                            startActivity(intent0);
                            break;
                        case 1:
                            Intent intent1 = new Intent(StoreActivity.this, PlaysPopupActivityM.class);
                            startActivity(intent1);
                            break;
                        case 2:
                            Intent intent2 = new Intent(StoreActivity.this, PlaysPopupActivityS.class);
                            startActivity(intent2);
                            break;
                        case 4:
                            Intent intent3 = new Intent(StoreActivity.this, FoodsPopupActivity1.class);
                            startActivity(intent3);
                            break;
                        default:
                    }
                }
            });
        }
    }
}
