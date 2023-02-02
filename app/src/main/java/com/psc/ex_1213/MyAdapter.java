package com.psc.ex_1213;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<String> {

    Context context;
    ArrayList<String> arr;
    int resources;

    public MyAdapter(Context context, int resource, ArrayList<String> arr, ListView myList) {
        super(context, resource, arr);

        this.context = context;
        this.resources = resource; // R.layout.list_form
        this.arr = arr;

        // 리스트뷰에 클릭이벤트 감지자 등록
        myList.setOnItemClickListener(c_listener);

        // 리스트뷰에 롱클릭이벤트 감지자 등록
        myList.setOnItemLongClickListener(l_listener);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // getView() 메소드를 통해 listView에 추가될 항목을 표기하기위한 메소드

        LayoutInflater linf = (LayoutInflater)context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        convertView = linf.inflate(resources, null);
        // converView = list_form.xml

        String str = arr.get(position);
        TextView txt = convertView.findViewById(R.id.form_txt);

        txt.setText(str);
        return convertView;
    } // getView()

    // 리스트뷰 클릭이벤트 감지자
    AdapterView.OnItemClickListener c_listener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            Toast.makeText(context, arr.get(i), Toast.LENGTH_SHORT).show();

        }
    };

    // 리스트뷰 롱클릭이벤트 감지자
    AdapterView.OnItemLongClickListener l_listener = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

            arr.remove(i);
            notifyDataSetChanged(); // getView()를 갱신

            return true;
        }
    };
}
