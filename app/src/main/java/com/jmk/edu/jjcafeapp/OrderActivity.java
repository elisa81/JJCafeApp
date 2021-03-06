package com.jmk.edu.jjcafeapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    MyDBOpenHelper dbHelper;
    SQLiteDatabase mdb;
    Button buttonCancel, buttonInsert;
    TextView textViewOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        dbHelper = new MyDBOpenHelper(this, "jjcafe.db", null, 1);
        mdb = dbHelper.getWritableDatabase();

//        String[] FOODS = {"아메리카노", "카페라떼", "햄 토스트", "샌드위치", "스콘"};
//        ListView listView = (ListView) findViewById(R.id.menuList);
//
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_order, FOODS);
//        listView.setAdapter(arrayAdapter);
//        listView.setOnItemClickListener(this);


        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        List<String> list = new ArrayList<String>();
        list.add("메뉴를 선택해주세요");
        list.add("아메리카노");
        list.add("카페라떼");
        list.add("햄 토스트");
        list.add("샌드위치");
        list.add("스콘");
        ArrayAdapter<String> dataAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(this);




    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonInsert:
                SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
                String datetime = format.format(new Date());
                mdb.execSQL("INSERT INTO jjcafe_ordered_list VALUES( '" + datetime + "', '', 'not-payed');");

                Intent intent = null;
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;

            case R.id.buttonCancel:
                finish();
                break;

            default:
                break;
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        TextView textViewOrder = (TextView) findViewById(R.id.textViewOrder);
        textViewOrder.setText(text);

//        Bundle bundle = new Bundle();
//        bundle.putString("Menu", text);
//        Intent intent = new Intent(this, MainActivity.class);
//        intent.putExtras(bundle);
//        startActivity(intent);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}