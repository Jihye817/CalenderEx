package com.example.stell.calenderex;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper  extends SQLiteOpenHelper {

    // DBHelper 생성자로 관리할 DB 이름과 버전 정보를 받음
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // DB를 새로 생성할 때 호출되는 함수
    @Override
    public void onCreate(SQLiteDatabase db) {

        //새로운 테이블 생성
            db.execSQL("CREATE TABLE 'exercise' ( 'exe_no' INTEGER PRIMARY KEY AUTOINCREMENT, 'walk_count' INTEGER NOT NULL, 'walk_cal' INTEGER NOT NULL, 'walk_line' INTEGER NOT NULL )");
            db.execSQL("CREATE TABLE 'cal_exe' ( 'exe_cal_no' INTEGER PRIMARY KEY AUTOINCREMENT, 'exe_date' TEXT NOT NULL, 'total_walk' INTEGER NOT NULL, 'total_cal' INTEGER NOT NULL, 'total_line' INTEGER NOT NULL )");
            db.execSQL("CREATE TABLE 'myinfo' ( 'myinfo_no' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' INTEGER NOT NULL, 'sex' INTEGER NOT NULL, 'activity' INTEGER NOT NULL, 'age' INTEGER NOT NULL, 'height' INTEGER NOT NULL, 'weight' INTEGER NOT NULL, 'total_point' INTEGER NOT NULL, 'now_point' INTEGER NOT NULL )");
            db.execSQL("CREATE TABLE 'food' ( 'food_no' INTEGER PRIMARY KEY AUTOINCREMENT, 'food_kind' TEXT NOT NULL, 'food_cal' INTEGER NOT NULL )");
            db.execSQL("CREATE TABLE 'cal_food' ( 'cal_food_no' INTEGER PRIMARY KEY AUTOINCREMENT, 'food_date' TEXT NOT NULL, 'food_kind' TEXT NOT NULL, 'food_time' TEXT NOT NULL, 'food_cal' INTEGER NOT NULL )");

            db.execSQL("CREATE TABLE 'catfood' ( 'catfood_no' INTEGER PRIMARY KEY AUTOINCREMENT, 'catfood_name' TEXT NOT NULL, 'catfood_point' INTEGER NOT NULL, 'catfood_char' TEXT NOT NULL )");
            db.execSQL("CREATE TABLE 'cats' ( 'cats_no' INTEGER PRIMARY KEY AUTOINCREMENT, 'cat_level' INTEGER NOT NULL,'cat_name' TEXT NOT NULL,  'cat_food' TEXT NOT NULL, 'cat_play' TEXT NOT NULL, 'total_feed' INT NOT NULL, 'point' INTEGER)");
            db.execSQL("CREATE TABLE 'plays' ( 'plays_no' INTEGER PRIMARY KEY AUTOINCREMENT, 'plays_name' TEXT NOT NULL, 'plays_point' INTEGER NOT NULL, 'plays_char' TEXT NOT NULL )");
            db.execSQL("CREATE TABLE 'user_item' ( 'item_no' INTEGER PRIMARY KEY AUTOINCREMENT, 'feed_count' INTEGER NOT NULL, 'ball' INTEGER NOT NULL, 'stick' INTEGER NOT NULL, 'mouse' INTEGER NOT NULL , '노랑이' INTEGER NOT NULL, '하양이' INTEGER NOT NULL, '까망이' INTEGER NOT NULL)");
            //  db.execSQL("CREATE TABLE sqlite_sequence(name,seq)");

        // 초깃값 설정
        // food table
        db.execSQL("INSERT INTO food VALUES (null, '3분카레', 175)");
        db.execSQL("INSERT INTO food VALUES (null, '가래떡', 120)");
        db.execSQL("INSERT INTO food VALUES (null, '가야토마토농장', 92)");
        db.execSQL("INSERT INTO food VALUES (null, '가야포도농장', 92)");
        db.execSQL("INSERT INTO food VALUES (null, '가자미구이', 110)");
        db.execSQL("INSERT INTO food VALUES (null, '가자미식혜', 400)");
        db.execSQL("INSERT INTO food VALUES (null, '가자미양념구이', 170)");
        db.execSQL("INSERT INTO food VALUES (null, '가자미조림', 130)");
        db.execSQL("INSERT INTO food VALUES (null, '가자미찜', 400)");
        db.execSQL("INSERT INTO food VALUES (null, '가지냉국', 50)");
        db.execSQL("INSERT INTO food VALUES (null, '가지볶음', 50)");
        db.execSQL("INSERT INTO food VALUES (null, '가지양념구이', 160)");
        db.execSQL("INSERT INTO food VALUES (null, '가지장아찌', 30)");
        db.execSQL("INSERT INTO food VALUES (null, '가지조림', 50)");
        db.execSQL("INSERT INTO food VALUES (null, '갈비구이', 220)");
        db.execSQL("INSERT INTO food VALUES (null, '갈비탕', 450)");
        db.execSQL("INSERT INTO food VALUES (null, '갈치구이', 130)");
        db.execSQL("INSERT INTO food VALUES (null, '갈치양념구이', 180)");
        db.execSQL("INSERT INTO food VALUES (null, '갈치조림', 150)");
        db.execSQL("INSERT INTO food VALUES (null, '감', 100)");
        db.execSQL("INSERT INTO food VALUES (null, '감자고구마볶음', 80)");
        db.execSQL("INSERT INTO food VALUES (null, '감자깡', 481)");
        db.execSQL("INSERT INTO food VALUES (null, '감자달걀국', 90)");
        db.execSQL("INSERT INTO food VALUES (null, '감자밥', 440)");
        db.execSQL("INSERT INTO food VALUES (null, '감자버터구이', 150)");
        db.execSQL("INSERT INTO food VALUES (null, '감자샐러드', 183)");
        db.execSQL("INSERT INTO food VALUES (null, '감자샐러드', 184)");
        db.execSQL("INSERT INTO food VALUES (null, '감자수제비', 390)");

        //cafood table
        db.execSQL("INSERT INTO catfood VALUES (null, 'feed', 100, '고양이가 즐겨먹는 사료이다.')");

        //cats table
        db.execSQL("INSERT INTO cats VALUES(null,  0, '노랑이', 'feed', 'Ball',0, 0)");
        db.execSQL("INSERT INTO cats VALUES(null,  0, '하양이', 'feed', 'Mouse', 0,10000)");
        db.execSQL("INSERT INTO cats VALUES(null,  0, '까망이', 'feed', 'Stick',0, 20000)");

        //plays table
        db.execSQL("INSERT INTO plays VALUES(null, 'Ball', 600, '고양이가 굴리며 노는 공입니다.')");
        db.execSQL("INSERT INTO plays VALUES(null, 'Stick', 600, '고양이가 잡기놀이를 하는 막대입니다.')");
        db.execSQL("INSERT INTO plays VALUES(null, 'Mouse', 600, '고양이가 쫒아다니는 쥐모양 인형입니다.')");

        // 임시파일
        db.execSQL("INSERT INTO myinfo VALUES(null, '박밀레', 1, 3, 4, 200, 100, 0, 10000)");
        db.execSQL("INSERT INTO user_item VALUES(null, 0,0,0,0,0,0,0)");
       // db.execSQL("INSERT INTO myinfo VALUES(null, '최대충', 2, 1, 5, 50, 25, 0, 200)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(String name, int level, String food, String play) {
        // 읽고 쓰기가 가능하게 DB 열기
        SQLiteDatabase db = getWritableDatabase();
        // DB에 입력한 값으로 행 추가
        db.execSQL("INSERT INTO cats VALUES(null, '"+ name + "', " + level +", '"+ food +"', '"+ play +"');");
        db.close();
    }

    // food 테이블 데이터 뽑기
    public String getResult() {
        //읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        // food 테이블 데이터 출력 예시
        Cursor cursor = db.rawQuery("SELECT * FROM food WHERE food_cal=80", null);
        while (cursor.moveToNext()) {
            result += cursor.getInt(0)
                    + " : "
                    + cursor.getString(1)
                    + " : "
                    + cursor.getInt(2)
                    + "\n";
        }
        return result;
    }

    // cal_food 테이블 데이터 추가
    public void insertFood(String date, String kind, String time, int cal) {
        SQLiteDatabase db = getWritableDatabase();
        // DB에 입력한 값으로 행 추가
        db.execSQL("INSERT INTO cal_food VALUES(null, '"+ date + "', '" + kind +"', '"+time +"', "+ cal+");");
        db.close();
    }

    // cal_food 의 count 데이터 구하기
    public int getFoodCount(String date, String time) {
        int count=0;
        SQLiteDatabase db = getReadableDatabase();
        // DB에서 찾기
        Cursor cursor = db.rawQuery("SELECT * FROM cal_food WHERE food_date = '"+ date + "' & food_time = '" + time + "'", null);
        count = cursor.getCount();
        return count;
    }

    // cal_food 테이블 음식 데이터 뽑기
    public String getFoodData(int i, String date, String time) {
        // 변수선언
        SQLiteDatabase db = getReadableDatabase();
        String result = "";
        // 위치 이동 ( 행이동 )
        Cursor cursor = db.rawQuery("SELECT * FROM cal_food WHERE food_date = '"+ date + "' & food_time = '" + time + "'", null);
        cursor.moveToPosition(i);
        result += cursor.getString(2);
        // return 값
        return result;
    }

    // cal_food 테이블 칼로리 데이터 뽑기
    public int getCalData(int i, String date, String time) {
        // 변수 선언
        SQLiteDatabase db = getReadableDatabase();
        int result = 0;
        // 위치 이동 ( 행 이동)
        Cursor cursor = db.rawQuery("SELECT * FROM cal_food WHERE food_date = '"+ date + "' & food_time = '" + time + "'", null);
        cursor.moveToPosition(i);
        result += cursor.getInt(4);
        // return 값
        return result;
    }

    // cal_food 테이블 데이터 삭제하기
    public void deleteFoodCal(String date, String kind, String time) {
        // 변수 선언
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM cal_food WHERE food_date = '" + date + "' & food_kind = '" + kind + "' & food_time = '" + time +"';");
        db.close();
    }

    // cats 테이블 데이터 뽑기
    public String getResultCats(int i) {
        // 읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        String  result = "";
        String sql = "";
        sql += "SELECT * FROM cats WHERE cats_no ="+i;

        Cursor cursor = db.rawQuery(sql , null);
        while(cursor.moveToNext()) {
            result += "Lv." + cursor.getInt(1)
                    + "\t\t"
                    + cursor.getString(2)
                    + "\n"
                    + "좋아하는 음식과 장난감\n"
                    + cursor.getString(3)
                    + "  /  "
                    + cursor.getString(4)
                    + "\n"
                    + "Point : "
                    + cursor.getInt(6);
        }
        return result;
    }

    // cat_food 테이블 데이터 뽑기
    public String getResultFeed() {

        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        //feed 데이터 출력
        Cursor cursor = db.rawQuery("SELECT * FROM catfood", null);
        while(cursor.moveToNext()) {
            result += cursor.getString(1)
                    + "\n\n"
                    + cursor.getString(3)
                    + "\n\nPoint : "
                    + cursor.getInt(2);
        }
        return result;
    }

    // cat_play 테이블 데이터 뽑기
    public String getResultPlay(int i) {

        SQLiteDatabase db = getReadableDatabase();
        String result = "";
        String play = "";
        switch(i) {
            case 1 :
                play = "Ball";
                break;
            case 2:
                play = "Stick";
                break;
            case 3:
                play = "Mouse";
                break;
        }
        String sql = "SELECT * FROM plays WHERE plays_name = "+ '"' + play + '"';

        // play 데이터 출력
        Cursor cursor = db.rawQuery(sql, null);
        while(cursor.moveToNext()) {
            result += cursor.getString(1)
                    + "\n\n"
                    + cursor.getString(3)
                    + "\n\nPoint\t\t:\t\t"
                    + cursor.getInt(2);
        }
        return result;
    }

    // 현재 point 조회
    public String nowPoint() {
        //DB 열기
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        Cursor cursor = db.rawQuery("SELECT * FROM myinfo", null);
        while(cursor.moveToNext()) {
            result += "현재 포인트 : "
                    + cursor.getInt(8);
        }
        return result;
    }

    // 식단 리스트 불러오기
    public String getFood(int i) {
        // DB 열기
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        Cursor cursor = db.rawQuery("SELECT * FROM food WHERE food_no = " + i, null);
        while(cursor.moveToNext()) {
            result += cursor.getString(1);
        }
        return result;
    }

    // 칼로리 리스트 불러오기
    public int getCal(int i) {
        // DB 열기
        SQLiteDatabase db = getReadableDatabase();
        int result = 0;

        Cursor cursor = db.rawQuery("SELECT * FROM food WHERE food_no = " + i, null);
        while(cursor.moveToNext()) {
            result += cursor.getInt(2);
        }
        return result;
    }

    // cat_food 구매
    public String buyFeed() {

        // 읽고 쓰기가 가능하게 DB 열기
        SQLiteDatabase db = getWritableDatabase();
        // 변수 선언
        int feedPoint=0; // feed 가격
        int userPoint=0; // user의 현재 point
        int feedCount=0; // 현재 먹이 개수
        String result; // return 값
        //point 비교
        Cursor cursor = db.rawQuery("SELECT * FROM catfood", null);
        while(cursor.moveToNext()) {
            feedPoint += cursor.getInt(2);
        }
        Cursor cursor1 = db.rawQuery("SELECT * FROM myinfo", null);
        while(cursor1.moveToNext()) {
            userPoint += cursor1.getInt(8);
        }
        Cursor cursor2 = db.rawQuery("SELECT * FROM user_item", null);
        while(cursor2.moveToNext()) {
            feedCount = cursor2.getInt(1);
        }
        if(userPoint>=feedPoint) { //구매 가능
            // 포인트 감소
            userPoint = userPoint-feedPoint;
            // 먹이수 증가
            feedCount += 1;
            // sql 작성
            String sql1 = "UPDATE myinfo SET now_point = " + userPoint;
            String sql2 = "UPDATE user_item SET feed_count = " + feedCount;
            // table update
            db.execSQL(sql1);
            db.execSQL(sql2);
            result = "buy";
            // update table 확인
            Cursor cursor5 = db.rawQuery("SELECT * FROM myinfo", null);
            int temp = 0;
            while(cursor5.moveToNext()){
                temp = cursor5.getInt(8);
            }
            Cursor cursor3 = db.rawQuery("SELECT * FROM user_item", null);
            int temp2 = 0;
            while(cursor3.moveToNext()) {
                temp2 = cursor3.getInt(1);
            }
            return result;
        }
        else { //구매 불가능
            result = "fail";
            return result;
        }
    }

    // cat_play 구매
    public String buyPlay(int i) {

        // 읽고 쓰기가 가능하게 DB 열기
        SQLiteDatabase db = getWritableDatabase();
        // 변수 선언
        int playPoint = 0; // play 가격
        int userPoint = 0; // user의 현재 point
        int playCount = 0; // play 갯수
        String result = "";
        String play = "";
        switch(i) {
            case 1 :
                play = "Ball";
                break;
            case 2:
                play = "Stick";
                break;
            case 3:
                play = "Mouse";
                break;
        }
        // SQL 작성
        String sql = "SELECT * FROM plays WHERE plays_name = "+ "'" + play + "'";
        // point 비교
        Cursor cursor = db.rawQuery(sql, null);
        while(cursor.moveToNext()) {
            playPoint = cursor.getInt(2);
        }
        Cursor cursor1 = db.rawQuery("SELECT * FROM myinfo", null);
        while(cursor1.moveToNext()) {
            userPoint += cursor1.getInt(8);
        }
        Cursor cursor2 = db.rawQuery("SELECT * FROM user_item", null);
        while(cursor2.moveToNext()) {
            playCount += cursor2.getInt(i+1);
        }
        while(playCount==0) {
            if(userPoint>=playPoint) {// 구매 가능
                // 포인트 감소
                userPoint = userPoint-playPoint;
                // 장난감 수 증가
                playCount+=1;
                // sql 작성
                String sql1 = "UPDATE myinfo SET now_point = " + userPoint;
                String sql2 = "UPDATE user_item SET " + play + " = " + playCount;
                db.execSQL(sql1);
                db.execSQL(sql2);
                result = "buy";
                // update 테이블 확인
                Cursor cursor3 = db.rawQuery("SELECT * FROM myinfo", null);
                int temp1=0;
                int temp2 =0;
                while(cursor3.moveToNext()) {
                    temp1 += cursor3.getInt(8);
                }
                Cursor cursor4 = db.rawQuery("SELECT * FROM user_item", null);
                while(cursor4.moveToNext()) {
                    temp2 += cursor4.getInt(i+1);
                }
                result = "buy";
                return result;
            }
            else { // 구매 불가능
                result = "fail";
                return result;
            }
        }
        result = "already";
        return result;
    }

    // cat 입양
    public String adoptCat(int i) {

        // 읽고 쓰기가 가능하게 DB 열기
        SQLiteDatabase db = getWritableDatabase();
        // 변수 선언
        int catPoint = 0; // cat 가격
        int userPoint = 0; // user의 현재 point
        int catCount = 0; // cat 갯수
        String result = "";
        String cat = "";
        switch(i) {
            case 1 :
                cat = "노랑이";
                break;
            case 2:
                cat = "하양이";
                break;
            case 3:
                cat = "까망이";
                break;
        }
        // SQL 작성
        String sql = "SELECT * FROM cats WHERE cats_no = " + i ;
        // point 비교
        Cursor cursor = db.rawQuery(sql, null);
        while(cursor.moveToNext()) {
            catPoint = cursor.getInt(6);
        }
        Cursor cursor1 = db.rawQuery("SELECT * FROM myinfo", null);
        while(cursor1.moveToNext()) {
            userPoint += cursor1.getInt(8);
        }
        Cursor cursor2 = db.rawQuery("SELECT * FROM user_item", null);
        while(cursor2.moveToNext()) {
            catCount += cursor2.getInt(i+4);
        }
        while(catCount==0) {
            if(userPoint>=catPoint) {// 구매 가능
                // 포인트 감소
                userPoint = userPoint-catPoint;
                // 고양이 수 증가
                catCount+=1;
                // sql 작성
                String sql1 = "UPDATE myinfo SET now_point = " + userPoint;
                String sql2 = "UPDATE user_item SET " + cat + " = " + catCount;
                db.execSQL(sql1);
                db.execSQL(sql2);
                result = "buy";
                // update 테이블 확인
                Cursor cursor3 = db.rawQuery("SELECT * FROM myinfo", null);
                int temp1=0;
                int temp2 =0;
                while(cursor3.moveToNext()) {
                    temp1 += cursor3.getInt(8);
                }
                Cursor cursor4 = db.rawQuery("SELECT * FROM user_item", null);
                while(cursor4.moveToNext()) {
                    temp2 += cursor4.getInt(i+4);
                }
                System.out.println(temp1);
                System.out.println(temp2);
                result = "buy";
                return result;
            }
            else { // 구매 불가능
                result = "fail";
                return result;
            }
        }
        result = "already";
        return result;
    }

}



