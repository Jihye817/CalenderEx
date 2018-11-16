package com.example.stell.calenderex;

import android.content.Intent;
import android.graphics.Canvas;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

public class MainActivity extends AppCompatActivity {
    private ImageView cat;
    private int viewX;
    private int viewY;
    private int curX;
    private int curY;
    private int tempX = 0;
    private int tempY = 0;
    private int touchX;
    private int touchY;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        //gif설정
        cat = (ImageView) findViewById(R.id.cat_image);
        GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(cat);
        Glide.with(this).load(R.drawable.cat).into(gifImage);

        viewX = linearLayout.getWidth();
        viewY = linearLayout.getHeight();

        //이미지 이동
        linearLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                touchX = (int)event.getRawX();
                touchY = (int)event.getRawY();

                curX = (int)cat.getX()/2;
                curY = (int)cat.getY()/2;

                tempX = touchX - curX;
                tempY = touchY - curY;

                cat.animate().translationX(tempX);
                cat.animate().translationY(tempY);

                curX = (int)cat.getX()/2;
                curY = (int)cat.getY()/2;

                return true;
            }
        });


        //설정버튼
        Button btnsetting = (Button)findViewById(R.id.btn_setting);
        btnsetting.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), Setting.class);
                startActivity(intent);
            }
        });

        //식단버튼
        Button btncal = (Button)findViewById(R.id.btn_cal);
        btncal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), CalMain.class);
                startActivity(intent);
            }
        });

        //상점버튼
        Button btnstore = (Button)findViewById(R.id.btn_shop);
        btnstore.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), StoreActivity.class);
                startActivity(intent);
            }
        });

        //도감버튼
        Button btnibook = (Button)findViewById(R.id.btn_ibook);
        btnibook.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), IllustedActivity.class);
                startActivity(intent);
            }
        });

    }
}
