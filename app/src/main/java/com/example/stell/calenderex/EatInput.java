package com.example.stell.calenderex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class EatInput extends AppCompatActivity {
    private List<String> list;          // 데이터를 넣은 리스트변수
    private ListView listView;          // 검색을 보여줄 리스트변수
    private EditText editSearch;        // 검색어를 입력할 Input 창
    private SearchAdapter adapter;      // 리스트뷰에 연결할 아답터
    private ArrayList<String> arraylist;
    private DBHelper dbHelper;
    //final DBHelper dbHelper = new DBHelper(getApplicationContext(), "catDB", null, 1);

    // book list
    List<FoodList> mFoodList = new ArrayList<FoodList>();
    private List<String> listFood;
    private ArrayList<String> arraylistFood;

    // book list class
    public class FoodList {
        public String foodName;
        public int foodCal;
    }

    private void settingFoodList(){

        //FoodList food = new FoodList();
        for(int i=0; i<29;i++){
            FoodList food = new FoodList();
            food.foodName = dbHelper.getFood(i);
            food.foodCal = dbHelper.getCal(i);
            mFoodList.add(food);
        }
        settingSearchList();
    }

    private void settingSearchList(){
        for(int i = 1; i < mFoodList.size(); i++){
            list.add(mFoodList.get(i).foodName + "/" + mFoodList.get(i).foodCal);
            listFood.add(mFoodList.get(i).foodName);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eat_input);
        //final DBHelper dbHelper = new DBHelper(getApplicationContext(), "catDB", null, 1);
        dbHelper = new DBHelper(this, "catDB",null,1);
        editSearch = (EditText) findViewById(R.id.editSearch);
        listView = (ListView) findViewById(R.id.listView);

        // 리스트를 생성한다.
        list = new ArrayList<String>();

        // 검색에 사용할 데이터을 미리 저장한다.
        //settingList();
        listFood = new ArrayList<String>();
        settingFoodList();

        arraylistFood = new ArrayList<String>();
        arraylistFood.addAll(listFood);

        // 리스트의 모든 데이터를 arraylist에 복사한다.// list 복사본을 만든다.
        arraylist = new ArrayList<String>();
        arraylist.addAll(list);

        // 리스트에 연동될 아답터를 생성한다.
        adapter = new SearchAdapter(list, this);

        // 리스트뷰에 아답터를 연결한다.
        listView.setAdapter(adapter);

        // input창에 검색어를 입력시 "addTextChangedListener" 이벤트 리스너를 정의한다.
        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                // input창에 문자를 입력할때마다 호출된다.
                // search 메소드를 호출한다.
                String text = editSearch.getText().toString();
                search(text);
            }
        });

        Intent intent = getIntent();
        final String data = intent.getStringExtra("month");
        final String data2 = intent.getStringExtra("dayOfMonth");
        final String fpagename = intent.getStringExtra("fpagename");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView editFood = (TextView)parent.getChildAt(position).findViewById(R.id.food_name_view);
                String food_name = editFood.getText().toString();

                Intent intent = new Intent(getApplicationContext(), EatDet.class);
                intent.putExtra("fname", food_name);
                intent.putExtra("month", data);
                intent.putExtra("dayOfMonth", data2);
                intent.putExtra("fpagename", fpagename);
                startActivity(intent);

            }
        });


    }

    // 검색을 수행하는 메소드
    public void search(String charText) {

        // 문자 입력시마다 리스트를 지우고 새로 뿌려준다.
        list.clear();

        // 문자 입력이 없을때는 모든 데이터를 보여준다.
        if (charText.length() == 0) {
            list.addAll(arraylist);
        }
        // 문자 입력을 할때..
        else
        {
            // 리스트의 모든 데이터를 검색한다.
            for(int i = 0;i < arraylist.size(); i++)
            {
                // arraylist의 모든 데이터에 입력받은 단어(charText)가 포함되어 있으면 true를 반환한다.
                if (arraylistFood.get(i).toLowerCase().contains(charText))
                {
                    // 검색된 데이터를 리스트에 추가한다.
                    list.add(arraylist.get(i));
                }
            }
        }
        // 리스트 데이터가 변경되었으므로 아답터를 갱신하여 검색된 데이터를 화면에 보여준다.
        adapter.notifyDataSetChanged();
    }

    // 검색에 사용될 데이터를 리스트에 추가한다.
    private void settingList(){

    }
}
