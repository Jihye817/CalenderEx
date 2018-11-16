package com.example.stell.calenderex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Illusted_PopupW extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_illusted__popup_w);

        final DBHelper dbHelper = new DBHelper(getApplicationContext(), "catDB", null, 1);

        final TextView result = (TextView) findViewById(R.id.cat_w_result);
        result.setText(dbHelper.getResultCats(2));
        result.setTextSize(18);
        result.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL);

        final ImageButton btnBuy = (ImageButton) findViewById(R.id.btn_adopt);
        btnBuy.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String buyResult;
                String buy = "buy";
                String already = "already";
                buyResult=dbHelper.adoptCat(2);
                if(buyResult.equals(buy)) {// 구매 성공
                    Toast.makeText(Illusted_PopupW.this, "입양 성공!", Toast.LENGTH_SHORT).show();
                }
                else if(buyResult.equals(already)) { // 이미 존재하는 고앵
                    Toast.makeText(Illusted_PopupW.this, "이미 모시고 있는 주인님이네요!", Toast.LENGTH_SHORT).show();
                }
                else { // 구매 실패
                    Toast.makeText(Illusted_PopupW.this, "포인트가 모자라요ㅜㅜ.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
