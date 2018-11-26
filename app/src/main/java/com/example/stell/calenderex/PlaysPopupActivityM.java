package com.example.stell.calenderex;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class PlaysPopupActivityM extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plays_popup_m);

        final DBHelper dbHelper = new DBHelper(getApplicationContext(), "catDB", null, 1);

        final TextView result = (TextView) findViewById(R.id.cat_mouse_result);
        result.setText(dbHelper.getResultPlay(3));
        result.setTextSize(22);
        result.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL);

        final ImageButton btnBuy = (ImageButton) findViewById(R.id.btn_buy);
        btnBuy.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String buyResult;
                String buy = "buy";
                String already = "already";
                buyResult=dbHelper.buyPlay(3);
                if(buyResult.equals(buy)) {// 구매 성공
                    Toast.makeText(PlaysPopupActivityM.this, "구매 성공!", Toast.LENGTH_SHORT).show();
                }
                else if(buyResult.equals(already)) { // 이미 존재하는 장난감
                    Toast.makeText(PlaysPopupActivityM.this, "이미 가지고 있는 장난감이네요!", Toast.LENGTH_SHORT).show();
                }
                else { // 구매 실패
                    Toast.makeText(PlaysPopupActivityM.this, "포인트가 모자라요ㅜㅜ.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
