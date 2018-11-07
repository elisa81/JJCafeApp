package com.jmk.edu.jjcafeapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.Date;

import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int REQUEST_CODE_RETURN = 1000;
    MyDBOpenHelper dbHelper;
    SQLiteDatabase mDB;
    Button buttonNewOrder;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new MyDBOpenHelper(this, "jjcafe.db", null, 1);
        mDB = dbHelper.getWritableDatabase();

        String[] FRUITS = new String[] { "Apple", "Avocado", "Banana","Blueberry"};
        listView = (ListView) findViewById(R.id.resultList);
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, R.layout.listview_single_column,FRUITS);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);



        buttonNewOrder= findViewById(R.id.buttonNewOrder);
        buttonNewOrder.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonNewOrder :

                Intent intent = new Intent(this,OrderActivity.class);
                startActivity(intent);
                break;

            default:
                break;
        }
    }
}