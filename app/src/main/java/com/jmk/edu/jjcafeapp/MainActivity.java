package com.jmk.edu.jjcafeapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int REQUEST_CODE_RETURN = 1000;
    MyDBOpenHelper dbHelper;
    SQLiteDatabase mDB;
    Button buttonNewOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dbHelper = new MyDBOpenHelper(this, "jjcafe.db", null, 1);
        mDB = dbHelper.getWritableDatabase();

        buttonNewOrder= findViewById(R.id.buttonNewOrder);
        buttonNewOrder.setOnClickListener(this);


        Bundle bundle = getIntent().getExtras();
        ((TextView) findViewById(R.id.textViewOrdered)).setText(bundle.getString("Menu", "No Data"));

//        ((Button) findViewById(R.id.buttonSum)).setOnClickListener(this);
//        ((Button) findViewById(R.id.buttonCancel)).setOnClickListener(this);

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