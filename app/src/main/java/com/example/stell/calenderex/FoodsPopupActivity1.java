package com.example.stell.calenderex;

import android.app.Activity;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class FoodsPopupActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods_popup1);

        final DBHelper dbHelper = new DBHelper(getApplicationContext(), "catDB", null, 1);

        final TextView result = (TextView) findViewById(R.id.cat_feed_result);
        result.setText(dbHelper.getResultFeed());
        result.setTextSize(22);
        result.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL);

        final ImageButton btnBuy = (ImageButton) findViewById(R.id.btn_buy);
        btnBuy.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String buyResult;
                String buy = "buy";
                buyResult=dbHelper.buyFeed();
                if(buyResult.equals(buy)) {// 구매 성공
                    Toast.makeText(FoodsPopupActivity1.this, "구매 성공!", Toast.LENGTH_SHORT).show();
                }
                else{ // 구매 실패
                    Toast.makeText(FoodsPopupActivity1.this, "포인트가 모자라요ㅜㅜ.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
