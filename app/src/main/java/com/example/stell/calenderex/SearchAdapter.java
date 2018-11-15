package com.example.stell.calenderex;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends BaseAdapter{
    //Adapter에 추가된 데이터를 저장하기 위한 Arraylist
    private ArrayList<EatArray> eatArrayItemList;

    //SearchAdapter의 생성자
    public SearchAdapter(ArrayList<EatArray> itemList){
        if(itemList == null){
            eatArrayItemList = new ArrayList<EatArray>();
        }
        else{
            eatArrayItemList = itemList;
        }
    }

    // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현(getCount가 필수적인 추상 메소드라 얘를 구현 안하면 에러남)
    @Override
    public int getCount() {
        return eatArrayItemList.size() ;
    }

    //position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. :필수 구현
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final int pos = position;
        final Context context = parent.getContext();

        //"row_listview" layout을 inflate하여 convertView 참조 획득.
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row_listview, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView textTextViewf = (TextView) convertView.findViewById(R.id.food_name_view) ;
        TextView textTextViewk = (TextView) convertView.findViewById(R.id.food_kcal_view) ;

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        EatArray eatArrayItem = eatArrayItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        textTextViewf.setText(eatArrayItem.getFood_name());
        textTextViewk.setText(Integer.toString(eatArrayItem.getFood_kcal()));

        return convertView;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) {
        return position ;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) {
        return eatArrayItemList.get(position) ;
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(String food_name, int food_kcal) {
        EatArray item = new EatArray();

        item.setFood_name(food_name);
        item.setFood_kcal(food_kcal);

        eatArrayItemList.add(item);
    }

    public ArrayList<EatArray> getItemList() {
        return eatArrayItemList ;
    }

    /*private Context context;
    private List<String> list;
    private LayoutInflater inflate;
    private ViewHolder viewHolder;

    public SearchAdapter(List<String> list, Context context){
        this.list = list;
        this.context = context;
        this.inflate = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if(convertView == null){
            convertView = inflate.inflate(R.layout.row_listview,null);

            viewHolder = new ViewHolder();
            viewHolder.label = (TextView) convertView.findViewById(R.id.label);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }

        // 리스트에 있는 데이터를 리스트뷰 셀에 뿌린다.
        viewHolder.label.setText(list.get(position));

        return convertView;
    }

    class ViewHolder{
        public TextView label;
    }*/
}
