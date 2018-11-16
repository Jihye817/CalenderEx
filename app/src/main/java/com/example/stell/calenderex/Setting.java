package com.example.stell.calenderex;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Button button = (Button)findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),Myinfo.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.button).setOnClickListener(m1ClickListener);
        findViewById(R.id.button3).setOnClickListener(m3ClickListener);
        findViewById(R.id.button4).setOnClickListener(m4ClickListener);
        findViewById(R.id.button5).setOnClickListener(m5ClickListener);
        findViewById(R.id.button6).setOnClickListener(m6ClickListener);
        findViewById(R.id.button7).setOnClickListener(m7ClickListener);
    }

    Button.OnClickListener m1ClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button:
                    new AlertDialog.Builder(Setting.this)
                            .setTitle("소리 및 알림 설정") // 팝업 타이틀바
                            .setMessage("준비 중입니다.") // 팝업창 내용
                            .setNeutralButton("닫기", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dlg, int sumthin) {
                                    // 닫기 버튼을 누르면 아무것도 안하고 닫기 때문에 근냥 비움
                                }
                            })
                            .show(); // 팝업창 보여줌
                    break;
            }
        }
    };

    Button.OnClickListener m3ClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button3:
                    new AlertDialog.Builder(Setting.this)
                            .setTitle("앱 정보") // 팝업 타이틀바
                            .setMessage("안녕하세요. <건강하냥> 입니다.\n" +
                                    "3인 개발이라 시간이 걸리는 점 양해 부탁드립니다.\n" +
                                    "귀여운 고양이 보며 힐링하세요^^\n" +
                                    "건강하냥@naver.com") // 팝업창 내용
                            .setNeutralButton("닫기", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dlg, int sumthin) {
                                    // 닫기 버튼을 누르면 아무것도 안하고 닫기 때문에 근냥 비움
                                }
                            })
                            .show(); // 팝업창 보여줌
                    break;
            }
        }
    };

    Button.OnClickListener m4ClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button4:
                    new AlertDialog.Builder(Setting.this)
                            .setTitle("공지사항") // 팝업 타이틀바
                            .setMessage("[서비스 관련] 업데이트 안내") // 팝업창 내용
                            .setNeutralButton("닫기", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dlg, int sumthin) {
                                    // 닫기 버튼을 누르면 아무것도 안하고 닫기 때문에 근냥 비움
                                }
                            })
                            .show(); // 팝업창 보여줌
                    break;
            }
        }
    };

    Button.OnClickListener m5ClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button5:
                    new AlertDialog.Builder(Setting.this)
                            .setTitle("계정 관리") // 팝업 타이틀바
                            .setMessage("준비 중입니다.") // 팝업창 내용
                            .setNeutralButton("닫기", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dlg, int sumthin) {
                                    // 닫기 버튼을 누르면 아무것도 안하고 닫기 때문에 근냥 비움
                                }
                            })
                            .show(); // 팝업창 보여줌
                    break;
            }
        }
    };

    Button.OnClickListener m6ClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button6:
                    new AlertDialog.Builder(Setting.this)
                            .setTitle("많이 묻는 질문") // 팝업 타이틀바
                            .setMessage("Q. 장난감은 어디에서 구하나요?\n" +
                                    "A. 장난감은 상점에서 포인트로 구입할 수 있습니다.") // 팝업창 내용
                            .setNeutralButton("닫기", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dlg, int sumthin) {
                                    // 닫기 버튼을 누르면 아무것도 안하고 닫기 때문에 근냥 비움
                                }
                            })
                            .show(); // 팝업창 보여줌
                    break;
            }
        }
    };

    Button.OnClickListener m7ClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button7:
                    new AlertDialog.Builder(Setting.this)
                            .setTitle("문의 및 의견") // 팝업 타이틀바
                            .setMessage("준비 중입니다.") // 팝업창 내용
                            .setNeutralButton("닫기", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dlg, int sumthin) {
                                    // 닫기 버튼을 누르면 아무것도 안하고 닫기 때문에 근냥 비움
                                }
                            })
                            .show(); // 팝업창 보여줌
                    break;
            }
        }
    };
}