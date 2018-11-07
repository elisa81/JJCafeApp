package com.jmk.edu.jjcafeapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.Date;

import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MyDBOpenHelper dbHelper;

    Button buttonNewOrder,buttonCancel,buttonSum;

    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new MyDBOpenHelper(this, "jjcafe.db", null, 1);

        ((Button) findViewById(R.id.buttonNewOrder)).setOnClickListener(this);
        ((Button) findViewById(R.id.buttonSum)).setOnClickListener(this);
        ((Button) findViewById(R.id.buttonCancel)).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonNewOrder :
                Intent intent=null;
                intent = new Intent(this,OrderActivity.class);
                startActivity(intent);

                break;
            case R.id.buttonSum :



                break;
            case R.id.buttonCancel :
                break;
            default:
                break;
        }
    }
}